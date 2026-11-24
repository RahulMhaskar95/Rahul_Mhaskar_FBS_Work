import java.util.Scanner;
abstract class InsurancePolicy
{
	String policy_Holder_name;
	double base_premium;
	double final_premium ;
	
	public InsurancePolicy(String policy_Holder_name, double base_premium) {
		this.policy_Holder_name = policy_Holder_name;
		this.base_premium = base_premium;
	}
	abstract double calculate_premium();
	
	void print_Policy_details()
	{
		double final_premium = calculate_premium();

		System.out.println("Policy Details :");
		System.out.println("Policy Holder Name :"+policy_Holder_name);
		System.out.println("Final PRemium :"+final_premium);
	}

}

class carInsurance extends InsurancePolicy
{
  double car_age_years;
  boolean last_accident;
  double car_value;
  
  public carInsurance(String policy_Holder_name, double car_age_years, boolean last_accident,
		double car_value) {
	super(policy_Holder_name, 10000);
	this.car_age_years = car_age_years;
	this.last_accident = last_accident;
	this.car_value = car_value;
}

  @Override
  double calculate_premium()
  {
	  final_premium = base_premium;
	  
	 if(car_age_years <= 3)
	 {
		  final_premium += base_premium * 0.10 ;
	 }
	 else if(car_age_years <= 7)
	 {
		 final_premium += base_premium * 0.20;
	 }
	 else if(car_age_years > 7)
	 {
		 final_premium += base_premium * 0.30;
	 }
	 
	 
	 
	  if(last_accident == true )
	 {
		 final_premium += base_premium  * 0.25;
	 }
	 else 
	 {
		 final_premium -= base_premium * 0.10;
	 }
	 
	  
	  if( car_value > 100000) 
	 { 
		 final_premium += 2000;
	 }
	 return final_premium ;
  }
	
}
class healthInsurance extends InsurancePolicy 
{
	 int age ;
	 boolean is_smoker ;
	 boolean  has_prexisting_disease ;
	 
	 public int getAge() {
		return age;
	}

	 public void setAge(int age) {
		 this.age = age;
	 }

	 public boolean isIs_smoker() {
		 return is_smoker;
	 }
	 
	 public void setIs_smoker(boolean is_smoker) {
		 this.is_smoker = is_smoker;
	 }
	 
	 public boolean isHas_prexisting_disease() {
		 return has_prexisting_disease;
	 }
	 
	 public void setHas_prexisting_disease(boolean has_prexisting_disease) {
		 this.has_prexisting_disease = has_prexisting_disease;
	 }

	 public healthInsurance(String policy_Holder_name, int age, boolean is_smoker,
			boolean has_prexisting_disease) {
		super(policy_Holder_name, 15000);
		this.age = age;
		this.is_smoker = is_smoker;
		this.has_prexisting_disease = has_prexisting_disease;
	}

	 @Override
	 double calculate_premium() {
		 final_premium = base_premium;
		 if(age < 30)
		 {
			 final_premium += base_premium * 0.10;
		 }
		 else if( age <= 45)
		 {
			 final_premium += base_premium * 0.25;
		 }
		 else if( age > 45)
		 {
			 final_premium +=  base_premium * 0.40;
		 }
		 	 
		 if(is_smoker == true )
		 {
			 final_premium += base_premium * 0.30;
		 }
		 else 
		 {
			 final_premium -= base_premium * 0.05 ;
		 }
		 
		 if( has_prexisting_disease == true)
		 {
			 final_premium += base_premium * 0.20;
		 }
	return final_premium ;
	 }
	 
	
}
public class InsurancePremiumCalculator {
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
             int choice = 0 ;
             while (choice != 3)
             {
	        System.out.println("Insurance Premium Calculator ");
	        System.out.println("1. Car Insurance");
	        System.out.println("2. Health Insurance");
	        System.out.println("3. Exit");
	        System.out.print("Enter your choice : ");
	        choice = sc.nextInt();
	        sc.nextLine();
             

	        switch (choice) {

	        case 1:

	            System.out.print("Enter Policy Holder Name : ");
	            String cname = sc.nextLine();

	            System.out.print("Enter Car Age (years) : ");
	            double age = sc.nextDouble();

	            System.out.print("Any accident in last year? (true/false) : ");
	            boolean accident = sc.nextBoolean();

	            System.out.print("Enter Car Value : ");
	            double value = sc.nextDouble();

	            carInsurance car = new carInsurance(cname, age, accident, value);

	            car.print_Policy_details();

	            break;

	        case 2:

	            System.out.print("Enter Policy Holder Name : ");
	            String hname = sc.nextLine();

	            System.out.print("Enter Age : ");
	            int hage = sc.nextInt();

	            System.out.print("Is Smoker? (true/false) : ");
	            boolean smoker = sc.nextBoolean();

	            System.out.print("Has Pre-existing Disease? (true/false) : ");
	            boolean disease = sc.nextBoolean();

	            healthInsurance health = new healthInsurance(hname, hage, smoker, disease);

	            health.print_Policy_details();

	            break;

	        default:
	            System.out.println("Invalid Choice.");
	        }
             }

	        sc.close();
	    }
	
}
