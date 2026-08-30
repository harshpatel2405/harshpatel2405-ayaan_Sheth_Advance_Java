

package servlet;
import java.io.*; // * printWriter
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.*; // core servlet classes
import jakarta.servlet.annotation.WebServlet; //  using servlets without web.xml file 
import jakarta.servlet.http.*;
import jdbc.JdbcUtils;

@WebServlet("/JsLoginServlet")
// http://localhost:8080/hello
public class JSLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("Hello World");
		String email = req.getParameter("email");
		String password= req.getParameter("password");
		

		
		Connection con = JdbcUtils.getConnection();
		try {

			if (con != null) {
				System.out.println("Connection Established Successfully");
			}
			
			String query = "select * from users where email = ? and password=?";
			PreparedStatement ps = con.prepareStatement(query);

			
			
			ps.setString(1,  email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Data is present");
			
					RequestDispatcher rd = req.getRequestDispatcher("/dashboardServlet");
					req.setAttribute("id",rs.getInt("id"));
					req.setAttribute("name",rs.getString("name"));
					req.setAttribute("age",rs.getInt("age"));
					req.setAttribute("gender",rs.getString("gender"));
					req.setAttribute("email",rs.getString("email"));
					
					rd.forward(req,res);
			}
			else 
			{
				System.out.println("Data is not present in DB");
				RequestDispatcher rd = req.getRequestDispatcher("HTML/Phase4/failure.html");
				rd.forward(req,res);
			}

			JdbcUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}


