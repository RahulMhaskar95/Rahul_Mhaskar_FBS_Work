
class artist{
	String name ;
	int age;
	
	artist()
	{
		this.name = "Not given";
		this.age = 00;
	}
	artist(String name , int age)
	{
		this.name = name ;
		this.age = age;
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
	@Override
	public String toString() {
		return " Artist name=" + name + ", age=" + age ;
	}
}
class painter extends artist
{
	String painting_style;
	String medium_used;
	int no_of_paintings;
	 
	painter()
	{
		super();
		this.painting_style = "Not mention";
		this.medium_used = "Not mention";
		this.no_of_paintings =00;
		}
	painter(String name , int age , String painting_style , String medium_used , int no_of_paintings )
	{
		super(name , age);
		this.painting_style = painting_style;
		this.medium_used = medium_used;
		this.no_of_paintings = no_of_paintings;
	}
	public String getPainting_style() {
		return painting_style;
	}
	public void setPainting_style(String painting_style) {
		this.painting_style = painting_style;
	}
	public String getMedium_used() {
		return medium_used;
	}
	public void setMedium_used(String medium_used) {
		this.medium_used = medium_used;
	}
	public int getNo_of_paintings() {
		return no_of_paintings;
	}
	public void setNo_of_paintings(int no_of_paintings) {
		this.no_of_paintings = no_of_paintings;
	}
	@Override
	public String toString() {
		return super.toString()+" Painting_style=" + painting_style + ", medium_used=" + medium_used + ", no_of_paintings="
				+ no_of_paintings ;
	}
	
}
class musician extends artist
{
	String instrument;
	String music_genre;
	int no_of_albums;
	 
	musician()
	{
		super();
		this.instrument = "Not mention";
		this.music_genre = "Not mention";
		this.no_of_albums =00;
		}
	musician(String name , int age , String instrument , String music_genre , int no_of_albums )
	{
		super(name , age);
		this.instrument = instrument;
		this.music_genre = music_genre;
		this.no_of_albums = no_of_albums;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getMusic_genre() {
		return music_genre;
	}
	public void setMusic_genre(String music_genre) {
		this.music_genre = music_genre;
	}
	public int getNo_of_albums() {
		return no_of_albums;
	}
	public void setNo_of_albums(int no_of_albums) {
		this.no_of_albums = no_of_albums;
	}
	@Override
	public String toString() {
		return super.toString()+" musician instrument=" + instrument + ", music_genre=" + music_genre + ", no_of_albums=" + no_of_albums
				;
	}
	
}

class actor extends artist
{
	String film_industry;
	int no_of_movies;
	
	actor()
	{
		super();
		this.film_industry = " not given";
		this.no_of_movies = 00;
	}
	actor(String name , int age , String film_industry , int no_of_movies)
	{
		super(name , age);
	    this.film_industry = film_industry;
	    this.no_of_movies = no_of_movies;
	}
	public String getFilm_industry() {
		return film_industry;
	}
	public void setFilm_industry(String film_industry) {
		this.film_industry = film_industry;
	}
	public int getNo_of_movies() {
		return no_of_movies;
	}
	public void setNo_of_movies(int no_of_movies) {
		this.no_of_movies = no_of_movies;
	}
	@Override
	public String toString() {
		return  super.toString()+" actor film_industry=" + film_industry + ", no_of_movies=" + no_of_movies ;
	}

}
public class artist_heirarchy {
	public static void main(String args[])
	{
		artist a1 = new artist();
		System.out.println("A1 info :"+a1.toString());
		System.out.println();
		artist a2 = new musician("Arijit singh",36,"Piano","Classical",45);
		System.out.println("A2 info :"+a2.toString());
		System.out.println();
		artist a3 = new painter("Picaso",46,"natural","Accrylic",100);
		System.out.println("A3 info :"+a3.toString());
		System.out.println();
		artist a4 = new actor("shah rukh khan ",45,"Bollywood",150);
		System.out.println("A4 info :"+a4.toString());
	}

}
