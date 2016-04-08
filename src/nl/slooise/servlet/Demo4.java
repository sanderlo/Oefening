package nl.slooise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo4
 */
@WebServlet("/Demo4/*")
public class Demo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public static final String HTML_START="<html><body><head>"
    		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
    		+ "</head>";
    
    public static final String HTML_END="</body></html>";
	
	public static int secret = (int)(Math.random() * 100); 
    public static int tries = 0;
	public int raden = 0;
	public boolean geraden = false;
	public String hl;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo4() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String maakHTML(String error){
    	
    	String err = "";
    	
    	if (error != null){
    		err = "<p>" + error + "</p>";
    	}
    	
    	String s = "<html><body><head>"
        		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
        		+ "</head>";
    	
    			s += 			
				"<p>Raad een getal tussen de 1 en 100</p>"
				+ "<form name=\"Getalkeuze\" method=\"post\" action=\"\">"
				+ "<input type=\"text\" name=\"getal\"><br>"
				+ "<input type=\"submit\" value=\"Gekozen\" />"
				+ "</form><br>"
				+ err;
    	
    	s += "</body></html>";
    	
    	if (raden != 0){
			if (!geraden){
				s += "<p>Helaas " + raden + " was niet goed.<br>"
					+ "Het geheime getal ligt " + hl + ".</p>";
			}
			else {
				s += "<p>Je hebt het geraden! Je had " + tries + " gokken nodig.</p>"
				+ "<form name=\"Getalkeuze\" method=\"post\" action=\"Demo4\">"
				+ "<input type=\"submit\" value=\"Nieuwe\" />"
				+ "</form><br>";
				geraden = false;
				secret = (int)(Math.random() * 100);
				raden = tries = 0;
			}
		}
    	return s;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.getWriter().append(maakHTML(null));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			raden = Integer.parseInt(request.getParameter("getal"));
		}
		catch (NumberFormatException e){
			response.getWriter().append(maakHTML("Dat is geen getal!"));
			return;
		}
		catch (NullPointerException e){
			response.getWriter().append(maakHTML(null));
			return;
		}

		tries++;
		if (raden == secret){
			geraden = true;
		}
		else if (raden > secret){
			hl = "lager";
		}
		else {
			hl = "hoger";
		}
		
		doGet(request, response);
	}

}
