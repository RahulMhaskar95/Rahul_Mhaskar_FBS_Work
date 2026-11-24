 class Timer {
    int hr;
    int min;
    int sec;

    // Constructor
    Timer() {
        System.out.println("Current time :");
        this.hr = 5;
        this.min = 15;
        this.sec = 45;
    }

    void display() {
        System.out.println("Hour " + this.hr);
        System.out.println("Minutes " + this.min);
        System.out.println("Seconds " + this.sec);
        System.out.println();
    }
}

 class test {
    public static void main(String args[]) {
       Timer  t1 = new Timer();
        t1.display();
    }
}
