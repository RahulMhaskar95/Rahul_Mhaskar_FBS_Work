package demoEmpmanagement.model;

public class Employee {
int id;
String name ;
Double salary;
public Employee(int id, String name, double salary) {
	this.id = id;
    this.name = name;
    this.salary = salary;
}
public int getId() {
	return id;
}
public void setIs(int is) {
	this.id = is;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employess [is=" + id + ", name=" + name + ", salary=" + salary + "]";
}
}
