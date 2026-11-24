class player{
	String name;
	int age;
	String country;
	int match_played;
	int jersey_no;
	
	player(){
		System.out.println("this is player default :");
		this.name = "Ms.Dhoni";
		this.age = 44;
		this.country = "INDIA";
		this.match_played = 10000;
		this.jersey_no = 07;
	}
	player(String name, int age, String country , int match_played,int jersey_no)
	{
		this.name = name;
		this.age = age;
		this.country = country;
		this.match_played = match_played;
		this.jersey_no = jersey_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getMatch_played() {
		return match_played;
	}
	public void setMatch_played(int match_played) {
		this.match_played = match_played;
	}
	public int getJersey_no() {
		return jersey_no;
	}
	public void setJersey_no(int jersey_no) {
		this.jersey_no = jersey_no;
	}
	@Override
	public String toString()
	{
		return "Player name :" + name + " Age " + age + " Played for which country :  "+country+" No of Matches Played :"+match_played+" Jersey No: "+jersey_no;
	}
}
class cricketplayer extends player
{
	int total_runs;
	int total_wickets;
	String batting_style;
	String bowling_style;
	
	cricketplayer()
	{
		super();
		this.total_runs = 00;
		this.total_wickets = 00;
		this.batting_style = "not mentioned";
		this.bowling_style = "not mentioned";
	}
	cricketplayer(String name , int age , String country, int match_played, int jersey_no , int total_runs, int total_wickets, String batting_style , String bowling_style)
	{
		super(name , age, country,match_played , jersey_no );
		this.total_runs = total_runs;
		this.total_wickets = total_wickets;
		this.batting_style = batting_style;
		this.bowling_style = bowling_style;
	}
	public int getTotal_runs() {
		return total_runs;
	}
	public void setTotal_runs(int total_runs) {
		this.total_runs = total_runs;
	}
	public int getTotal_wickets() {
		return total_wickets;
	}
	public void setTotal_wickets(int total_wickets) {
		this.total_wickets = total_wickets;
	}
	public String getBatting_style() {
		return batting_style;
	}
	public void setBatting_style(String batting_style) {
		this.batting_style = batting_style;
	}
	public String getBowling_style() {
		return bowling_style;
	}
	public void setBowling_style(String bowling_style) {
		this.bowling_style = bowling_style;
	}
	@Override
	public String toString() {
		return super.toString()+"  total_runs=" + total_runs + ", total_wickets=" + total_wickets + ", batting_style="
				+ batting_style + ", bowling_style=" + bowling_style ;
	}
	
}
class footballplayer extends player{
	int total_goals;
	String playing_position;
	
	footballplayer()
	{
		super();
		this.total_goals = 00;
		this.playing_position = "Nothing";
	}
	footballplayer(String name , int age , String country ,int match_played ,int jersey_no,int total_goals , String playing_position)
	{
		super(name , age, country,match_played , jersey_no);
		this.total_goals = total_goals;
		this.playing_position = playing_position;
	}
	public int getTotal_goals() {
		return total_goals;
	}
	public void setTotal_goals(int total_goals) {
		this.total_goals = total_goals;
	}
	public String getPlaying_position() {
		return playing_position;
	}
	public void setPlaying_position(String playing_position) {
		this.playing_position = playing_position;
	}
	@Override
	public String toString() {
		return super.toString() +" total_goals=" + total_goals + ", playing_position=" + playing_position ;
	}
}

public class player_heirarchy {
	public static void main(String args[]) {
	player p1 = new player();
	System.out.println("MSD info :"+p1.toString());
	player p2 = new cricketplayer(" virat kohli ",38,"India",5000,18,17000,1000,"Agressive","right arm swinger");
	System.out.println("Cricket player info :"+p2.toString());
	player p3 = new footballplayer("C R 7",45,"Portugal",1300,07,973,"Center forward");
	System.out.println("Football player info :"+p3.toString());
}
}