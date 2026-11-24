class Time {
    int hr, min, sec;

    Time(int hr, int min, int sec) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
        normalize();
    }

    Time add(Time t) {
        return new Time(
                this.hr + t.hr,
                this.min + t.min,
                this.sec + t.sec
        );
    }

    Time addHours(int h) {
        return new Time(this.hr + h, this.min, this.sec);
    }

    Time addMinutes(int m) {
        return new Time(this.hr, this.min + m, this.sec);
    }

    Time addSeconds(int s) {
        return new Time(this.hr, this.min, this.sec + s);
    }

    private void normalize() {
        min += sec / 60;
        sec %= 60;

        hr += min / 60;
        min %= 60;

        hr %= 24;
    }

    void display() {
        System.out.printf("%02d:%02d:%02d%n", hr, min, sec);
    }
}

public class Time_tst {
    public static void main(String[] args) {
        Time t1 = new Time(10, 45, 50);
        Time t2 = new Time(5, 20, 30);

        Time result1 = t1.add(t2);
        result1.display();

        Time result2 = t1.addHours(3);
        result2.display();

        Time result3 = t1.addMinutes(30);
        result3.display();

        Time result4 = t1.addSeconds(80);
        result4.display();
    }
}