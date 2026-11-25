 class employee 
{
	int emp_id;
	String emp_name;
	double salary ;
	
	
	public employee(int emp_id, String emp_name, double salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.salary = salary;
	
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_salary(String emp_salary) {
		this.emp_name = emp_salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	void display()
	{
		System.out.println("Employee:"+ emp_name);
		System.out.println("Employee ID :"+ emp_id);
		System.out.println("Salary:"+ salary);
		
	}
	
	double calculate_sal()
	{
		return salary;
	}
}
 
 class common_employee extends employee
 {
	 String employee_type;
	 double incentives;

	 public common_employee(int emp_id, String emp_name, double salary , String employee_type , double incentives) {
		super(emp_id, emp_name, salary);
		this.employee_type = employee_type;
		this.incentives = incentives;
	 }

	 public String getEmployee_type() {
		 return employee_type;
	 }

	 public void setEmployee_type(String employee_type) {
		 this.employee_type = employee_type;
	 }
	 
	 public void setincentives(double incentives) {
		 this.incentives = incentives;
	 }
	 public double getincentives() {
		 return incentives;
	 }

	@Override
	double calculate_sal()
	{ 
		return salary + incentives ; 
		
	}
	 
	 @Override
	 void display()
	 {
		 super.display();
		 System.out.println("Employee Type :- " + employee_type);
		 System.out.println("Company Policy : Standard employment policy applies .");
	 }
 }
 
 class permanant_employee extends employee
 {
	 String employee_type;
	 double paybacks;

	 public permanant_employee(int emp_id, String emp_name, double salary , String employee_type , double paybacks) {
		super(emp_id, emp_name, salary);
		this.employee_type = employee_type;
		this.paybacks = paybacks;
	 }

	 public String getEmployee_type() {
		 return employee_type;
	 }

	 public void setEmployee_type(String employee_type) {
		 this.employee_type = employee_type;
	 }
	 
	 public void setincentives(double paybacks) {
		 this.paybacks = paybacks;
	 }
	 public double getincentives() {
		 return paybacks;
	 }

	@Override
	double calculate_sal()
	{ 
		return salary + paybacks ; 
		
	}
	 
	 @Override
	 void display()
	 {
		 super.display();
		 System.out.println("Employee Type :- " + employee_type);
		 System.out.println("Company Policy : Standard employment policy applies .");
	 }
 }
 
 public class emp_salary_process
 {
	 public static void main(String args[])
	 {
		 employee e1 , e2;
		 e1 = new common_employee(101 ,"Rahul ", 50000.00 , "Common" , 5000);
		 e2 = new permanant_employee(102 ,"Amit", 20000.00 , "Permanant" , 10000);
		 e1.display();
		 System.out.println();
		 e2.display();
		 
	 }
 }