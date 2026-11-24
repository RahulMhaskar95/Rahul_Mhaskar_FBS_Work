class Shape{
    double area;
    double calculated_area(Triangle t)
    {    
        System.out.println("Area of triangle is :");
        return 0.5*t.base*t.height;
    }
     double calculated_area(Rectangle r)
    {    
        System.out.println("Area of rectangle is :");
        return r.length*r.breadth;
    }
     double calculated_area(Circle c)
    {    
        System.out.println("Area of circle is :");
        return 3.14*c.radius*c.radius;
    }
    }

class Triangle {
    double base;
    double height;
}
class Rectangle{
    double length ;
    double breadth;
}
class Circle{
    double radius;
}

 class totalarea{
    public static void main(String args[])
    {
        Shape s = new Shape();
         
        Triangle t = new Triangle();
        t.base = 10.5;
        t.height = 20.5;

        double tarea = s.calculated_area(t);
        System.out.println(tarea);

        Rectangle r  = new Rectangle();
        r.length = 46;
        r.breadth = 15;

        double rarea = s.calculated_area(r);
        System.out.println(rarea);

        Circle c = new Circle();
        c.radius = 6.9;

        double carea = s.calculated_area(c);
        System.out.println(carea);


    }
}
