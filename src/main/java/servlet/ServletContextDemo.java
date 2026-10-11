package servlet;
import java.io.*; // * printWriter

import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;


@WebServlet("/servletContext")
public class ServletContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
	
			ServletConfig sc = getServletConfig();
			
			String name = sc.getInitParameter("username");
			String password = sc.getInitParameter("password");
			
			System.out.println("Username : " +name);
			System.out.println("Password : " + password);
 	}
	
}
