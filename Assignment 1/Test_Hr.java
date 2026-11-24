class Hr{
    int hr_id;
    String hr_name ;
    int salary;
    int commission;
   

Hr()
{
    System.out.println("In default constuctor");
    this.hr_id = 100;
    this.hr_name = "ronith";
    this.salary = 15000;
    this.commission = 5000;
    
}
Hr(int i, String s, int sl, int cm)
{
    System.out.println("this is parameterized constuctor");
    this.hr_id = i;
    this.hr_name = s;
    this.salary = sl;
    this.commission = cm;
}

void sethr_id(int i)
{
    System.out.println("In setehr_id");
    this.hr_id = i;
}
void sethr_name(String s )
{
     System.out.println("In sethr_name");
    this.hr_name = s;
}
void setsalary(int sl)
{
    System.out.println("In setsalary");
    this.salary = sl;
}
void setcommission(int cm)
{
    System.out.println("In setcommission");
    this.commission = cm;
}

int gethr_id()
{
    return this.hr_id;
}
String gethr_name()
{
    return this.hr_name;
}
int getsalary()
{
    return this.salary;
}
int getcommission()
{
    return this.commission;
}

void display()
{
   System.out.println("Hr Id is "+ this.hr_id);
    System.out.println("Hr name  is "+ this.hr_name);
     System.out.println("Hr's salary is "+ this.salary);
      System.out.println("commission is " + this.commission);
    System.out.println();

}
}
class Test_HR
{
    public static void main(String args[])
    {
        Hr h1;
        Hr h2;
        h1 = new Hr(95,"Vishwanathan",6905 , 5608); // Parameterized
       // h1.sethr_id(111);
        //h1.sethr_name("Piter");
        //h1.setsalary(4800);
        //h1.setcommission(1001);
        //System.out.println(h1.hr_id);
         //System.out.println(h1.hr_name);
        //System.out.println(h1.salary);
        //System.out.println(h1.commission);
        h1.display();
        h2 = new Hr();
        h2.display();
        
    }
}
