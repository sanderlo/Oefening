package nl.slooise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Demo3
 */
@WebServlet("/Demo3")
public class Demo3 extends HttpServlet {
	
   
    public String maakHTML(int resultaten){
    	int r = resultaten;
    	
    	String s = "<html><head>"
        		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
        		+ "</head><body>";
    	s+= r + "<br>"; 
    	s+= "<form name=\"Productselectie\" method=\"post\" action=\"\">"
		+ "Getal 1: <input type=\"text\" name=\"getal1\"><br>"
		+ "Getal 2: <input type=\"text\" name=\"getal2\"><br>"
		+ "<select name=\"sel\">"
		+ "<option value=\"plus\">+</option>"
		  + "<option value=\"min\">-</option>"
		  + "<option value=\"keer\">*</option>"
	  	+ "<option value=\"deel\">/</option>"
		+ "</select><br>"
		+ "<input type=\"submit\" value=\"Gekozen\" />"
		+ "</form>";
    	
    	s +="</body></html>";
    	return s;
    }
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (request.getAttribute("uitkomsten") != null){
			int i = (int)request.getAttribute("uitkomsten");
		}
		response.getWriter().append(maakHTML(0));		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		try {
			i = Integer.parseInt(request.getParameter("getal1"));
			j = Integer.parseInt(request.getParameter("getal2"));
		}
		catch(NumberFormatException e) {
			response.sendError(404, "Dit was geen juiste invoer!");
		}
		
		response.sendRedirect("Resultaat?a" + i + "b" + j + "o" + request.getParameter("sel"));
		
		doGet(request, response);
	}

}
