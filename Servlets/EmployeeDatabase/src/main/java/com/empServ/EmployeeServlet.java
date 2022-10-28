package com.empServ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoemp.DaoDb;
import com.emp.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/http");
		PrintWriter pw = res.getWriter();
		
		String ename = req.getParameter("ename");
		float salary = Float.parseFloat(req.getParameter("sal"));
		String address = req.getParameter("add");
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		
		Employee e = new Employee(ename,salary,address,email,password);
		DaoDb db = new DaoDb();
		
		if(db.addEmployee(e)){
			pw.println("<h2 style=color:green>Registered Successfully" + "</h2>");
		}
		else {
			pw.println("<h2 style=color:red>Try Again " + "</h2>");
		}
	}

}
