package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

import enums.AccountType;
import enums.TransactionType;

public class savingAccount extends account{

	BigDecimal minimumBalance ;
	
	
	BigDecimal interestRate = new BigDecimal("2.50");
	BigDecimal divisor = new BigDecimal("36500");
	
	 savingAccount() {
		super();
		this.minimumBalance = new BigDecimal("10000.00");
	}

    public savingAccount(AccountType accounttype, BigDecimal balance, enums.status status,
            model.customer customer, LocalDate localdate, BigDecimal minimumBalance) {
        this(generateAccountNo(customer), accounttype, balance, status, customer, localdate, minimumBalance);
    }

	public savingAccount(String accountNo, AccountType accounttype, BigDecimal balance, enums.status status,
			model.customer customer, LocalDate localdate , BigDecimal minimumBalance) {
		super(accountNo, accounttype, balance, status, customer, localdate);
		
		if(accounttype != AccountType.savings  && accounttype != AccountType.salary )
		{
			throw new IllegalArgumentException("Invalid acount type for a saving Account");
		}
		
		this.minimumBalance = Objects.requireNonNull(minimumBalance , " Minimum balance cannot be null ");
		
		if(minimumBalance.compareTo(BigDecimal.ZERO) < 0)
		{
			throw new IllegalArgumentException("Minimum balance cannot be negative");
		}
		if(balance.compareTo(minimumBalance) < 0)
		{
			throw new IllegalArgumentException("Initial balance cannonr be less than minimum balance of " + minimumBalance);
		}
	}

	
	public BigDecimal getMinimumBalance()
	{
		return minimumBalance;
	}
	
	@Override
	public void withdraw(BigDecimal amount)
	{
		validatePositiveAmount(amount);
		checkActiveAcc();
		

        BigDecimal balanceAfterWithdrawal = balance.subtract(amount);
        if (balanceAfterWithdrawal.compareTo(minimumBalance) < 0) 
        {
            throw new IllegalArgumentException(
                    "Withdrawal denied: Minimum balance of " + minimumBalance + " must be maintained.");
        }

        balance = balanceAfterWithdrawal;
        recordTransaction(TransactionType.withdraw, amount, "Savings Account Withdrawal");
   
		
	}
	
	public BigDecimal closeAccount()
	{
		checkActiveAcc();
		BigDecimal payout = balance;

		if (payout.compareTo(BigDecimal.ZERO) > 0) {
		    recordTransaction(
		        TransactionType.withdraw,
		        payout,
		        "Account closure payout"
		    );
		}

		balance = BigDecimal.ZERO;
		status = enums.status.closed;

		return payout;
	}
	
    @Override
	public BigDecimal calculateInterest() {
	 if ( balance.compareTo(BigDecimal.ZERO) <= 0 || balance.compareTo(new BigDecimal("10000")) < 0)
	 {
		 System.out.println("Account does not meet the eligibility conditions for interest.");
	    return BigDecimal.ZERO;
	 }
	 BigDecimal saving_acc_interest =  balance .multiply(interestRate).divide(divisor,8,RoundingMode.HALF_UP); 
	return saving_acc_interest;
		
	}
    
     
	public void displayDetails() {
		System.out.println("Account Number :-" + accountNo);
		System.out.println("Account Type :-" + accounttype);
		System.out.println("Account Balance :-" + balance);
		System.out.println("Account Status :-" + status);
		System.out.println("Account Holder  :-" + customer);
		System.out.println("Account Openinig Date :-" + localdate);
	}

}
