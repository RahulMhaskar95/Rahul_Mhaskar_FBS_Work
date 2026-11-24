
 class shape{ 

	double area ;
	shape()
	{
		System.out.println("This is Shape constructor");
		this.area = 00.0;
	}
	shape(double area)
	{
		this.area = area;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "shape Area =" + area  ;
	}
	
}
class circle extends shape
{
	double radius;
	circle()
	{   super();
		this.radius = 01.0;
	}
	circle(double area ,double radius)
	{   super( area);
		this.radius = radius ;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	@Override
	public String toString()
	{
		return super.toString()+ " Radius of Circle : " + radius ;
		
	}
}
class triangle extends shape
{
	double base;
	double height;
	triangle()
	{   super();
		this.base = 02.0;
		this.height = 03.0;
	}
 triangle(double area ,double base,double height)
	{   super( area);
		this.base = base ;
		this.height = height;
	}
	public double getbase() {
		return base;
	}
	public void setbase(double base) {
		this.base = base;
	}
	public double getheight()
	{
		return height;
	}
	public double setheight(double height)
	{
		return  height;
	}

	@Override
	public String toString()
	{
		return super.toString()+" Base of triangle : " + base + "Height of Triangle " + height  ;
		
	}
}
class rectangle extends shape
{
	double length;
	double breadth;
	rectangle()
	{   super();
		this.length = 04.0;
		this.breadth = 05.0;
	}
 rectangle(double area ,double length,double breadth)
	{   super( area);
		this.length = length ;
		this.breadth = breadth;
	}
	
	public double getLength() {
	return length;
}
 public void setLength(double length) {
	this.length = length;
 }
 public double getBreadth() {
	return breadth;
 }
 public void setBreadth(double breadth) {
	this.breadth = breadth;
 }
	@Override
	public String toString()
	{
		return super.toString()+" length of rectangle : " + length + " breadth of rectangle " + breadth  ;
		
	}
}

public class shape_heirarchy {
public static void main(String args[])
{
	shape s1 = new shape();
	System.out.println("s1 : "+s1.toString());
	
	shape s2 = new circle();
	System.out.println("s2 : "+s2.toString());
	
	shape s3 = new circle(55.5,9.0);
	System.out.println("s3 : "+s3.toString());
	
	shape s4 = new triangle();
	System.out.println("s4 : "+s4.toString());
	
	shape s5 = new triangle(45.5,5.0,6.0);
	System.out.println("s5: "+s5.toString());
	
	shape s6 = new rectangle();
	System.out.println("s6 : "+s6.toString());
	
	shape s7 = new rectangle(65.5,9.5,8.5);
	System.out.println("s7 : "+s7.toString());
	
}
}
