class Student{
    int rollno;
    String name;
    double percentage ;
    void display()
    {
        System.out.println("Rollno is :" + rollno);
         System.out.println("Student name is :" + name);
          System.out.println("Percentage is :" + percentage);
    }
}
class Employee{
    int id;
    String name ;
    double annualSalary;

    void display()
    {
        System.out.println("Emp id is :" + id);
         System.out.println("Employee name is :" + name);
          System.out.println("Annual Salary is :" + annualSalary);
    }
}
class Bank{
    
    double approveloan(Student s)
    {
        if(s.percentage > 80)
        {
            System.out.println("Approve loan amount is :");
            return 200000;
        }
        else if(s.percentage >= 60 && s.percentage < 80)
        {
            System.out.println("Approve loan amount is :");
            return 100000;
        }
        else if(s.percentage >= 40 && s.percentage < 60)
        {
            System.out.println("Approve loan amount is :");
            return 50000;
        }
        else if(s.percentage < 40) 
            {
                System.out.println("No loan Approved :");
                  return 0;
        }
        else 
            return 0;
    
    }
   static double  approveloan(Employee e)
   {
    if(e.annualSalary > 1200000)
    {
        System.out.println("Approved loan amount is :");
        return 700000;
    }
    else if(e.annualSalary >= 1000000 && e.annualSalary <= 1200000)
    {
        System.out.println("Approved loan amount is :");
        return 600000;
    }
    else if(e.annualSalary >= 600000 && e.annualSalary <= 1000000)
    {
     System.out.println("Approved loan amount is :");
        return 500000;   
    }
    else if(e.annualSalary >= 400000 && e.annualSalary <= 600000)
    {
        System.out.println("Approved loan amount is :");
        return 400000;
    }
    else if( e.annualSalary <= 400000)
    {
        System.out.println("Loan is not Approved !");
        return 0;
    }
    else {
        return 0;
    }

   }

}

class loans
{
    public static void main(String argd[])
    {
        Bank b1 = new Bank();
           
        Student s = new Student();
        System.out.println("First student");
        s.rollno = 1;
        s.name = "Rohan";
        s.percentage = 85.00;
        s.display();
        double approvestd1 = b1.approveloan(s);
        System.out.println(approvestd1);
        System.out.println();
         System.out.println("second student");
        s.rollno = 5;
        s.name = "Praksh";
        s.percentage = 75.00;
        s.display();
         double approvestd2 = b1.approveloan(s);
        System.out.println(approvestd2);
           System.out.println();
            System.out.println("third student");
        s.rollno = 8;
        s.name = "Sameer";
        s.percentage = 45.00;
        s.display();
         double approvestd3 = b1.approveloan(s);
        System.out.println(approvestd3);
           System.out.println();
         System.out.println("Forth student");
        s.rollno = 9;
        s.name = "Pradeep";
        s.percentage = 39;
        s.display();
        double approvestd4 = b1.approveloan(s);
        System.out.println(approvestd4);
           System.out.println();

        Bank b2 = new Bank();

        Employee e = new Employee();
        System.out.println("first Employee :");
        e.id = 258;
        e.name = " Dyanada";
        e.annualSalary = 1250500;
        e.display();
        double approveemp1 = b2.approveloan(e);
        System.out.println(approveemp1);
       System.out.println();

         System.out.println("Seccond Employee :");
        e.id = 485;
        e.name = " Shweta";
        e.annualSalary = 1050000;
        e.display();
        double approveemp2 = b2.approveloan(e);
        System.out.println(approveemp2);
        System.out.println();

        System.out.println("third Employee :");
        e.id = 695;
        e.name = " Pramod";
        e.annualSalary = 8050000;
        e.display();
        double approveemp3 = b2.approveloan(e);
        System.out.println(approveemp3);
        System.out.println();

        System.out.println("fourth Employee :");
        e.id = 786;
        e.name = " Dyaneshwari";
        e.annualSalary = 4050000;
        e.display();
        double approveemp4 = b2.approveloan(e);
        System.out.println(approveemp4);
        System.out.println();
        
        System.out.println("fifth Employee :");
        e.id = 566;
        e.name = " Harshal";
        e.annualSalary = 300000;
        e.display();
        double approveemp5 = b2.approveloan(e);
        System.out.println(approveemp5);
        System.out.println();

    }
}



