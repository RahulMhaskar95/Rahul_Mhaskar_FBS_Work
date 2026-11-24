
abstract class payment {
   String  paymentid;
   double amount;
   String Payername;
    String status;
    
 public payment(String paymentid , double amount , String Payername )
 {
	 this.paymentid = paymentid;
	 this.amount = amount;
	 this.Payername = Payername;
	 this.status  = "Pending";
 }
   
 public void printsummary()
 {
	 System.out.println("Payment summary");
	 System.out.println("Payment Id :"+ paymentid);
	 System.out.println("Payment Name :"+ Payername);
	 System.out.println("Amount :"+ amount);
	 System.out.println("Status :"+ status);
 }
   
 public  final void  process()
 {
	 System.out.println("Payment Processing");
	 
	 if(validate())
	 {
		 deductAmount();
		 sendNotification();
		 status = " Success";
		 System.out.println("Payment done successfully");
	 } else {
		 status = "Failed";
		 System.out.println("Payment Failed");
	 }
	 
 }
	
 @Override
 public String toString() {
     return "Payment ID: " + paymentid +
            ", Amount: " + amount +
            ", Customer: " + Payername + "status " + status ;
     
 }

 abstract boolean validate();

 abstract void deductAmount();

 abstract void sendNotification();
}


class CardPayment extends payment {
 private String cardNumber;
 private String cvv;

 public CardPayment(String paymentId, double amount, String payerName,
                    String cardNumber, String cvv) {
     super(paymentId, amount, payerName);
     this.cardNumber = cardNumber;
     this.cvv = cvv;
 }

 @Override
 boolean validate() {
     if (cardNumber.length() == 16 &&
         cardNumber.matches("\\d{16}") &&
         cvv.matches("\\d{3}") &&
         amount > 0) {
         System.out.println("Card Validation Successful.");
         return true;
     }
     System.out.println("Card Validation Failed.");
     return false;
 }

 @Override
 void deductAmount() {
     System.out.println("Deducting Rs. " + amount + " from Card.");
 }

 @Override
 void sendNotification() {
     System.out.println("Notification Sent: Card Payment Successful.");
 }
 @Override
 public String toString() {
     return super.toString() +
            ", Card Number: " + cardNumber +
            ", CVV: " + cvv;
 }
}


class UPIPayment extends payment {
 private String upiId;

 public UPIPayment(String paymentId, double amount, String payerName,
                   String upiId) {
     super(paymentId, amount, payerName);
     this.upiId = upiId;
 }

 @Override
 boolean validate() {
     if (upiId.contains("@") && amount >= 1 && amount <= 100000) {
         System.out.println("UPI Validation Successful.");
         return true;
     }
     System.out.println("UPI Validation Failed.");
     return false;
 }

 @Override
 void deductAmount() {
     System.out.println("Deducting Rs. " + amount + " via UPI.");
 }

 @Override
 void sendNotification() {
     System.out.println("Notification Sent: UPI Payment Successful.");
 }
 @Override
 public String toString() {
     return super.toString() +
            ", UPI ID: " + upiId;
 }
}


public class OnlinePaymentSystem {
 public static void main(String[] args) {

     payment p1 = new CardPayment(
             "P101", 5000, "Rahul",
             "1234567812345678", "123");

     payment p2 = new CardPayment(
             "P102", -100, "Amit",
             "12345678", "12");

     payment p3 = new UPIPayment(
             "P103", 2500, "Sneha",
             "sneha@upi");

     payment p4 = new UPIPayment(
             "P104", 150000, "Priya",
             "priyaupi");

     payment[] payments = {p1, p2, p3, p4};
  
      for(payment p : payments)
      {
    	  System.out.println(p);
      }
   
 }

}

