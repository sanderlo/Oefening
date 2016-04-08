package nl.slooise.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Rekenmachine
 */
@WebServlet("/Rekenmachine")
public class Rekenmachine extends HttpServlet {
	
   
    public String maakHTML(ArrayList<Integer> resultaten){
    	

    	
    	String s = "<html><head>"
        		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
        		+ "</head><body>";
    	
    	if (resultaten != null){
    		for (int i : resultaten){
    			s += "<p>" + i + "</p>"; 
    		}
    	}
    	
    	s+= "<form name=\"Productselectie\" method=\"post\" action=\"\">"
		+ "Getal 1: <input type=\"text\" name=\"getal1\"><br>"
		+ "Getal 2: <input type=\"text\" name=\"getal2\"><br>"
		+ "<select name=\"sel\">"
		+ "<option value=\"plus\">+</option>"
		  + "<option value=\"min\">-</option>"
		  + "<option value=\"keer\">*</option>"
	  	+ "<option value=\"deel\">/</option>"
		+ "</select>"
		+ "<input type=\"submit\" value=\"Gekozen\" >"
		+ "</form>"
	  	+ "<form name=\"cl\" method=\"post\" action=\"\">"
		+ "<input type=\"submit\" value=\"clear\" >"
		+ "</form>";
    	
    	s +="</body></html>";
    	return s;
    }
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rekenmachine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (request.getAttribute("resulaten") != null){
			int i = (int)request.getAttribute("uitkomsten");
		}
		response.getWriter().append(maakHTML(null));		
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
		
		String o = request.getParameter("sel");
		int r = 0;
		
		switch(o){
		case "plus": r = (i + j);break;
		case "min": r = (i - j);break;
		case "keer": r = (i * j);break;
		case "deel": r = (i / j);break;
		}
		
		ArrayList<Integer> results;
		
		if (request.getSession().getAttribute("resultaten") != null){
			results = (ArrayList<Integer>)request.getSession().getAttribute("resultaten");
		} else {
			results = new ArrayList<>();
		}
		results.add(r);
		request.getSession().setAttribute("resultaten", results);
		
		response.getWriter().append(maakHTML(results));
	}

}
