class Employee
{
	int id ;
	String name;
	double salary;
	Employee(){
		System.out.println("In Employee Constructor");
		this.id = 0 ;
		this.name= "Not given";
		this.salary = 10000;
	}
	Employee(int id , String name , double salary)
	{
		this.id = id;
		this.name = name ;
		this.salary= salary;
	}
	int getId()
	{
		return this.id;
	}
	void setId(int id){
		this.id = id;
	}
	String getName()
	{
		return this.name;
	}
	void setName(String name )
	{
		this.name = name;
	}
	double getSalary()
	{
		return this.salary;
	}
	void setSalary(double salary)
	{
		this.salary = salary;
	}
	double calSal()
	{
		return salary;
	}
	void display()
	{
		System.out.println("Id : "+this.id);
		System.out.println("name :"+this.name);
		System.out.println("Slary : "+this.salary);
	}
}
class HR extends Employee
{
	double commission;
	
	HR()
	{
		super();
		this.commission = 5000;
	}
	
	HR(int id , String name , double salary , double commission){
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
	double calSal()
	{
		return this.salary+this.commission;
	}
	void display()
	{
		super.display();
		System.out.println("Commission :"+this.commission);
	}
}
class Admin extends Employee
{
	double allowance;
	Admin(){
		super();
		this.allowance = 3000;
	}
	Admin(int id , String name,double salary,double allowance)
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
	double calSal() {
		return this.salary+this.allowance;
	}
	void display()
	{
		super.display();
		System.out.println("Allowance :"+this.allowance);
	}
}
class SalesManager extends Employee {
	double incentive;
	int target;

	SalesManager() {
		
		System.out.println("In SM Constructor");
		this.incentive = 7000;
		this.target = 50000;
	}

	SalesManager(int id, String name, double salary, double incentive, int target) {
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
	double calSal() {
		return this.salary+this.incentive;
	}
	void display() {
		super.display();
		System.out.println("Target: "+this.target);
		System.out.println("Incentive: "+this.incentive);
	}
}
class emp_hierachy {
	public static void main(String[] args) 
	{
		Employee e1;//employee reference
		e1=new Employee(101,"Karan",25000);
	
		System.out.println(e1.calSal());
		
		e1=new SalesManager(102,"Harsha",28000,1500,5);
	
		System.out.println(e1.calSal());
		
		e1=new HR(103, "Rahul", 35000, 2000);

		System.out.println(e1.calSal());
		
		e1=new Admin(104,"Vyankatesh",35000,4000);
			
		System.out.println(e1.calSal());
		
	}
}
