package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo  {
	public static void main(String [] args)
	{
		// * mysql credentails
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username ="root";
		String password = "root123";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url , username , password);
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from student");
			
			System.out.println(rs);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("id") + " "  + rs.getString("name"));
			}
			
			st.close();
			con.close();
		
		
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
