class railways
{
	final int seats = 5;
	public  boolean seats_accept( int seats)
	{
		if(seats > 5 && seats < -1 )
		{
		  System.out.println("No seats are remaining . / invlaid seat no requested .");
		}
		else
		{
			System.out.println("No of seats are available .");
			return true ;
			
		}
		return false;
		
	}
}