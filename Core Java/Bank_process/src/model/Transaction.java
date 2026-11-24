package model;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import enums.TransactionType;


public class Transaction {

	protected TransactionType transactiontype;
	protected String transactionid ;
	protected  LocalDate transactionDate;
	protected BigDecimal amount;
	protected String description;
	
	public Transaction()
	{
		this.transactiontype = TransactionType.idle;
		this.transactionid = "TR000";
		this.transactionDate = LocalDate.of(2011,11,11);
		this.amount = BigDecimal.ZERO;
		this.description  = "Default TR";
	}
	
	public Transaction( TransactionType transactiontype , String transactionid , LocalDate transactionDate , BigDecimal amount , String description)
	{
		this.transactiontype =  Objects.requireNonNull(transactiontype, "Transaction type cannot be null");
		this.transactionid = Objects.requireNonNull(transactionid, "Transaction id cannot be null");
		this.transactionDate = Objects.requireNonNull(transactionDate, "Transaction Date cannot be null");
		this.amount =Objects.requireNonNull(amount, "Transaction amount cannot be null");
		this.description = Objects.requireNonNull(description, "Transaction information cannot be null");
	}
	public TransactionType getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(TransactionType transactiontype) {
		this.transactiontype = transactiontype;
	}
	public  LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@Override
	public String toString() {
		return "Transaction [transactiontype=" + transactiontype + ", transactionid=" + transactionid
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + ", description=" + description + "]";
	}
	
	
	
}
