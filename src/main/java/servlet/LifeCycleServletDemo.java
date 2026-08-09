package servlet;
import java.io.*; // * printWriter
import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

@WebServlet("/lifecycle")
// http://localhost:8080/hello
public class LifeCycleServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init()
	{
		System.out.println("Servlet Started");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("service() called");
		
		// * calls doget , dopost method
		super.service(req, res);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
			System.out.println("Do Get Called");
			
			res.setContentType("text/html");
			
			
			
			PrintWriter out = res.getWriter();
			
			
			out.println("<h1>Servlet Lifecycle Demo</h1>");
			out.println("<p>doget() executed successfully</p>");
	}
	
	@Override
	public void destroy()
	{
		System.out.println("Destroy() method called");
	}
	
}
