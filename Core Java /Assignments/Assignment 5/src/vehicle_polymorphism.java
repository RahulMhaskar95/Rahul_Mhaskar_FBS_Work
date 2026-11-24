import java.util.Objects;

class vehicle{
	int vehicle_no;
	String company_name;
	int no_of_wheels;
	double price;
	
	vehicle(){
		System.out.println("In Vehicle constructor:");
		this.vehicle_no = 0;
		this.company_name =" Not given ";
		this.no_of_wheels = 0;
		this.price = 1000;
	}
	vehicle(int vehicle_no , String company_name , int no_of_wheels ,double price)
	{ this.vehicle_no = vehicle_no;
	  this.company_name = company_name;
	  this.no_of_wheels = no_of_wheels;
	  this.price = price;
}
	public int getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(int vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getNo_of_wheels() {
		return no_of_wheels;
	}
	public void setNo_of_wheels(int no_of_wheels) {
		this.no_of_wheels = no_of_wheels;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void apply_brake()
	{
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(vehicle_no,company_name,no_of_wheels,price);
	}
	@Override
	public String toString()
	{
		return "vehicle no :"+ vehicle_no +" Company name :"+company_name+" No of wheels:"+no_of_wheels+" Price of vehicle :"+price;
	}
}
class Bike extends vehicle
{
	int no_of_stands;
	int no_of_helmets;
	String bike_category;
	
	Bike()
	{
		super();
		this.no_of_stands = 0;
		this.no_of_helmets = 0;
		this.bike_category = "Not given";
    }
	Bike(int vehicle_no,String company_name,int no_of_wheels, double price,int no_of_stands, int no_of_helmets, String bike_category)
	{
		super(vehicle_no, company_name,no_of_wheels, price);
		this.no_of_stands = no_of_stands;
		this.no_of_helmets = no_of_helmets;
		this.bike_category = bike_category;
	}
	public int getNo_of_stands() {
		return no_of_stands;
	}
	public void setNo_of_stands(int no_of_stands) {
		this.no_of_stands = no_of_stands;
	}
	public int getNo_of_helmets() {
		return no_of_helmets;
	}
	public void setNo_of_helmets(int no_of_helmets) {
		this.no_of_helmets = no_of_helmets;
	}
	public String getBike_category() {
		return bike_category;
	}
	public void setBike_category(String bike_category) {
		this.bike_category = bike_category;
	}
	@Override
	public void  apply_brake()
	{
		System.out.println("front handle brake , clutch pressed and right side reverse brake applied");
	}
	@Override
	public String toString() {
		return super.toString() +" No_of_stands =" + no_of_stands + ", no_of_helmets=" + no_of_helmets + ", bike_category="
				+ bike_category + "";
	}
	
}
class car extends vehicle
{
	String has_power_steering;
	String drive_mode;
	int parking_sensors;
	
	car()
	{
		super();
		this.has_power_steering = "not given";
		this.drive_mode ="Not givem";
		this.parking_sensors = 0;
	}
	car(int vehicle_no,String company_name,int no_of_wheels, double price,String has_power_steering, String  drive_mode, int parking_sensors)
	{
		super(vehicle_no, company_name,no_of_wheels, price);
		this.has_power_steering = has_power_steering;
		this.drive_mode = drive_mode;
		this.parking_sensors = parking_sensors;
   }
	public String getHas_power_steering() {
		return has_power_steering;
	}
	public void setHas_power_steering(String has_power_steering) {
		this.has_power_steering = has_power_steering;
	}
	public String getDrive_mode() {
		return drive_mode;
	}
	public void setDrive_mode(String drive_mode) {
		this.drive_mode = drive_mode;
	}
	public int getParking_sensors() {
		return parking_sensors;
	}
	public void setParking_sensors(int parking_sensors) {
		this.parking_sensors = parking_sensors;
	}
	 @Override
		public void apply_brake()
		{
			System.out.println("Brake paddle press with clutch paddle pressed , gear downed");
		}
	@Override
	public String toString() {
		return super.toString() +" Power Steering  =" + has_power_steering + ", Drive Mode =" + drive_mode + ", No of Parking Sensors"
				+ parking_sensors + "";
	}
}	
class bus extends vehicle
{
	int passenger_capacity;
	int standing_capacity;
	
	bus()
	{
		super();
		this.passenger_capacity = 0;
		this.standing_capacity = 0;
	}
	bus(int vehicle_no,String company_name,int no_of_wheels, double price,int passenger_capacity, int standing_capacity)
	{
		super(vehicle_no, company_name,no_of_wheels, price);
		this.passenger_capacity = passenger_capacity;
	    this.standing_capacity = standing_capacity;
 }
	public int getPassenger_capacity() {
		return passenger_capacity;
	}
	public void setPassenger_capacity(int passenger_capacity) {
		this.passenger_capacity = passenger_capacity;
	}
	public int getStanding_capacity() {
		return standing_capacity;
	}
	public void setStanding_capacity(int standing_capacity) {
		this.standing_capacity = standing_capacity;
	}
   @Override
	public void apply_brake()
	{
		System.out.println("Brake paddle press with clutch paddle pressed , gear downed");
	}
	@Override
	public String toString() {
		return super.toString()+" Passenger Capacity=" + passenger_capacity + ", Standing Capacity=" + standing_capacity ;
	}
	
}
public class vehicle_polymorphism {

	public static void main(String[] args) {
		vehicle v2 = new Bike(125565,"bmw",2,500000,2,1,"sport");
		System.out.println("V2 hashCode :"+v2.hashCode());
		System.out.println("v2 display :"+v2.toString());
		v2.apply_brake();
		
		vehicle v3 = new car(5555," AUDI ",4 ,25000000,"Yes", "Manual",9);
		System.out.println("V3 Car details :"+v3.toString());
		v3.apply_brake();
		
	
		
		
		vehicle v5 = new bus(15236 , "Volvo" ,10,9000000,60,20);
		System.out.println("V5 bus details :"+v5.toString());
		v5.apply_brake();
		
		
	
	}

}
