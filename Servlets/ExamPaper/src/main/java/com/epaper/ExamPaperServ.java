package com.epaper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EpaperDb;

/**
 * Servlet implementation class ExamPaperServ
 */
@WebServlet("/ExamPaperServ")
public class ExamPaperServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamPaperServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String qname = request.getParameter("qname");
		String opt1 = request.getParameter("opt1");
		String opt2 = request.getParameter("opt2");
		String opt3 = request.getParameter("opt3");
		String opt4 = request.getParameter("opt4");
		String ans = request.getParameter("ans");
		
		Epaper_Bean eb = new Epaper_Bean(qname,opt1,opt2,opt3,opt4,ans);
		
		EpaperDb edb = new EpaperDb();
		if(edb.addQuestion(eb)) {
			response.sendRedirect("./AdminHome.html");
		}
		else {
			pw.println("<h1 style=color:red>try Again</h1>");
		}
	}

}
