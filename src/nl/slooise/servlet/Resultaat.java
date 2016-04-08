package nl.slooise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Resultaat
 */
@WebServlet("/Resultaat/*")
public class Resultaat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultaat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		String s = request.getQueryString();
		int i = Integer.parseInt(s.substring(s.indexOf('a')+1, s.indexOf('b')));
		int j = Integer.parseInt(s.substring(s.indexOf('b')+1, s.indexOf('o')));
		String o = s.substring(s.indexOf('o')+1);
		
		int r = 0;
		
		switch(o){
		case "plus": r = (i + j);break;
		case "min": r = (i - j);break;
		case "keer": r = (i * j);break;
		case "deel": r = (i / j);break;
		}
		
		response.getWriter().append("" + r);
		
		
		session.setAttribute("uitkomsten", r);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		
		
		doGet(request, response);
	//	response.sendRedirect(arg0);
	}

}
