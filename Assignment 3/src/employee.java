
public class employee {
	String emp_name;
	double basic_salary;
 double bonus_rate ;
 static double n_bonus_rate;
   
 public employee(String emp_name ,double basic_salary,double bonus_rate)
 {
   this.emp_name = emp_name;
   this.basic_salary = basic_salary;
   this.bonus_rate = n_bonus_rate;
}
 public static void updateBonus_rate(double bonus_rate)
{
	 n_bonus_rate = bonus_rate;
}
 public  double calculateSalary()
 {
	 return basic_salary + (basic_salary * bonus_rate / 100);
 }
  
 public void displayemp()
 {
	 System.out.println("Employee name: "+ emp_name);
	 System.out.println("Basic Salary : "+ basic_salary);
	 System.out.println("Bonus Percenage: "+ bonus_rate);
	 System.out.println("Total Salary :"+ calculateSalary());
 }
 public static void main(String args[])
 {
	 employee.updateBonus_rate(3.5);
	 
	 employee emp1 = new employee("Rahul",25000,n_bonus_rate);
	 employee.updateBonus_rate(1.5);
	 employee emp2 = new employee("Rohit",55000,n_bonus_rate);
	 emp1.displayemp();
	 System.out.println();
	 emp2.displayemp();
 }
}