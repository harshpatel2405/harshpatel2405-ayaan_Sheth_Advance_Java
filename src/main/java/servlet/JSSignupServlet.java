

package servlet;
import java.io.*; // * printWriter
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;
import jdbc.JdbcUtils;

@WebServlet("/jsSignupServlet")
// http://localhost:8080/hello
public class JSSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("Hello World");
		
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String password= req.getParameter("password");
		

		
		Connection con = JdbcUtils.getConnection();
		try {

			if (con != null) {
				System.out.println("Connection Established Successfully");
			}
			
			String query = "Insert into users values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3,email);
			ps.setInt(4,  age);
			ps.setString(5, gender);
			ps.setString(6, password);
			
			
			int rows = ps.executeUpdate();
			
			if(rows > 0)
			{
				System.out.println("data added Successfully");
				RequestDispatcher rd = req.getRequestDispatcher("HTML/JSLogin.html");
				rd.forward(req,res);
			}
			else{
				System.out.println("Data has not beed added in DB");
				res.sendRedirect("HTML/JSSignup.html");			
			}

			JdbcUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}


