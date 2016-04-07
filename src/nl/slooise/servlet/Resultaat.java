package nl.slooise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String s = request.getQueryString();
		int i = Integer.parseInt(s.substring(s.indexOf('a')+1, s.indexOf('b')));
		int j = Integer.parseInt(s.substring(s.indexOf('b')+1, s.indexOf('o')));
		String o = s.substring(s.indexOf('o')+1);
		
		switch(o){
		case "plus": response.getWriter().append("" + (i + j));break;
		case "min": response.getWriter().append("" + (i - j));break;
		case "keer": response.getWriter().append("" + (i * j));break;
		case "deel": response.getWriter().append("" + (i / j));break;
		}
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
