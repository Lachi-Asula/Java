package com.list;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoDb.FunBook_Db;
import com.fBook.FunBook_Bean;

/**
 * Servlet implementation class ListUsers
 */
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		FunBook_Db fb = new FunBook_Db();
		List<FunBook_Bean> li = fb.userList();
		
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<table border=1px solid black>");
		for(FunBook_Bean f : li) {
			pw.println("<tr>");
			pw.println("<td>"+f.getId()+"</td");
			pw.println("<td>"+f.getFirstName()+"</td>");
			pw.println("<td>"+f.getSurName()+"</td>");
			pw.println("<td>"+f.getGender()+"</td>");
			pw.println("<td>"+f.getMobile()+"</td>");
			pw.println("<td>"+f.getEmail()+"</td>");
			pw.println("<td>"+f.getPassword()+"</td>");
			pw.println("</tr");
		}
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
