class Employee{
    int emp_id;
    String emp_name ;
    int salary;

Employee()
{
    System.out.println("In default constuctor");
    this.emp_id = 026;
    this.emp_name = "rahul";
    this.salary = 12000;
}
Employee(int i, String s, int sl)
{
    System.out.println("this is parameterized constuctor");
    this.emp_id = i;
    this.emp_name = s;
    this.salary = sl;
}

void setemp_id(int i)
{
    System.out.println("In setemp_id");
    this.emp_id = i;
}
void setemp_name(String s )
{
     System.out.println("In setemp_name");
    this.emp_name = s;
}
void setsalary(int sl)
{
    System.out.println("In setsalry");
    this.salary = sl;
}
int getemp_id()
{
    return this.emp_id;
}
String getemp_name()
{
    return this.emp_name;
}
int getsalary()
{
    return this.salary;
}

void display()
{
   System.out.println("Emp Id is "+ this.emp_id);
    System.out.println("Employee name  is "+ this.emp_name);
     System.out.println("salary is "+ this.salary);
      System.out.println();

}
}
class Test_emp
{
    public static void main(String args[])
    {
        Employee e1;
        Employee e2;
        e1 = new Employee(35,"Robert",6900); // Parameterized
       // e1.setemp_id(001);
        //e1.setemp_name("Ranveer");
        //e1.setslary(4500);
        //System.out.println(e1.emp_id);
         //System.out.println(e1.emp_name);
        //System.out.println(e1.salary);
        e1.display();
        e2 = new Employee();
        e2.display();
        
    }
}
