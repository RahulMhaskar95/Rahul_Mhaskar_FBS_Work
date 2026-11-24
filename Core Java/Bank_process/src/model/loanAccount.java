package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

import enums.AccountType;
import enums.TransactionType;
import enums.status;

public class loanAccount extends account {

    protected BigDecimal loanAmount;
    protected BigDecimal annualInterestRate;
    protected int tenureMonths;

    public loanAccount(String accountNo, AccountType accounttype, BigDecimal loanAmount,
                       status status, customer customer, LocalDate localdate,
                       BigDecimal annualInterestRate, int tenureMonths) {
        super(accountNo, accounttype, loanAmount, status, customer, localdate);

        if (accounttype != AccountType.loan) {
            throw new IllegalArgumentException("Invalid account type for a Loan Account");
        }

        this.loanAmount = Objects.requireNonNull(loanAmount, "Loan amount cannot be null");
        this.annualInterestRate = Objects.requireNonNull(annualInterestRate, "Interest rate cannot be null");

        if (loanAmount.signum() <= 0 || annualInterestRate.signum() < 0 || tenureMonths <= 0) {
            throw new IllegalArgumentException("Loan amount, interest rate, and tenure must be positive");
        }

        this.tenureMonths = tenureMonths;
        // Total outstanding balance includes principal + interest
        this.balance = loanAmount.add(calculateInterest());
    }

    @Override
    public BigDecimal calculateInterest() {
        BigDecimal years = BigDecimal.valueOf(tenureMonths)
                .divide(BigDecimal.valueOf(12), 4, RoundingMode.HALF_UP);
        return loanAmount.multiply(annualInterestRate)
                .multiply(years)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public void payLoanInstallment(BigDecimal amount) {
        validatePositiveAmount(amount);
        checkActiveAcc();

        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Payment exceeds remaining loan balance of " + balance);
        }

        balance = balance.subtract(amount);
        recordTransaction(TransactionType.deposit, amount, "Loan EMI / Installment Payment");

        if (balance.compareTo(BigDecimal.ZERO) == 0) {
            this.status = enums.status.closed;
        }
    }

    @Override
    public void withdraw(BigDecimal amount) {
        throw new UnsupportedOperationException("Withdrawals are not permitted on a Loan Account.");
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Loan Account Summary ---");
        System.out.printf("Account Number    : %s%n", accountNo);
        System.out.printf("Borrower Name     : %s%n", customer.getCustomer_name());
        System.out.printf("Principal Loan    : %.2f%n", loanAmount);
        System.out.printf("Interest Rate     : %.2f%%%n", annualInterestRate);
        System.out.printf("Tenure            : %d months%n", tenureMonths);
        System.out.printf("Remaining Balance : %.2f%n", balance);
        System.out.printf("Status            : %s%n", status);
    }
}
