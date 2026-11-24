import java.util.Scanner;

abstract class electricitybill{
	String customer_Name;
	double units_consumed;
	
	void show_usage()
	{
		System.out.println("Electricity Bill :");
		System.out.println("Customer Name :"+customer_Name);
		System.out.println("Units Are consumed :"+units_consumed);
	}
	
	abstract double calcu_bill();
	
	public final void generate_bill()
	{
		double bill = calcu_bill();
		double final_bill = bill + 50 + (bill * 0.05);
		System.out.println("Final Bill Amount is :"+final_bill);
	}
}
class   residential_bill extends electricitybill
{

	@Override
	double  calcu_bill() {
		double cal_bill ;
		if( units_consumed <= 100 )
		{
			cal_bill  = units_consumed * 2.5 ;
		}else if ( units_consumed <= 300)
		{
			cal_bill  = units_consumed * 3.5 ;
		} else if(units_consumed <= 500)
		{
			cal_bill = units_consumed * 5 ;
		}
		else 
		{
			cal_bill = (units_consumed * 5) + 150 ;
		
		}
		return cal_bill;
	}
	
}
class commercial_bill extends electricitybill
{

	@Override
	double calcu_bill() {
		double bill = units_consumed * 6.5;

        
        if (units_consumed < 200) {
            bill = 1500;
        }

       
        if (units_consumed > 1000) {
            bill = bill + (bill * 0.08);
        }

        return bill;
	}
	
}
public class ElectricityBillCalculator {
public static void main(String arges[])
{
	 Scanner sc = new Scanner(System.in);
     int choice;

     while (true) {

         System.out.println("\n ELECTRICITY BILL SYSTEM ");
         System.out.println("1. Residential");
         System.out.println("2. Commercial");
         System.out.println("3. Exit");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();
         sc.nextLine();

         if (choice == 3) {
             System.out.println("Exited ");
             break;
         }

         electricitybill bill;

         if (choice == 1) {
             bill = new residential_bill();
         } else if (choice == 2) {
             bill = new commercial_bill();
         } else {
             System.out.println("Invalid choice. Try again.");
             continue;
         }

         System.out.print("Enter Customer Name: ");
         bill.customer_Name = sc.nextLine();

         System.out.print("Enter Units Consumed: ");
         bill.units_consumed = sc.nextDouble();

         System.out.println();

         bill.show_usage();
         bill.generate_bill();
     }

     sc.close();
 }

}
