package controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import enums.AccountType;
import enums.status;
import model.*;
import report.DailyReport;
import service.Bank;

public class AccountMenu {

    private final Bank bank = new Bank();
    private final DailyReport dailyReport = new DailyReport();
    private final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        new AccountMenu().start();
    }
    
    public void start() {
        while (true) {
            System.out.println("\n=== CORE BANKING SYSTEM ===");
            System.out.println("1. Register Customer (Individual / Corporate)");
            System.out.println("2. Open Account (Savings / Current / Salary / Loan)");
            System.out.println("3. Deposit / Pay Loan EMI");
            System.out.println("4. Withdraw Funds");
            System.out.println("5. Transfer Funds");
            System.out.println("6. View Account Details & Statement");
            System.out.println("7. View Customer Portfolio");
            System.out.println("8. Calculate Interest");
            System.out.println("9. Close Account");
            System.out.println("10. Generate Daily Bank Report");
            System.out.println("11. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1": registerCustomer(); break;
                    case "2": openAccount(); break;
                    case "3": handleDeposit(); break;
                    case "4": handleWithdraw(); break;
                    case "5": handleTransfer(); break;
                    case "6": viewAccount(); break;
                    case "7": viewCustomerPortfolio(); break;
                    case "8": applyInterest(); break;
                    case "9": closeAccount(); break;
                    case "10": dailyReport.generateEndOfDayReport(bank); break;
                    case "11":
                        System.out.println("Exiting Core Banking System. Goodbye.");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void registerCustomer() {
        System.out.print("Customer Type (1 = Individual, 2 = Corporate): ");
        String type = scanner.nextLine().trim();
        if (!"1".equals(type) && !"2".equals(type)) {
            throw new IllegalArgumentException("Invalid customer type selected.");
        }
        System.out.print("Customer ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Name / Company Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Address: ");
        String address = scanner.nextLine().trim();

        customer cust;
        if ("1".equals(type)) {
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            LocalDate dob = LocalDate.parse(scanner.nextLine().trim());
            System.out.print("PAN Number: ");
            String pan = scanner.nextLine().trim();
            cust = new IndividualCustomer(id, name, phone, email, address, dob, pan);
        } else if ("2".equals(type)) {
            System.out.print("Company Registration No: ");
            String regNo = scanner.nextLine().trim();
            System.out.print("GST Number: ");
            String gst = scanner.nextLine().trim();
            cust = new CorporateCustomer(id, name, phone, email, address, regNo, gst);
        } else {
            throw new IllegalArgumentException("Invalid customer type selected.");
        }
        
        bank.addCustomer(cust);
        System.out.println("Customer registered successfully.");
    }

    private void openAccount() {
        System.out.print("Existing Customer ID: ");
        String custId = scanner.nextLine().trim();
        customer cust = bank.findCustomer(custId);
        if (cust == null) {
            throw new IllegalArgumentException("Customer not found. Register customer first.");
        }

        String accNo = bank.generateUniqueAccountNo();
        System.out.print("Account Type (savings / current / salary / loan): ");
        AccountType type = AccountType.valueOf(scanner.nextLine().trim().toLowerCase());
        System.out.print("Initial Amount / Loan Principal: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine().trim());

        account newAcc;
        switch (type) {
            case savings:
                newAcc = new savingAccount(accNo, type, amount, status.active, cust, LocalDate.now(), new BigDecimal("10000"));
                break;
            case current:
                newAcc = new currentAccount(accNo, type, amount, status.active, cust, LocalDate.now(), new BigDecimal("50000"), new BigDecimal("1.5"));
                break;
            case salary:
                newAcc = new salaryAccount(accNo, type, amount, status.active, cust, LocalDate.now(), BigDecimal.ZERO, LocalDate.now());
                break;
            case loan:
                System.out.print("Annual Interest Rate (%): ");
                BigDecimal rate = new BigDecimal(scanner.nextLine().trim());
                System.out.print("Tenure (months): ");
                int months = Integer.parseInt(scanner.nextLine().trim());
                newAcc = new loanAccount(accNo, type, amount, status.active, cust, LocalDate.now(), rate, months);
                break;
            default:
                throw new IllegalArgumentException("Unsupported account type.");
        }

        bank.addAccount(newAcc);
        System.out.println("Account opened and linked to customer successfully.");
        System.out.println("Generated Account Number: " + newAcc.getAccountNo());
        System.out.println("Please save this account number for future transactions.");
    }

    private void handleDeposit() {
        account acc = getRequiredAccount();
        System.out.print("Amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine().trim());

        if (acc instanceof loanAccount) {
            ((loanAccount) acc).payLoanInstallment(amount);
            System.out.println("Loan installment paid.");
        } else if (acc instanceof salaryAccount) {
            ((salaryAccount) acc).depositSalary(amount);
            System.out.println("Salary deposited.");
        } else {
            acc.deposit(amount);
            System.out.println("Amount deposited.");
        }
    }

    private void handleWithdraw() {
        account acc = getRequiredAccount();
        System.out.print("Withdrawal Amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine().trim());

        acc.withdraw(amount);
        System.out.println("Withdrawal successful.");
    }

    private void handleTransfer() {
        System.out.print("From Account Number: ");
        String from = scanner.nextLine().trim();
        System.out.print("To Account Number: ");
        String to = scanner.nextLine().trim();
        System.out.print("Transfer Amount: ");
        BigDecimal amount = new BigDecimal(scanner.nextLine().trim());

        bank.transferFunds(from, to, amount);
        System.out.println("Transfer completed successfully.");
    }

    private void viewAccount() {
        account acc = getRequiredAccount();
        acc.displayDetails();
        System.out.println("\n--- Transaction History ---");
        acc.displayTransactionHistory();
        System.out.println();
    }

    private void viewCustomerPortfolio() {
        System.out.print("Enter Customer ID: ");
        String custId = scanner.nextLine().trim();
        customer cust = bank.findCustomer(custId);
        if (cust == null) {
            throw new IllegalArgumentException("Customer not found.");
        }

        System.out.println("\n--- Customer Portfolio ---");
        System.out.println(cust);
        if (cust.getOwnedAccounts().isEmpty()) {
            System.out.println("No accounts linked to this customer.");
        } else {
            for (account acc : cust.getOwnedAccounts()) {
                System.out.printf(" -> [%s] %s | Balance: %.2f | Status: %s%n",
                        acc.getAccounttype(), acc.getAccountNo(), acc.getBalance(), acc.getStatus());
            }
        }
    }

    private void applyInterest() {
        account acc = getRequiredAccount();
        BigDecimal interest = acc.calculateInterest();
        System.out.printf("Calculated Interest: %.2f%n", interest);
    }

    private void closeAccount() {
        System.out.print("Account Number to Close: ");
        String accNo = scanner.nextLine().trim();
        BigDecimal payout = bank.closeAccount(accNo);
        System.out.println("Account closed successfully.");
        if (payout.compareTo(BigDecimal.ZERO) > 0) {
            System.out.printf("Final closure payout: %.2f%n", payout);
        }
    }

    private account getRequiredAccount() {
        System.out.print("Account Number: ");
        String accNo = scanner.nextLine().trim();
        account acc = bank.findAccount(accNo);
        if (acc == null) {
            throw new IllegalArgumentException("Account not found: " + accNo);
        }
        return acc;
    }

   
}
