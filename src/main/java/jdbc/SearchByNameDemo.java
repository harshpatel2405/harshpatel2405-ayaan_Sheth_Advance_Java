package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchByNameDemo {
	public static void main(String[] args) {

		// * mysql credentails
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username = "root";
		String password = "root123";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);

			// String query = "select * from student where name="Harsh";

			String query = "select * from student where name = ?";

			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Name : ");
			String name = sc.next();

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			boolean found = false;
			while (rs.next()) {
				found = true;
				System.out.println("ID : " + rs.getInt("id") + "\tName : " + rs.getString("name"));
			}

			if (!found) {
				System.out.println("Student not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
