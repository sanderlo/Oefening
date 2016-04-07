package nl.slooise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo2
 */
@WebServlet("/Demo2")
public class Demo2 extends HttpServlet {
	
    public static final String HTML_START="<html><body><head>"
    		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
    		+ "</head>";
    
    public static final String HTML_END="</body></html>";
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = HTML_START 
				+ "<form name=\"Productselectie\" method=\"post\" action=\"\">"
				+ "200 <input type=\"radio\" name=\"products\" value=\"200\" checked><br>"
				+ "400 <input type=\"radio\" name=\"products\" value=\"400\"><br>"
				+ "404 <input type=\"radio\" name=\"products\" value=\"404\"><br>"
				+ "418 <input type=\"radio\" name=\"products\" value=\"418\"><br>"
				+ "500 <input type=\"radio\" name=\"products\" value=\"500\"><br>"
				+ "<input type=\"submit\" value=\"Gekozen\" />"
				+ "</form>"
				+ HTML_END;
		
		response.getWriter().append(s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error = request.getParameter("products");
		int err = Integer.valueOf(error);
		response.sendError(err, "Deze fout is een theepot");
		doGet(request, response);
	}

}
