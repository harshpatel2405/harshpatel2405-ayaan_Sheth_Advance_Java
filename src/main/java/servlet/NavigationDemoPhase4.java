package servlet;
import java.io.*; // * printWriter
import java.util.Map;
import jakarta.servlet.*; 
import jakarta.servlet.http.*;


public class NavigationDemoPhase4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		
		String username = req.getParameter("uname");
		String rollNo = req.getParameter("rollNo");
		
		PrintWriter out = res.getWriter();
		if(!rollNo.isEmpty() && !username.isEmpty())
		{				
	    out.println("<h1>Inside Navigation Demo Phase 4</h1>");
	    out.println("<b>Name : " + username + "<b><br/>");
	    out.println("<b>Roll Number : " + rollNo + "<b>");
		}
		else
		{
			out.println("Enter Data to See data over here !!");
		}
	}
	
}
