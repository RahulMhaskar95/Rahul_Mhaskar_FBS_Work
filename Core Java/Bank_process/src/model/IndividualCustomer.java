package model;

import java.time.LocalDate;

public  class IndividualCustomer extends customer {

    private LocalDate dateOfBirth;
    private String panNumber;

    public IndividualCustomer(String customer_id, String customer_name, String customer_phone, String customer_email, String customer_address,
                              LocalDate dateOfBirth, String panNumber) 
    {
        super(customer_id, customer_name, customer_phone, customer_email, customer_address);
        this.dateOfBirth = dateOfBirth;
        this.panNumber = requireText(panNumber, "PAN Number cannot be empty");
    }

    public LocalDate getDateOfBirth() 
    {
    	return dateOfBirth; 
    	}
    public String getPanNumber() 
    { 
    	return panNumber; 
    	}
}
