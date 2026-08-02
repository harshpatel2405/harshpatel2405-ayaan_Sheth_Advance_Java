package servlet;
import java.io.*; // * printWriter
import jakarta.servlet.*; // core servlet classes
//import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

//@WebServlet("/hello1")
// http://localhost:8080/hello
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		//  will tell browser that response will contain html 
			res.setContentType("text/html");
			
			// * will write text into HTTP Response 
			PrintWriter out = res.getWriter();
			
			String name = req.getParameter("username");
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Hello World from Hello Servlet Class</h1>");
			
			if(name =="" || (name.trim().isEmpty()))
			{
				out.println("<h1>Welcome, Undefined</h1>");
			}
			else
			{
				out.println("<h1>Welcome" + name + "</h1>");
			}
					
			
			
			out.println("</body>");
			out.println("</html>");
			
			out.close();
	}
	
}
