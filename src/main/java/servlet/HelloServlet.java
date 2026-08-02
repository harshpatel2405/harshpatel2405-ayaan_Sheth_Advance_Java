package servlet;
import java.io.*; // * printWriter
import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

@WebServlet("/hello")
// http://localhost:8080/hello
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		//  will tell browser that response will contain html 
			res.setContentType("text/html");
			
			// * will write text into HTTP Response 
			PrintWriter out = res.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Hello World from Hello Servlet Class</h1>");
			out.println("</body>");
			out.println("</body>");
			
			out.close();
	}
	
}
