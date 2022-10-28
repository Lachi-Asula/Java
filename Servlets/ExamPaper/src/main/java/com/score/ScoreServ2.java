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
 * Servlet implementation class ScoreServ2
 */
@WebServlet("/ScoreServ2")
public class ScoreServ2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int score;
    HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServ2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		score =(Integer)session.getAttribute("score");
		response.sendRedirect("NextEpaper.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		EpaperDb epd = new EpaperDb();
		List<Epaper_Bean> li = epd.listQuestions();
		
		for(int i = 10; i < li.size(); i++) {
			Epaper_Bean epb = li.get(i);
			int eid = epb.getQno();
			String str = request.getParameter(""+eid+"");
			String ans = epb.getAns();
			
			if(str != null && str.equalsIgnoreCase(ans)) {
				score++;
			}
		}
		
		pw.println("<h1 style=color:green;text-align:center>Score: " + score);
	}

}
