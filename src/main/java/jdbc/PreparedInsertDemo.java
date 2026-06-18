package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedInsertDemo {
	public static void main(String[] args) {
		// * mysql credentails
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username = "root";
		String password = "root123";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);

			String query = "Insert into student values(?,?)";

			Scanner sc = new Scanner(System.in);

			System.out.print("Enter ID : ");
			int id = sc.nextInt();

			System.out.print("Enter Name : ");
			String name = sc.next();

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.setString(2, name);

			int rows = ps.executeUpdate();
			System.out.println(rows + " rows inserted");

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
