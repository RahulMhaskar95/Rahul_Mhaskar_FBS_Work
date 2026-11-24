    class Calculator{
        int fs_no;
        int s_no;
        double t_no;
        double fr_no;

    int add(int fs_no , int s_no)
    {
        return fs_no + s_no;
    }
    double add(double t_no , double fr_no)
    {
        return (t_no + fr_no);
    }
    double add(int fs_no , double t_no)
    {
        return fs_no + t_no;
    }
    double add(double fr_no , int s_no)
    {
        return fr_no + s_no;
    }
    int sub(int fs_no , int s_no)
    {
        return fs_no - s_no;
    }
    double sub(double t_no , double fr_no)
    {
        return t_no - fr_no;
    }
    double  sub(int fs_no , double t_no)
    {
        return fs_no - t_no;
    }
    double sub(double fr_no , int s_no)
    {
        return fr_no - s_no;
    }
    int multi(int fs_no , int s_no)
    {
        return fs_no * s_no;
    }
    double multi(double t_no , double fr_no)
    {
        return t_no * fr_no;
    }
    double multi(int fs_no , double t_no)
    {
        return fs_no * t_no;
    }
    double multi(double fr_no , int s_no)
    {
        return fr_no * s_no;
    }
    double div(int fs_no , int s_no)
    {
        return fs_no / s_no;
    }
    double div(double t_no , double fr_no)
    {
        return t_no  / fr_no;
    }
    double div(int fs_no , double t_no)
    {
        return fs_no / t_no;
    }
    double div(double fr_no , int s_no)
    {
        return fr_no / s_no;
    }
    
    int Fs_no()
    {
        return this.fs_no;
    }
    int S_no()
    {
        return this.s_no;
    }
    double T_no()
    {
        return this.t_no;
    }
    double Fr_no()
    {
        return this.fr_no;
    }
}
    class Calci
    {
        public static void main(String args[])
        {
            Calculator c = new Calculator();
         System.out.println("Addition Results");
         System.out.println(c.add(14, 15));
        System.out.println(c.add(9.6, 4.5));
        System.out.println(c.add(80, 6.3));
        System.out.println(c.add(5.5, 25));
        System.out.println("Subtraction Results");  
        System.out.println(c.sub(14, 15));
        System.out.println(c.sub(9.6, 4.5));
        System.out.println(c.sub(80, 6.3));
        System.out.println(c.sub(5.5, 25));  
        System.out.println("Multiplication Results");
        System.out.println(c.multi(14, 15));
        System.out.println(c.multi(9.6, 4.5));
        System.out.println(c.multi(80, 6.3));
        System.out.println(c.multi(5.5, 25)); 
        System.out.println("Division Results");
        System.out.println(c.div(14, 15));
        System.out.println(c.div(4.5 , 9.6));
        System.out.println(c.div(80, 6.3));
        System.out.println(c.div(5.5, 25));  
        }
    }