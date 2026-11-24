package p3;
import p1.Employee;
import p2.subclasses.*;

public class test {
public static void main(String args[])
{
	Employee[] erp = new Employee[3];
	
	erp[0] = new Admin(101,"rajesh",7000,2500);
	erp[1] = new HR(103,"Prathmesh",10000,3600);
	erp[2] = new SalesManager(105,"Priya",5000,1500,25);
	  
	//for (Employee emp : erp) {
		  
	 //emp.calSal();
    // System.out.println(emp);
	//}
	for(int i =  0 ; i< erp.length;i++)
	{
	   Employee emp = erp[i];
		emp.calSal();
		System.out.println(emp);
		
	}
}
}
