package com.score;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EpaperDb;
import com.epaper.Epaper_Bean;


/**
 * Servlet implementation class ScoreServ
 */
@WebServlet("/ScoreServ")
public class ScoreServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		session = request.getSession();
		 int score = 0;
		
		EpaperDb epd = new EpaperDb();
		List<Epaper_Bean> li = epd.listQuestions();
		
		for(Epaper_Bean e : li) {
			int eid = e.getQno();
			String str = request.getParameter(""+eid+"");
			String ans = e.getAns();
			
			if(str != null && str.equalsIgnoreCase(ans)) {
				score++;
			}
		}
		if(li.size() <= 10) {
			pw.println("<h1 style=color:green;text-align:center>Score: " + score);
		}
		else {
			session.setAttribute("score", score);
			response.sendRedirect("ScoreServ2");
		}
	}

}
