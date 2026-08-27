package servlet;
import java.io.*; // * printWriter
import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

@WebServlet("/loginServlet")
// http://localhost:8080/hello
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		//  will tell browser that response will contain html 
			res.setContentType("text/html");
			String defaultName = "Harsh";
			String defaultPassword = "1234";
			
			// * will write text into HTTP Response 
			PrintWriter out = res.getWriter();
			
			out.println("<h1>Login Servlet Page</h1>");
			String name = req.getParameter("uname");
			String password = req.getParameter("pwd");			
			
			if(name.isEmpty() || password.isEmpty())
			{
				out.println("<h1>Enter Credentials .. Dont leave username or password empty</h1>");
				
				return ;
			}
			
			if (defaultName.equals(name) && defaultPassword.equals(password))
			{
//				RequestDispatcher rd = req.getRequestDispatcher("HTML/Phase4/success.html");
//				rd.forward(req, res);
				res.sendRedirect("HTML/Phase4/success.html");
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("HTML/Phase4/failure.html");
				rd.include(req, res);
			}
			
			
			out.close();
	}
	
}
