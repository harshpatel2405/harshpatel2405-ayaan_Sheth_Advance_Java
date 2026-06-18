package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo {
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
			
			PreparedStatement ps =con.prepareStatement("Insert into student values (?,?)");

			//PreparedStatement ps =con.prepareStatement("Insert into student values (1,"Harsh)");
			
			// query = "Insert into student values (1,"Harsh)";
			// PreparedStatement ps =con.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter ID : ");
			int id = sc.nextInt();
			
			System.out.print("Enter name : ");
			String name = sc.next();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.executeUpdate();
			
			
			System.out.println("Connected Successfully");
			
			ps.close();
			con.close();
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
