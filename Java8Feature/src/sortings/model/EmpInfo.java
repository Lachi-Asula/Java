package sortings.model;

import java.util.ArrayList;
import java.util.List;

public class EmpInfo {

	List<Employee> list = new ArrayList<>();
	
	public EmpInfo() {
		list.add(new Employee(11,"lachi",29000,"9492096265"));
		list.add(new Employee(12,"ameer",2300,"9433545456"));
		list.add(new Employee(13,"leela",29000,"9656434343"));
		list.add(new Employee(14,"gopi",300,"9432322425"));
		list.add(new Employee(15,"siva",12500,"9867236722"));
	}

	public List<Employee> getList() {
		return list;
	}
	
}
