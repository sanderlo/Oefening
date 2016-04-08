package nl.slooise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cookie1
 */
@WebServlet("/Cookie1")
public class Cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
public String maakHTML(){
    	
    	String s = "<html><head>"
        		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
        		+ "</head><body style=\"background:\">";
    	
    			s += 			
				"<p >Welke achtergrond wil je?</p>"
				+ "<form name=\"formulier\" method=\"post\" action=\"\">"
				+ "<select name=\"keuze\">"
				+ "<option value=\"red\">Rood</option>"
				+ "<option value=\"blue\">Blauw</option>"
			    + "<option value=\"green\">Geel</option>"
				+ "<option value=\"yellow\">Groen</option>"
				+ "</select>"
				+ "<input type=\"submit\" value=\"Gekozen\" />"
				+ "</form><br>";
    	
    			s += "</body></html>";
    	
    	return s;
    }

public String maakHTML2(String sty){
	
	String style = sty;
	   	
	String s = "<html><head>"
    		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
    		+ "</head><body style=\"background:"+ style +"\">";
	
			s += 			
			"<p>Wat een prachtige kleur " + style + "!</p>";
	
			s += "</body></html>";
	
	return s;
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie [] cookies = request.getCookies();
		if (cookies != null)
		for (Cookie c : cookies){
			if (c.getName().equals("keuze")){
				response.getWriter().append(maakHTML2(c.getValue()));
				return;
			}
				
		}
		
		response.getWriter().append(maakHTML());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("keuze");
		Cookie c = new Cookie("keuze", s);
		c.setMaxAge(10);
		response.addCookie(c);
		response.getWriter().append(maakHTML2(s));

	}

}
