package controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CrudController extends MultiActionController {
	
	public ModelAndView reg(HttpServletRequest req, HttpServletResponse res)throws Exception {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String mobileNum = req.getParameter("mobile");
		
		Map m = new HashMap();
		m.put("fname", fname);
		m.put("lname", lname);
		m.put("mobile", mobileNum);
		
		System.out.println("SAVE METHOD");
		
		JdbcTemplate jdbcTemplate = jdbcTemplate();
		jdbcTemplate.update("insert into form(firstName,lastName,phone) values(?,?,?)",fname,lname,mobileNum);
		
		return new ModelAndView("success", m);
	}
	
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res)throws Exception {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String mobileNum = req.getParameter("mobile");
		
		Map m = new HashMap();
		m.put("fname", fname);
		m.put("lname", lname);
		m.put("mobile", mobileNum);
		
		System.out.println("UPDATE METHOD");
		
		JdbcTemplate jdbcTemplate = jdbcTemplate();
		jdbcTemplate.update("update form set firstName=?,lastName=?,phone=? where firstName=?",fname,lname,mobileNum,fname);
		
		return new ModelAndView("success", m);
	}
	
	public JdbcTemplate jdbcTemplate() {
		DriverManagerDataSource resource = new DriverManagerDataSource();
		resource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		resource.setUrl("jdbc:mysql://localhost:3306/java201");
		resource.setUsername("root");
		resource.setPassword("Asula@143");
		
		return new JdbcTemplate(resource);
	}
}
