package com.registerServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoDb.FunBook_Db;
import com.fBook.FunBook_Bean;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		FunBook_Bean fb = new FunBook_Bean(firstName,surName,gender,mobile,email,password);
		
		FunBook_Db fdb = new FunBook_Db();
		if(fdb.addUser(fb)) {
			response.sendRedirect("./signin.html");
		}
		else {
			pw.println("<h1 style=color:red>Try Again</h1>");
		}
	}

}
