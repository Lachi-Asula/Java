package com.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EpaperDb;
import com.users.User_Bean;

/**
 * Servlet implementation class UserServ
 */
@WebServlet("/UserServ")
public class UserServReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String firstName = request.getParameter("fname");
		String surName = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("passwd");
		
		User_Bean ub = new User_Bean(firstName,surName,gender,mobile,email,password);
		EpaperDb edb = new EpaperDb();
		
		if(edb.addUser(ub)) {
			response.sendRedirect("./usersignin.html");
		}
		else {
			pw.println("<h1 style=color:red>Try again</h1>");
		}
	}

}
