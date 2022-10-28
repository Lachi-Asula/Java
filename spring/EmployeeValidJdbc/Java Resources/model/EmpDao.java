package model;



import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class EmpDao {

	JdbcTemplate jdbc;
	
	public JdbcTemplate jdbcTemplate() {
		DriverManagerDataSource resource = new DriverManagerDataSource();
		resource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		resource.setUrl("jdbc:mysql://localhost:3306/java201");
		resource.setUsername("root");
		resource.setPassword("Asula@143");
		
		return new JdbcTemplate(resource);
	}
	
	public void addEmp(Employee emp) {
		jdbc = jdbcTemplate();
		
		jdbc.update("insert into Employee1(eid,ename,salary,address,email,password) values(?,?,?,?,?,?)",
				emp.getEid(),emp.getEname(),emp.getSalary(),emp.getAddress(),emp.getEmail(),emp.getPassword());
	}
	
	public List<Employee> getEmps(){
		jdbc = jdbcTemplate();
		
		List<Employee> li = jdbc.query("select *from employee1", new BeanPropertyRowMapper<Employee>(Employee.class));
		
		return li;
	}
	
	public void deleteEmp(int id) {
		jdbc = jdbcTemplate();
		
		jdbc.update("delete from employee1 where eid="+id+"");
		
	}
	
	public Employee getEmp(int id) {
		
		jdbc = jdbcTemplate();
		
		Employee e = jdbc.queryForObject("select *from employee1 where eid=?",new Object[] {id} , new BeanPropertyRowMapper<Employee>(Employee.class));
		
		return e;
	}
	
	public void updateEmp(Employee e) {
		jdbc = jdbcTemplate();
		
		jdbc.update("update employee1 set ename=?,salary=?,address=?,email=?,password=? where eid=?",
				e.getEname(),e.getSalary(),e.getAddress(),e.getEmail(),e.getPassword(),e.getEid());
	}
}
