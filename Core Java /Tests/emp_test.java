abstract class Employee
{
	int emp_id;
	String emp_name ;
	double salary;
	static double final_salary;
	

	Employee() {
		emp_id = 000;
		emp_name = "Unknown";
		salary = 000.00;
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

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int emp_id, String emp_name, double salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.salary = salary;
	}
	
	public abstract double calculate_salary();

	 void display() {
	        System.out.println("Id : " + emp_id);
	        System.out.println("Name : " + emp_name);
	        System.out.println("Basic Salary : " + salary);
	    }
	
}

class developer extends Employee
{
	double project_bonus;

	public developer() {
		super();
		 project_bonus = 0000.00;
	}

	public developer(int emp_id, String emp_name, double salary , double project_bonus) {
		super(emp_id, emp_name, salary);
      this.project_bonus = project_bonus;
	}

	public double getProject_bonus() {
		return project_bonus;
	}

	public void setProject_bonus(double project_bonus) {
		this.project_bonus = project_bonus;
	}
	
	@Override
	public double calculate_salary()
	{
		return salary + project_bonus; 
	}


    @Override
    void display() {
        super.display();
        System.out.println("Commission : " + project_bonus);
    }
	
}


class manager extends Employee
{
	int allowance ;

	public manager() {
		super();
		allowance = 0000;
	}

	public manager(int emp_id, String emp_name, double salary, int allowance ) {
		super(emp_id, emp_name, salary);
		this.allowance = allowance;	
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	
	
	public double calculate_salary()
	{
		return salary + allowance; 
	}
	 @Override
	    void display() {
	        super.display();
	        System.out.println("Commission : " + allowance);
	    }
		
	
}

 public class emp_test
{
	public static void main(String args[])
{
	Employee e1 , e2;
	e1 = new developer(101, "Rahul ", 65000.00 ,5000.00);
	e1.display();
	e2=new manager (102 , "Amit ", 80000.00 , 10000);
	e2.display();
	
	
	
}
}
	
