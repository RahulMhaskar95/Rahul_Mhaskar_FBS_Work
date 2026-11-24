package p2;
import p1.Employee;


public class subclasses {
 public static  class HR extends Employee
	{
		double commission;
		
		HR()
		{
			super();
			this.commission = 5000;
		}
		
	public	HR(int id , String name , double salary , double commission){
			super(id , name , salary);
			this.commission = commission;
		}
		double getccommission()
		{
			return this.commission;
		}
		void setcommission(double commission)
		{
			this.commission = commission;
		}
		@Override
		public  double calSal()
		{
			return salary+commission;
		}
		
		@Override
		public String toString() 
		{
			
			return super.toString()+"HR [commission=" + commission + "]";
		}

		public void display()
		{
			super.display();
			System.out.println("Commission :"+this.commission);
		}
	}
public static 	 class Admin extends Employee
	{
		double allowance;
		Admin(){
			super();
			this.allowance = 3000;
		}
	public 	Admin(int id , String name,double salary,double allowance)
		{
			super(id,name , salary);
			this.allowance = allowance;
		}
		double getAllowance()
		{  
			return this.allowance; 
		}
		void setAllowance(double allowance)
		{
			this.allowance = allowance;
		}
		@Override
	public 	double calSal() {
			return salary+allowance;
		}
	
		@Override
	public String toString() {
			
		return super.toString() +"Admin [allowance=" + allowance + "]";
	}
		public void display()
		{
			super.display();
			System.out.println("Allowance :"+this.allowance);
		}
	}
  public static 	class SalesManager extends Employee {
		double incentive;
		int target;

		SalesManager() {
			
			System.out.println("In SM Constructor");
			this.incentive = 7000;
			this.target = 50000;
		}

		public SalesManager(int id, String name, double salary, double incentive, int target) {
			super(id, name, salary);
			this.incentive = incentive;
			this.target = target;
		}

		double getIncentive() {
			return this.incentive;
		}

		void setIncentive(double incentive) {
			this.incentive = incentive;
		}

		int getTarget() {
			return this.target;
		}

		void setTarget(int target) {
			this.target = target;
		}
		@Override
		public double calSal() {
			return salary+incentive;
		}
		
	@Override
		public String toString() {
			return super.toString()+"SalesManager [incentive=" + incentive + ", target=" + target + "]";
		}

	public 	void display() {
			super.display();
			System.out.println("Target: "+this.target);
			System.out.println("Incentive: "+this.incentive);
		}
	}
	
}
