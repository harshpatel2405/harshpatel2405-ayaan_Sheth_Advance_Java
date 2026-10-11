package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieForm")
public class CookieForm extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		String username = req.getParameter("uname");
		String age = req.getParameter("age");
		Cookie co = new Cookie("username", username);
		Cookie co1 = new Cookie("age", age);
		res.setContentType("text/html");
		
		PrintWriter out  = res.getWriter();
		
		if(req.getParameter("action").equals("create"))
		{
			System.out.println("Username :"  + username);
			System.out.println("Age : " + age);
			System.out.println("Object of Cookie Class has been Created..");
			
		
			res.addCookie(co);
			res.addCookie(co1);
			
			out.println("<b>Cookie Sent Successfully in response and set in cookies in browser</b>");
			
		}else if(req.getParameter("action").equals("read"))
		{
				String CookieName1 = co.getName();
				String CookieValue1 = co.getValue();
				String CookieName2 = co1.getName();
				String CookieValue2 = co1.getValue();
				
				out.println("<b>" + CookieName1 + " : " + CookieValue1+"</b><br>");
				out.println("<b>" + CookieName2 + " : " + CookieValue2 + "</b>");
								
		}else if(req.getParameter("action").equals("delete"))
		{
			co.setMaxAge(0);
			res.addCookie(co);
			out.println("<b>Username deleted successfully..</b>");
//			co1.setMaxAge(0);
		}
	}

	private PrintWriter getWriter() {
		// TODO Auto-generated method stub
		return null;
	}
}
