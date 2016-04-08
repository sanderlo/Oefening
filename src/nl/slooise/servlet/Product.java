package nl.slooise.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product/*")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public static final String HTML_START="<html><body><head>"
    		+ "<meta charset=\"ISO-8859-1\"><title>Index</title>"
    		+ "</head>";
    
    public static final String HTML_END="</body></html>";
    
	public String product1 = "<p>Boeken zijn fantastisch</p>";
	public String product2 = "<p>Pennen zijn ook erg leuk</p>";
	public String product3 = "<p>Product 3 is errrug mooi</p>";
	
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//s = readFile(getServletContext().getRealPath(s));
		
		String s = request.getParameter("products");
		
		nl.rjekker.opdracht.product.Product pr = new nl.rjekker.opdracht.product.DefaultProduct(s, 10, 100);
		
		String tekst = HTML_START;
		switch (s)
		{
		case "Boeken": tekst += pr.getNaam() + pr.ImageURL();break;
		case "Pennen": tekst += pr.getNaam() + pr.ImageURL();break;
		case "Product3": tekst += pr.getNaam() + pr.ImageURL();break;
		default: tekst = "Er gaat iets mis" + HTML_END;
		}
		
		tekst += HTML_END;
		
	//	nl.rjekker.opdracht.product.Product pr = new nl.rjekker.opdracht.product.DefaultProduct(product, 3, 5);
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
