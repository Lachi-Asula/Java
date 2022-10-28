
public class Emp_Bean {
	int eid;
	String ename;
	String status;
	double sal;
	
	public Emp_Bean(int eid, String ename, String status, double sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.status = status;
		this.sal = sal;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Emp_Bean [eid=" + eid + ", ename=" + ename + ", status=" + status + ", sal=" + sal + "]";
	}
	
}
