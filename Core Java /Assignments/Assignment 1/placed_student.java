class PlacedStudent{
int frn ;
String student_name ;
String company_name;
String designation;


PlacedStudent()
{ 
  System.out.println("in default constructor");
  this.frn = 29;
  this.student_name = "Mizukawa";
  this.company_name = "IBM" ;

}
PlacedStudent ( int f , String ch , String cn)
{
  System.out.println("this is parameterized constructor");
  this.frn = f;;
  this.student_name = ch;
  this.company_name = cn;
}
//void setDay(Date this, int d)
void setFrn(int f) 
{
System.out.println("in setfrn ()");
this.frn = f;
}

void setstudent_name(String ch) 
{
System.out.println("in setstudent_name ()");
this.student_name = ch;
}
void setcompany_name(String cn) 
{
System.out.println("in setcompany_name ()");
this.company_name = cn;
}
int getfrn()
{
  return this.frn;
}
String getstudent_name()
{
  return this.student_name;
}
String getcompany_name()
{
  return this.company_name;
}
void display()
{
  System.out.println("frn is " + this.frn);
  System.out.println("student  is " +this.student_name);
  System.out.println("company is " +this.company_name);
  System.out.println();
}
}
class Test_pl_std{
 public static void main(String args[])
{
  PlacedStudent ps1;
  PlacedStudent ps2;// reference 
  ps1 = new PlacedStudent(45,"ROHIT SHeRMA","INDIA"); // parameterized
   // ps1.setfrn(26);
     //ps1.setstudent_name("Rohit");
     // ps1.setcompany_name("IRb");//call
  
    //System.out.println(ps1.frn);
    //System.out.println(ps1.student_name);
    //System.out.println(ps1.company_name);
     ps1.display();
     ps2 = new PlacedStudent();
      ps1.display();
}
}
