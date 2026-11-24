class Employee {
    int id;
    String name;
    double b_salary;

    Employee() {
        System.out.println("In Employee Constructor");
        this.id = 0;
        this.name = "Not given";
        this.b_salary = 10000;
    }

    Employee(int id, String name, double b_salary) {
        this.id = id;
        this.name = name;
        this.b_salary = b_salary;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getSalary() {
        return b_salary;
    }

    void setSalary(double b_salary) {
        this.b_salary = b_salary;
    }

    public double calSal() {
        return b_salary;
    }

    void display() {
        System.out.println("Id : " + id);
        System.out.println("Name : " + name);
        System.out.println("Basic Salary : " + b_salary);
    }
}

class HR extends Employee {

    double commission;

    HR() {
        super();
        commission = 5000;
    }

    HR(int id, String name, double salary, double commission) {
        super(id, name, salary);
        this.commission = commission;
    }

    @Override
    public double calSal() {
        return b_salary + commission;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Commission : " + commission);
    }
}

class Admin extends Employee {

    double allowance;

    Admin() {
        super();
        allowance = 3000;
    }

    Admin(int id, String name, double salary, double allowance) {
        super(id, name, salary);
        this.allowance = allowance;
    }

    @Override
    public double calSal() {
        return b_salary + allowance;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Allowance : " + allowance);
    }
}

class SalesManager extends Employee {

    double incentive;
    int target;

    SalesManager() {
        super();
        System.out.println("In SalesManager Constructor");
        incentive = 7000;
        target = 50000;
    }

    SalesManager(int id, String name, double salary, double incentive, int target) {
        super(id, name, salary);
        this.incentive = incentive;
        this.target = target;
    }

    @Override
    public double calSal() {
        return b_salary + (incentive * target);
    }

    @Override
    void display() {
        super.display();
        System.out.println("Target : " + target);
        System.out.println("Incentive : " + incentive);
    }
}

public class emp_polymorphism {

    public static void main(String[] args) {

        Employee e1, e2, e3, e4;

        e1 = new Employee(101, "Karan", 25000);
        e1.display();
        System.out.println("Employee Salary : " + e1.calSal());

        System.out.println();

        e2 = new SalesManager(102, "Harsha", 28000, 1500, 5);
        e2.display();
        System.out.println("SalesManager Salary : " + e2.calSal());

        System.out.println();

        e3 = new HR(103, "Rahul", 35000, 2000);
        e3.display();
        System.out.println("HR Salary : " + e3.calSal());

        System.out.println();

        e4 = new Admin(104, "Vyankatesh", 35000, 4000);
        e4.display();
        System.out.println("Admin Salary : " + e4.calSal());
    }
}