class Student{
    int frn;
    String student_name ;
    int distance_covered;

Student()
{
    System.out.println("In default constuctor");
    this.frn = 026;
    this.student_name = "rahul";
    this.distance_covered = 12;
}
 Student(int f, String s, int dc)
{
    System.out.println("this is parameterized constuctor");
    this.frn = f;
    this.student_name = s;
    this.distance_covered = dc;
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

void display()
{
   System.out.println("Frn is "+ this.frn);
    System.out.println("Student name  is "+ this.student_name);
     System.out.println("distance covered is "+ this.distance_covered);
      System.out.println();

}
}
class Test_std
{
    public static void main(String args[])
    {
        Student s1;
        Student s2;
        s1 = new Student (29,"mia",69); // Parameterized
       // s1.setfrn(001);
        //s1.setstudent_name("romio");
        //s1.setdistance_covered(45);
        //System.out.println(s1.frn);
         //System.out.println(s1.student_name);
        //System.out.println(s1.distance_covered);
        s1.display();
        s2 = new Student();
        s2.display();
        
    }
}
