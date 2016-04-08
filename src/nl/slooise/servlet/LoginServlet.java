package nl.slooise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private String generateHtml(String error){
		// Let op: wen je aan om WEL quotes te gebruiken bij HTML attributen!
		String errorStr = "";
		if(error != null){
			errorStr = "<p class=error>" + error + "</p>";
		}
		return "<!doctype html><html><head><title>Login</title><link rel=stylesheet type=text/css href=style.css> </head>" +
				"<body>" +
				
				errorStr
				
				+ "<form method=post>" +
				
				"<label for=user>Username: </label><input type=text name=user><br>" +
				"<label for=pwd>Password: </label><input type=password name=pwd><br>" +
				"<input type=submit>"
				
				+ "</form></body></html>";
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("user") != null){
			response.sendRedirect("welcome");
				return;
		}
		response.getWriter().append(generateHtml(null));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		String error;
		if((user == null || user.isEmpty()) || (pwd == null || pwd.isEmpty())){
			response.getWriter().append(generateHtml("Niet alle velden zijn ingevuld!"));
			return;
		} 
		
		if(!(user.equals("reindert") && pwd.equals("trednier"))){
			response.getWriter().append(generateHtml("Onjuiste gebruikersnaam of wachtwoord"));
			return;
		}
		
		request.getSession().setAttribute("user", "reindert");
		// correct ingelogd!
		response.sendRedirect("welcome");
	}

}
