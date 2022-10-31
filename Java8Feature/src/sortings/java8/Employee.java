package sortings.java8;
import java.util.ArrayList;
import java.util.List;

public class Employee {

	private int eid;
	private String ename;
	private double salary;
	private int age;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee(int eid, String ename, double salary, int age) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.age = age;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Employee> getEmps() {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee(1, "lachi", 1000, 23));
		emps.add(new Employee(2, "siva", 24000, 20));
		emps.add(new Employee(3, "leela", 5000, 18));
		emps.add(new Employee(4, "ashu", 700, 32));
		emps.add(new Employee(5, "gopi", 900, 28));

		return emps;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", age=" + age + "]";
	}
	
	
}
