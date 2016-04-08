package nl.slooise.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public static final String HTML_START="<html><body><head>"
    		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
    		+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\">"
    		+ "</head>";
    public static final String HTML_END="</body></html>";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		String tekst = HTML_START 
				+ "<p style=\"color:blue\">Welkom op mijn webwinkel voor kantoorartikelen</p>" 
				+ "<p>Voor nu kan je maar 1 product selecteren</p>"
	//			+ "<img src=\"../Serv2/Desert.jpg\"><br>"
				+ "<form name=\"Productselectie\" method=\"get\" action=\"Product\">"
				+ "Product 1 <input type=\"radio\" name=\"products\" value=\"Boeken\" checked><br>"
				+ "Product 2 <input type=\"radio\" name=\"products\" value=\"Pennen\"><br>"
				+ "Product 3 <input type=\"radio\" name=\"products\" value=\"Product3\"><br>"
				+ "<input type=\"submit\" value=\"Gekozen\" />"
				+ "</form>"
				+ HTML_END;
		
		response.getWriter().append(tekst);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}
	
	String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        System.out.println(sb.toString());
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

}
