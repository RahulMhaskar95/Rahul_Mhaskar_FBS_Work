
public class LibraryUser {
 String user_name;
int no_of_days;
static double fine = 19;

public LibraryUser(String user_name  , int no_of_days )
{
	this.user_name = user_name;
	this.no_of_days = no_of_days;
	
}


  public double calculate_fine()
  {
	  return no_of_days * fine;
  }
  
  public void displaylibraryUser()
  {
	  System.out.println("Library User name : "+user_name);
	  System.out.println("No of Days book is being late : "+no_of_days);
	  System.out.println("Calculated Fine : "+calculate_fine());
  }
  
  public static void main(String args[])
  {
	  
	  LibraryUser lb1 = new LibraryUser("Ramesh",15);
	  
	  LibraryUser lb2 = new LibraryUser("Pradeep",20);
	  
	  lb1.displaylibraryUser();
	  System.out.println();
	  lb2.displaylibraryUser();
  }
}
