class Admin{
    int am_id;
    String am_name ;
    int salary;
    int allowance;
   

Admin()
{
    System.out.println("In default constuctor");
    this.am_id = 100;
    this.am_name = "ronith";
    this.salary = 15000;
    this.allowance = 5000;
    
}
Admin(int i, String s, int sl, int al)
{
    System.out.println("this is parameterized constuctor");
    this.am_id = i;
    this.am_name = s;
    this.salary = sl;
    this.allowance = al;
}

void setam_id(int i)
{
    System.out.println("In seteam_id");
    this.am_id = i;
}
void setam_name(String s )
{
     System.out.println("In setam_name");
    this.am_name = s;
}
void setsalary(int sl)
{
    System.out.println("In setsalry");
    this.salary = sl;
}
void setallowance(int al)
{
    System.out.println("In setallowance");
    this.allowance = al;
}

int getam_id()
{
    return this.am_id;
}
String getam_name()
{
    return this.am_name;
}
int getsalary()
{
    return this.salary;
}
int getallowance()
{
    return this.allowance;
}

void display()
{
   System.out.println("Admin Id is "+ this.am_id);
    System.out.println("Admin name  is "+ this.am_name);
     System.out.println("salary is "+ this.salary);
      System.out.println("Allowance is " + this.allowance);
    System.out.println();

}
}
class Test_Am
{
    public static void main(String args[])
    {
        Admin am1;
        Admin am2;
        am1 = new Admin(35,"Alexa",6900 , 6006); // Parameterized
       // am1.setam_id(001);
        //am1.setam_name("Grace");
        //am1.setsalary(4500);
        //am1.setallowance(7007);
        //System.out.println(am1.am_id);
         //System.out.println(am1.am_name);
        //System.out.println(am1.salary);
        //System.out.println(am1.allowance);
        am1.display();
        am2 = new Admin();
        am2.display();
        
    }
}
