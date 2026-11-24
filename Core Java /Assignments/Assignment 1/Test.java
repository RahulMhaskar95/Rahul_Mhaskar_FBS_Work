class Date{
int day ;
int month ;
int year;

Date()
{ 
  System.out.println("in default constructor");
  this.day = 29;
  this.month = 05;
  this.year = 2026 ;

}
Date ( int d , int m , int y)
{
  System.out.println("this is parameterized constructor");
  this.day = d;
  this.month = m;
  this.year = y;
}
//void setDay(Date this, int d)
void setDay(int d) 
{
System.out.println("in setDay ()");
this.day = d;
}

void setMonth(int d) 
{
System.out.println("in setMonth ()");
this.month = d;
}
void setYear(int d) 
{
System.out.println("in setYear ()");
this.year = d;
}
int getday()
{
  return this.day;
}
void display()
{
  System.out.println("Day is " + this.day);
  System.out.println("Month is " +this.month);
  System.out.println("Year is " +this.year);
  System.out.println();
}
}
class Test{
 public static void main(String args[])
{
  Date d1;
  Date d2;// reference 
  d1 = new Date(15,8,2026); // parameterized
   // d1.setDay(26);
     //d1.setMonth(5);
     // d1.setYear(2026);//call
   //setDay(d1,27);
    //System.out.println(d1.day);
    //System.out.println(d1.month);
    //System.out.println(d1.year);
     d1.display();
     d2 = new Date();
      d2.display();
}
}
