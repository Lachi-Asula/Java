package com.delete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EpaperDb;
import com.epaper.Epaper_Bean;

/**
 * Servlet implementation class DelQuestion
 */
@WebServlet("/DelQuestion")
public class DelQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		EpaperDb epd = new EpaperDb();
		int qid = Integer.parseInt(request.getParameter("submit"));
		
		if(epd.deleteQuestion(qid)) {
			response.sendRedirect("AdminEpaper.jsp");
		}
		else {
			pw.println("<h1 style=color:red>Try Again</h1>");
		}
	}

}
