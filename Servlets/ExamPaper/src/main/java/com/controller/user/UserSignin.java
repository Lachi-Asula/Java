package com.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EpaperDb;

/**
 * Servlet implementation class UserSignin
 */
@WebServlet("/UserSignin")
public class UserSignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession sess = request.getSession(true);
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		System.out.println("Hello");
		EpaperDb edb = new EpaperDb();
		
		if(edb.validUser(email, passwd)) {
			String fullName = edb.getUserName(email, passwd);
			sess.setAttribute("fname", fullName);
			
			response.sendRedirect("./Epaper.jsp");
		}
		else {
			response.sendRedirect("./usersignin.html");
		}
	}

}
