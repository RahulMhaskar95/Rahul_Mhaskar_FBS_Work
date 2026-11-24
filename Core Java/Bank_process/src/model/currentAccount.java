package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

import enums.AccountType;
import enums.status;


public class currentAccount extends account {

	protected BigDecimal overdraft_Limit;
	protected BigDecimal interest_rate;
	
	private static final BigDecimal DIVISOR = new BigDecimal("36500");
	
	public currentAccount(AccountType accounttype, BigDecimal balance, status status,
            customer customer, LocalDate localdate,
            BigDecimal overdraftLimit, BigDecimal fee) {
this(generateAccountNo(customer), accounttype, balance, status, customer, localdate, overdraftLimit, fee);
}

	public currentAccount(String accountNo , AccountType accounttype , BigDecimal balance , status status , customer customer , LocalDate localdate , BigDecimal overdraft_Limit , BigDecimal interest_rate )
	{
		super(accountNo , accounttype , balance , status , customer , localdate );
		
		if(accounttype != AccountType.current) {
			throw new IllegalArgumentException("Account type must be current");
		}
		
		this.overdraft_Limit = Objects.requireNonNull(
                overdraft_Limit, "Overdraft limit cannot be null");

        this.interest_rate = Objects.requireNonNull(
                interest_rate, "Interest rate cannot be null");

        if (overdraft_Limit.compareTo(BigDecimal.ZERO) < 0
                || interest_rate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Limit and interest rate cannot be negative");
        }
    }

	public BigDecimal getOverdraft_Limt() {
		return overdraft_Limit;
	}



	public BigDecimal getInterest_rate() {
		return interest_rate;
	}

	@Override
	public void withdraw(BigDecimal amount)
	{
		validatePositiveAmount(amount);
		checkActiveAcc();
		
		BigDecimal availableAmount = balance.add(overdraft_Limit);
		
		if(amount.compareTo(availableAmount) > 0)
		{
			throw new IllegalArgumentException("'withdrawl exceeds available balance and overdrafft limit");
		}
		
		balance  = balance.subtract(amount);
		
		recordTransaction(enums.TransactionType.withdraw, amount , "Current Account withdrawl");
	}
	
	

	@Override
 	public BigDecimal calculateInterest() {
	     if(balance.compareTo(BigDecimal.ZERO) <= 0)
	     {
	    	 return BigDecimal.ZERO;
	     }
	     
	     return balance.multiply(interest_rate).divide(DIVISOR, 8 , RoundingMode.HALF_UP);
	}

	@Override
	public void displayDetails() {
		    System.out.println("Account Number: " + accountNo);
	        System.out.println("Account Type: " + accounttype);
	        System.out.println("Balance: " + balance);
	        System.out.println("Status: " + status);
	        System.out.println("Customer ID: " + customer.getCustomer_id());
	        System.out.println("Opening Date: " + localdate);
	        System.out.println("Overdraft Limit: " + overdraft_Limit);
	        System.out.println("Interest Rate: " + interest_rate);
	}
}
