
package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.TransactionType;
import enums.AccountType;

public class salaryAccount extends savingAccount {
 
	protected List<Transaction>salary_transactions = new ArrayList<>();
	
  public void salary_transaction_lookup(Transaction t)
  {
	  transactions.add(t);
  }
     
    private LocalDate salaryDate;
    private BigDecimal interestRate = new BigDecimal("3.50");
    private BigDecimal divisor = new BigDecimal("36500");

    salaryAccount() {
        super();
    }
    
    public salaryAccount(AccountType accounttype, BigDecimal balance, enums.status status,
            customer customer, LocalDate localdate,
            BigDecimal minimumBalance, LocalDate lastSalaryDate) {
this(generateAccountNo(customer), accounttype, balance, status, customer, localdate, minimumBalance, lastSalaryDate);
}


    public salaryAccount(
            String accountNo,
            AccountType accounttype,
            BigDecimal balance,
            enums.status status,
            model.customer customer,
            LocalDate localdate,
            BigDecimal minimumBalance,
            LocalDate salaryDate) {

        super(accountNo, accounttype, balance, status, customer,
                localdate, minimumBalance);

        if(accounttype != AccountType.salary)
        {
        	throw new IllegalArgumentException ( "Account type must be salary");
        }
        this.salaryDate = salaryDate;
    }

    public LocalDate getsalaryDate()
    {
    	return salaryDate;
    }
    
    public void depositSalary(BigDecimal amount)
    {
    	validatePositiveAmount(amount);
    	checkActiveAcc();
    	
    	balance = balance.add(amount);
    	salaryDate = LocalDate.now();
    	
    	recordTransaction(TransactionType.salary_deposit,amount, "salary Deposited");
    	
    }
    public boolean salary_Eligible_period() {

        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusMonths(3);

        for (Transaction transaction : transactions) 
        {

            if (transaction.getTransactiontype()  == TransactionType.salary_deposit) {

                LocalDate transactionDate =
                        transaction.getTransactionDate();

                if (transactionDate != null && !transactionDate.isBefore(startDate) && !transactionDate.isAfter(today)) {

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public BigDecimal calculateInterest() {

        if (!salary_Eligible_period()) {
            
            return BigDecimal.ZERO;
        }

        if (balance.compareTo(minimumBalance) < 0) 
        {
            return BigDecimal.ZERO;
        }

        return balance.multiply(interestRate)
                .divide(divisor, 8, RoundingMode.HALF_UP);
    }

    @Override
    public void displayDetails() {

        System.out.println("Account Number: " + accountNo);
        System.out.println("Account Type: " + accounttype);
        System.out.println("Account Balance: " + balance);
        System.out.println("Account Status: " + status);
        System.out.println("Account Holder: " + customer);
        System.out.println("Account Opening Date: " + localdate);
        System.out.println("Salary Date: " + salaryDate);
        System.out.println("Salary Eligible: " + salary_Eligible_period());
    }
}
