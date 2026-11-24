package report;

import java.math.BigDecimal;
import java.time.LocalDate;
import model.Transaction;
import model.account;
import model.loanAccount;
import service.Bank;

public class DailyReport {

    public void generateEndOfDayReport(Bank bank) {
        System.out.println("\n==========================================");
        System.out.println("   BANK END-OF-DAY REPORT (" + LocalDate.now() + ")");
        System.out.println("==========================================");
        System.out.println("Total Customers     : " + bank.getCustomers().size());
        System.out.println("Total Accounts      : " + bank.getAccounts().size());

        BigDecimal totalDeposits = BigDecimal.ZERO;
        BigDecimal totalLoanReceivables = BigDecimal.ZERO;
        int todaysTransactionCount = 0;
        int activeAccounts = 0;
        int closedAccounts = 0;

        for (account acc : bank.getAccounts().values()) {
            if (acc.getStatus() == enums.status.active) activeAccounts++;
            else if (acc.getStatus() == enums.status.closed) closedAccounts++;

            if (acc.getStatus() != enums.status.closed && acc instanceof loanAccount) {
                totalLoanReceivables = totalLoanReceivables.add(acc.getBalance());
            } else if (acc.getStatus() != enums.status.closed) {
                totalDeposits = totalDeposits.add(acc.getBalance());
            }

            for (Transaction tx : acc.getTransactions()) {
                if (tx.getTransactionDate().equals(LocalDate.now())) {
                    todaysTransactionCount++;
                }
            }
        }

        System.out.println("Active Accounts     : " + activeAccounts);
        System.out.println("Closed Accounts     : " + closedAccounts);
        System.out.printf("Total Bank Deposits : %.2f%n", totalDeposits);
        System.out.printf("Total Loan Due      : %.2f%n", totalLoanReceivables);
        System.out.println("Transactions Today  : " + todaysTransactionCount);
        System.out.println("==========================================\n");
    }
}
