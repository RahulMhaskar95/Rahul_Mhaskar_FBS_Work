package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public  abstract class customer {
   
	
	 protected String customer_id;
	 protected String customer_name;
	 protected String customer_phone;
	 protected String customer_email;
	 protected String customer_address;
	 protected final List<account> ownedAccounts = new ArrayList<>();
	 
	 
	 public customer(String customer_id , String customer_name , String customer_phone , String customer_email, String customer_address)
	 {
		setCustomer_id(customer_id);
		setCustomer_name(customer_name);
		setCustomer_phone(customer_phone);
	    setCustomer_email(customer_email);
	    setCustomer_address(customer_address);
	}
	 public void linkAccount(account acc) {
	        if (acc != null && !ownedAccounts.contains(acc)) {
	            ownedAccounts.add(acc);
	        }
	    }

	    public List<account> getOwnedAccounts() {
	        return Collections.unmodifiableList(ownedAccounts);
	    }
	    
	 public String getCustomer_id() {
		 return customer_id = requireText(customer_id,"Customer ID cannot be empty");
	 }
	 public void setCustomer_id(String customer_id) {
		 this.customer_id = customer_id;
	 }
	 public String getCustomer_name() {
		 return customer_name = requireText(customer_name,"Customer Name cannot be empty");
	 }
	 public void setCustomer_name(String customer_name) {
		 this.customer_name = customer_name;
	 }
	 public String getCustomer_phone() {
		 return customer_phone = requireText(customer_phone,"Customer Phone no. cannot be empty");
	 }
	 public void setCustomer_phone(String customer_phone) {
		 this.customer_phone = customer_phone;
	 }
	 public String getCustomer_email() {
		 return customer_email = requireText(customer_email,"Customer Gmail ID cannot be empty");
	 }
	 public void setCustomer_email(String custome_email) {
		 this.customer_email = custome_email;
	 }
	 public String getCustomer_address() {
		 return customer_address = requireText(customer_address,"Customer Address cannot be empty");
	 }
	 public void setCustomer_address(String customer_address) {
		 this.customer_address = customer_address;
	 }
	 
	 public String requireText(String value  , String  message)
	 {
		 Objects.requireNonNull(value, message);
		 
		 if(value.trim().isEmpty())
		 {
			 throw new IllegalArgumentException(message);
		 }
		 
		 return value.trim();
		 
	 }
	 
	 @Override
	    public String toString() {
	        return "customer [customer_id=" + customer_id
	                + ", customer_name=" + customer_name
	                + ", customer_phone=" + customer_phone
	                + ", customer_email=" + customer_email
	                + ", customer_address=" + customer_address + "]";
	    }
	
	
}
