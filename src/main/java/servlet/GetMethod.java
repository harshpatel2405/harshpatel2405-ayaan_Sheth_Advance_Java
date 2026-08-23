package servlet;
import java.io.*; // * printWriter
import java.util.Map;

import jakarta.servlet.*; // core servlet classes
//import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;

//@WebServlet("/hello1")
// http://localhost:8080/hello
public class GetMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		Map<String , String[]>data = req.getParameterMap();
		
		System.out.println(data.containsKey("uname"));
//		System.out.println(data.containsValue("harsh"));
		
		for(String key : data.keySet())
		{
			System.out.print("\n" + key+ " -> ");
			String [] values = data.get(key);
			
			for(String value : values)
			{
				System.out.println(value);
			}
		}
		
//		setAttrbute 
		req.setAttribute("uname","vasu");
		System.out.println(req.getAttribute("uname"));
		
//	getmethod
		System.out.println("Method Type : " + req.getMethod());
		
//		getRequestUR
		System.out.println("URL : " + req.getRequestURI());
		
//		getContextPath
		System.out.println("Context Path : " + req.getContextPath());
	}
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
//	{
//		//  will tell browser that response will contain html 
//			res.setContentType("text/html");
//			String defaultName = "Harsh";
//			String defaultPassword = "1234";
//			
//			// * will write text into HTTP Response 
//			PrintWriter out = res.getWriter();
//			
//			String name = req.getParameter("uname");
//			String password = req.getParameter("password");			
//			out.println("<html>");
//			out.println("<body>");
//			out.println("<h1>Do Get method (Login Servlet)</h1>");
//			
//			if(name =="" || (name.trim().isEmpty()) )
//			{
//				out.println("<h1>Enter Correct Credentials</h1>");
//			}
//			else
//			{
//				out.println("<h1>Credentials Received</h1>");
//				out.println("<h1>UserName : " + name +"</h1>");
//				out.println("<h1>Password : " + password+"</h1>");
//				
//				if(name.equals(defaultName) && password.equals(defaultPassword))
//				{
//					out.println("<h1>Login Successful</h1>");
//				}
//				else
//				{
//					out.println("<h1>Invalid Credentails</h1>");
//				}
//			}
//			
//			
//			String[]  sports = req.getParameterValues("sports");
//			
//				if(sports== null)
//				{
//					out.println("<p>You have not selected any sports</p>");
//				
//				}else {
//			
//			out.println("<h1>Items Selected : "+sports.length+"</h1>");
//			for(String sport:sports)
//			{
//				out.println("<h2>"+sport+"</h1>");
//			}
//				}
//					
//			
//			
//			out.println("</body>");
//			out.println("</html>");
//			
//			out.close();
//	}
	
}
