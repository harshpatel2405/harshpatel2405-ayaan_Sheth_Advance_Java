

package servlet;
import java.io.*; // * printWriter
import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;


@WebServlet("/dashboardServlet")
// http://localhost:8080/hello
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		 int id = (int) req.getAttribute("id");
	     String name = (String) req.getAttribute("name");
	     String email = (String) req.getAttribute("email");
	     int age = (int) req.getAttribute("age");
	     String gender = (String) req.getAttribute("gender");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<h1>ID : "+id+"</h1>");
		out.println("<h1>Name : "+name+"</h1>");
		out.println("<h1>Age : "+age+"</h1>");
		out.println("<h1>Gender : "+gender+"</h1>");
		out.println("<h1>Email : "+email+"</h1>");
	}
	
}


