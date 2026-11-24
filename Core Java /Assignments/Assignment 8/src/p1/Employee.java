package p1;
public class Employee 
{
	int id ;
	String name;
	  public double salary;
   public  Employee(){
		System.out.println("In Employee Constructor");
		this.id = 0 ;
		this.name= "Not given";
		this.salary = 10000;
	}
	public  Employee(int id , String name , double salary)
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
	 public double calSal()
	{
		return salary;
	}
	
	public String toString() {
	    return "Employee{id=" + id +
	           ", name='" + name + '\'' +
	           ", salary=" + salary + "}";
	}
	public void display() {
		System.out.println("Id :"+this.id);
		System.out.println("Name :"+this.name);
		System.out.println("Salary :"+this.salary);
	}
}