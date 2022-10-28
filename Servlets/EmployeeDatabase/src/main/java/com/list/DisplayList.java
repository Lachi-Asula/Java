package com.list;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoemp.DaoDb;
import com.emp.Employee;

/**
 * Servlet implementation class DisplayList
 */
public class DisplayList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		DaoDb db = new DaoDb();
		List<Employee> li = db.listEmp();
		
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<table border=2px solid grey>");
		for(Employee e : li) {
			pw.println("<tr>");
			pw.println("<td>"+e.getEno()+"</td>");
			pw.println("<td>"+e.getEname()+"</td>");
			pw.println("<td>"+e.getSalary()+"</td>");
			pw.println("<td>"+e.getAddress()+"</td>");
			pw.println("<td>"+e.getEmail()+"</td>");
			pw.println("<td>"+e.getPassword()+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		pw.println("</body");
		pw.println("</html>");
	}

}
