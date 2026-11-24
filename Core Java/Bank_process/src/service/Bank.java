package service;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import enums.status;
import model.CorporateCustomer;
import model.IndividualCustomer;
import model.account;
import model.currentAccount;
import model.customer;
import model.loanAccount;
import model.salaryAccount;
import model.savingAccount;
public class Bank   {

	private final Map<String,account> accounts = new HashMap<>();
	
	private final Map<String , customer> customers = new HashMap<>();
	private static final SecureRandom ACCOUNT_RANDOM = new SecureRandom();

   
    public String generateUniqueAccountNo() {
    	SecureRandom random = new SecureRandom();

        String accountNo;

        do {
            accountNo = String.valueOf(
                100000000000L + random.nextLong(900000000000L)
            );
        } while (accounts.containsKey(accountNo));

        return accountNo;
    }
	
	public void addCustomer(customer customer)
	{
		Objects.requireNonNull(customer,"Customer cannot be null");
		
		String customerId = customer.getCustomer_id();
		
		if(customers.containsKey(customerId))
		{ 
			throw new IllegalArgumentException("Customer Id already exists" + customerId);
		}
		customers.put(customerId,customer);
	}
	
	public void addAccount(account account) {

        Objects.requireNonNull(account, "Account cannot be null");

        String accountNo = account.getAccountNo();
        if (accountNo == null || accountNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number must not be empty");
        }

        if (accounts.containsKey(accountNo)) {
            throw new IllegalArgumentException(
                    "Account number already exists: " + accountNo);
        }
       
        customer owner = account.getCustomer();
        if (owner == null || !customers.containsKey(owner.getCustomer_id())) {
            throw new IllegalArgumentException("Customer must be registered before opening an account.");
        }

        // Real-life Banking Eligibility Rules
        if (account instanceof salaryAccount && !(owner instanceof IndividualCustomer)) {
            throw new IllegalArgumentException("Only Individual Customers can open a Salary Account.");
        }
        if (account instanceof currentAccount && !(owner instanceof CorporateCustomer)) {
            throw new IllegalArgumentException("Only Corporate Customers can open a Current Account.");
        }
        accounts.put(accountNo, account);
        owner.linkAccount(account);
    }
	
	public account findAccount(String accountNo) {

        if (accountNo == null) {
            return null;
        }

        return accounts.get(accountNo);
    }
	
    public void transferFunds(String fromAccNo, String toAccNo, BigDecimal amount) {
        if (fromAccNo == null || toAccNo == null || fromAccNo.equals(toAccNo)) {
            throw new IllegalArgumentException("Source and destination must be different valid accounts.");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero.");
        }
        account source = findAccount(fromAccNo);
        account destination = findAccount(toAccNo);
        if (source == null || destination == null) {
            throw new IllegalArgumentException("One or both account numbers do not exist.");
        }
        source.checkActiveAcc();
        destination.checkActiveAcc();
        if (destination instanceof loanAccount) {
            throw new IllegalArgumentException("Use the loan EMI/payment operation for loan accounts.");
        }
        // Validate source withdrawal rules before mutating either account.
        source.withdraw(amount);
        try {
            destination.deposit(amount);
        } catch (RuntimeException failure) {
            // Compensating transaction: restore source balance and retain audit history.
            source.deposit(amount);
            throw new IllegalStateException("Transfer failed; source funds were restored. " + failure.getMessage(), failure);
        }
    }

	 public customer findCustomer(String customerId) {

	        if (customerId == null) {
	            return null;
	        }

	        return customers.get(customerId);
	    }

	    public Map<String, account> getAccounts() {
	        return Collections.unmodifiableMap(accounts);
	    }

	    public Map<String, customer> getCustomers() {
	        return Collections.unmodifiableMap(customers);
	    }


	   
    public BigDecimal closeAccount(String accountNo) {
        account acc = findAccount(accountNo);
        if (acc == null) throw new IllegalArgumentException("Account not found: " + accountNo);
        acc.checkActiveAcc();

        if (acc instanceof savingAccount) {
            
            return ((savingAccount) acc).closeAccount();
        }
        if (acc instanceof currentAccount) {
            if (acc.getBalance().compareTo(BigDecimal.ZERO) != 0) {
                throw new IllegalStateException("Current account must be settled to zero before closure. Current balance: " + acc.getBalance());
            }
            acc.setStatus(status.closed);
            return BigDecimal.ZERO;
        }
        if (acc instanceof loanAccount) {
            if (acc.getBalance().compareTo(BigDecimal.ZERO) != 0) {
                throw new IllegalStateException("Loan must be fully repaid before closure. Remaining balance: " + acc.getBalance());
            }
            acc.setStatus(status.closed);
            return BigDecimal.ZERO;
        }
        if (acc.getBalance().compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalStateException("Account balance must be zero before closing. Current balance: " + acc.getBalance());
        }
        acc.setStatus(status.closed);
        return BigDecimal.ZERO;
    }

		public static SecureRandom getAccountRandom() {
			return ACCOUNT_RANDOM;
		}
}
