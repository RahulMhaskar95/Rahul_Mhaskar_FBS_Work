
 class Electricity_bill {
	  static double ratePerUnit;
      
	  String customerName;
	  int unitsConsumed;
	  
	  public Electricity_bill(String customerName , int unitsConsumed)
	  {
		  this.customerName = customerName;
		  this.unitsConsumed = unitsConsumed;
	  }
	  
	  public static void updateRate(double newRate)
	  {
		  ratePerUnit = newRate;
	  }
	  
	  public double calculateBill()
	  {
		  return unitsConsumed * ratePerUnit;
	  }
	  public void displayBill() {
	        System.out.println("Customer Name: " + customerName);
	        System.out.println("Units Consumed: " + unitsConsumed);
	        System.out.println("Rate Per Unit: " + ratePerUnit);
	        System.out.println("Bill Amount: " + calculateBill());
	    }

	  
	    public static void main(String[] args) {
	       
	        Electricity_bill.updateRate(8.5);

	   
	        Electricity_bill customer1 = new Electricity_bill("Rahul", 250);
	        Electricity_bill customer2 = new Electricity_bill("Priya", 180);
  
	        customer1.displayBill();
	        System.out.println();
	        customer2.displayBill();
	    }
	}
