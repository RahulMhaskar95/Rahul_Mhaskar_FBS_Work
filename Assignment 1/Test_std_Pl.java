class Placed_student{
    int frn;
    String student_name ;
    int distance_covered;
    String company_name;
    String designation;

Placed_student()
{
    System.out.println("In default constuctor");
    this.frn = 026;
    this.student_name = "Rohit";
    this.distance_covered = 12;
    this.company_name = " Infosys";
    this.designation = " developer";

}
 Placed_student(int f, String s, int dc , String cn, String d)
{
    System.out.println("this is parameterized constuctor");
    this.frn = f;
    this.student_name = s;
    this.distance_covered = dc;
    this.company_name = cn;
    this.designation = d ;
}

void setfrn(int f)
{
    System.out.println("In setfrn");
    this.frn = f;
}
void setstudent_name(String s )
{
     System.out.println("In setstudent_name");
    this.student_name = s;
}
void setdistance_covered(int dc)
{
    System.out.println("In setdistsnce_covered");
    this.distance_covered = dc;
}
void setcompany_name(String cn)
{
     System.out.println("In setcompany_name");
     this.company_name = cn;
}
void setdesignation(String d)
{
    System.out.println("In setdesignantion ");
    this.designation = d;
}
int getfrn()
{
    return this.frn;
}
String getstudent_name()
{
    return this.student_name;
}
int getdistance_covered()
{
    return this.distance_covered;
}
String getcompany_name()
{
    return this.company_name;
}
String getdesignantion()
{
    return this.designation;
}
void display()
{
   System.out.println("Frn is "+ this.frn);
    System.out.println("Student name  is "+ this.student_name);
     System.out.println("distance covered is "+ this.distance_covered);
     System.out.println("Company name is" + this.company_name);
     System.out.println("Designation is" +this.designation);
      System.out.println();

}
}
class Test_std_Pl
{
    public static void main(String args[])
    {
        Placed_student s1;
        Placed_student s2;
        s1 = new Placed_student(29,"mia",69 ," Amaezon", " Assistsent"); // Parameterized
       // s1.setfrn(001);
        //s1.setstudent_name("romio");
        //s1.setdistance_covered(45);
        //s1.setcompany_name("TCS");
        //s1.setdesignantion("manager");
        //System.out.println(s1.frn);
         //System.out.println(s1.student_name);
        //System.out.println(s1.distance_covered);
         //System.out.println(s1.comapany_name);
          //System.out.println(s1.designation);
        s1.display();
        s2 = new Placed_student();
        s2.display();
    }
}
