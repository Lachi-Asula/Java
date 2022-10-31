package Java8Features.sortings_Stream.list.model;

public class Employee {

	private int eid;
	private String ename;
	private double salary;
	private String mobileNum;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, double salary, String mobileNum) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.mobileNum = mobileNum;
	}

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

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", mobileNum=" + mobileNum + "]";
	}

		
}
