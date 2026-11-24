package model;

public  class CorporateCustomer extends customer {

    private String registrationNumber;
    private String gstNumber;

    public CorporateCustomer(String customer_id, String customer_name, String customer_phone,String customer_email, String customer_address,
                             String registrationNumber, String gstNumber)
    {
        super(customer_id, customer_name, customer_phone, customer_email, customer_address);
        this.registrationNumber = requireText(registrationNumber, "Company Registration No cannot be empty");
        this.gstNumber = requireText(gstNumber, "GST Number cannot be empty");
    }

    public String getRegistrationNumber() 
    {
    	return registrationNumber; 
    	}
    public String getGstNumber() 
    {
    	return gstNumber; 
    	}
}
