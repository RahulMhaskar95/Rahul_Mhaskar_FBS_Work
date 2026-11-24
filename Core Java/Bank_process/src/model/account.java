
package model;


import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


import enums.AccountType;
import enums.TransactionType;
import enums.status;

public abstract class account {

protected final List<Transaction>transactions = new ArrayList<>();
    
protected Map<String , String > account_map = new HashMap<>();

    protected final String accountNo;
    protected final AccountType accounttype;
    protected BigDecimal balance;
    protected status status;
    protected final customer customer;
    protected LocalDate localdate;

    
     protected account() {
    	
		this.accountNo = "000000000000";
		this.accounttype = AccountType.savings;
		this.balance = BigDecimal.ZERO;
		this.status = enums.status.closed;
		this.localdate = LocalDate.of(2011, 11, 11) ;
		this.customer = null;
	}

	public account(String accountNo, AccountType accounttype,
                   BigDecimal balance, status status,
                   customer customer, LocalDate localdate) {

        this.accountNo = Objects.requireNonNull(accountNo, "Account number cannot be null");
        this.accounttype = Objects.requireNonNull(accounttype, "Account type cannot be null");
        this.balance = Objects.requireNonNull(balance, "Balance cannot be null");
        this.status = Objects.requireNonNull(status, "Status cannot be null");
        this.customer = Objects.requireNonNull(customer, "Customer cannot be null");
        this.localdate = Objects.requireNonNull(localdate, "Date cannot be null");

        if (accountNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
    }
    
    private static final SecureRandom ACCOUNT_RANDOM = new SecureRandom();


    protected static String generateAccountNo(customer cust) {
        Objects.requireNonNull(cust, "Customer cannot be null");
        StringBuilder number = new StringBuilder(12);
        number.append(ACCOUNT_RANDOM.nextInt(9) + 1); 
        for (int i = 1; i < 12; i++) {
            number.append(ACCOUNT_RANDOM.nextInt(10));
        }
        return number.toString();
    }

    public String getAccountNo() {
        return accountNo;
    }

   
    public AccountType getAccounttype() {
        return accounttype;
    }

    

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        Objects.requireNonNull(balance, "Balance cannot be null");

        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.balance = balance;
    }

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
        this.status = Objects.requireNonNull(status);
    }

    public customer getCustomer() {
        return customer;
    }

  
    public LocalDate getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDate localdate) {
        this.localdate = localdate;
    }

    public boolean isAccountType(String input) {
        return input != null
                && accounttype.name().equalsIgnoreCase(input.trim());
    }
    
    protected void validatePositiveAmount(BigDecimal amount)
    {
    	if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) 
    	{
    		throw new IllegalArgumentException("Amount must be greater than zero ");
    	}
    }
         
     public void checkActiveAcc()
     {
    	 if(status != enums.status.active)
    	 {
    		 throw new IllegalStateException("Account is not active ");
    	 }
     }
     
    public void deposit(BigDecimal amount) {

        validatePositiveAmount(amount);
        checkActiveAcc();
        
        balance = balance.add(amount);
        
         recordTransaction(TransactionType.deposit , amount , "Deposit to Account");
    }

    public void withdraw(BigDecimal amount) {
    
    	   validatePositiveAmount(amount);
           checkActiveAcc();
        
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException(
                    "Insufficient balance");
        }
        
        balance = balance.subtract(amount);
        
        recordTransaction(TransactionType.withdraw , amount , "Withdrawal from Account");
        
    }
   
    
    protected final void recordTransaction(TransactionType transactiontype , BigDecimal amount , String description )
    {
    	Objects.requireNonNull(transactiontype, " Transactio Type cannote be null ");
    	Objects.requireNonNull(amount , "Amount cannot be null ");
    	
    	if(amount.compareTo(BigDecimal.ZERO) <= 0)
    	{
    		throw new IllegalArgumentException("Transaction amount must be positive");
    	}
    	String prefix ;
    	
    	switch(transactiontype)
    	{
    	case deposit:
    		prefix = "DEP";
    		break ;
    		
    	case withdraw:
    	     prefix = "WTH";
    	     break;
    	
    	case salary_deposit:
   	     prefix = "SAL_DEP";
   	     break;
   	  
    	case transfer:
   	     prefix = "TRF";
   	     break;
   	
    	case interest:
   	     prefix = "INT";
   	     break;
   	
    	case fee:
   	     prefix = "FEE";
   	     break;
   	
     default:
   	     prefix = "TRX";
   	     
    	}
    	
    	String transactionid = prefix + String.format("%04d", transactions.size() + 1);
    	
       Transaction transaction = new Transaction ( transactiontype , transactionid , LocalDate.now(),amount , description);
       transactions.add(transaction);
    	
    }
    public List<Transaction> getTransactions()
    {
    	return Collections.unmodifiableList(transactions);
    }
    
    public void displayTransactionHistory()
    {
    	if(transactions.isEmpty())
    	{
    		System.out.print("No Transaction History available .");
    		return;
    	}
    	
    	for(Transaction transaction : transactions)
    	{
    		System.out.println(transaction);
    	}
    }
    abstract public BigDecimal calculateInterest();
    
    abstract public void displayDetails();
   
    
     
}
