package com.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EpaperDb;

/**
 * Servlet implementation class AdminServ
 */
@WebServlet("/AdminServ")
public class AdminServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("aid"));
		String password = request.getParameter("passwd");
		
		EpaperDb edb = new EpaperDb();
		
		if(edb.validAdmin(id, password)) {
			response.sendRedirect("./AdminHome.html");
		}
		else {
			response.sendRedirect("adminsignin.html");
		}
	}

}
