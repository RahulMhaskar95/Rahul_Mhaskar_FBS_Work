class SalesManager{
    int sm_id;
    String sm_name ;
    int salary;
    int incentive;
    int target;

SalesManager()
{
    System.out.println("In default constuctor");
    this.sm_id = 126;
    this.sm_name = "rahul";
    this.salary = 15000;
    this.incentive = 5000;
    this.target = 300000;
}
SalesManager(int i, String s, int sl, int ic, int t)
{
    System.out.println("this is parameterized constuctor");
    this.sm_id = i;
    this.sm_name = s;
    this.salary = sl;
    this.incentive = ic;
    this.target = t;
}

void setsm_id(int i)
{
    System.out.println("In setesm_id");
    this.sm_id = i;
}
void setsm_name(String s )
{
     System.out.println("In setsm_name");
    this.sm_name = s;
}
void setsalary(int sl)
{
    System.out.println("In setsalry");
    this.salary = sl;
}
void setincentive(int ic)
{
    System.out.println("In setincentive");
    this.incentive = ic;
}
void settarget(int t)
{
    System.out.println("In settarget");
    this.target = t;
}
int getsm_id()
{
    return this.sm_id;
}
String getsm_name()
{
    return this.sm_name;
}
int getsalary()
{
    return this.salary;
}
int getincentive()
{
    return this.incentive;
}
int gettartget()
{
    return this.target;
}
void display()
{
   System.out.println("Sales manager Id is "+ this.sm_id);
    System.out.println("sales manager name  is "+ this.sm_name);
     System.out.println("salary is "+ this.salary);
      System.out.println("incentive is " + this.incentive);
    System.out.println("target is "+ this.target);
    System.out.println();

}
}
class Test_sm
{
    public static void main(String args[])
    {
        SalesManager sm1;
        SalesManager sm2;
        sm1 = new SalesManager(35,"Robert",6900 , 6000 ,400000); // Parameterized
       // sm1.setsm_id(001);
        //sm1.setsm_name("Ranveer");
        //sm1.setsalary(4500);
        //sm1.setincentive(70000);
        //sm1.settarget(800000);
        //System.out.println(sm1.sm_id);
         //System.out.println(sm1.sm_name);
        //System.out.println(sm1.salary);
        //System.out.println(sm1.incentive);
        //System.out.printlN(sm1.target);
        sm1.display();
        sm2 = new SalesManager();
        sm2.display();
        
    }
}
