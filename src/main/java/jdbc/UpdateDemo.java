package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDemo {
	public static void main(String[] args) {
		// * mysql credentails
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username = "root";
		String password = "root123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, username, password);

			String sql = "Update student set name=? where id= ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "Shyam Verma");
			ps.setInt(2, 101);

			int rows = ps.executeUpdate();
			System.out.println("Rows Updated: " + rows);

			if (rows > 0) {
				System.out.println("Rows Updated Successfully");
			} else {
				System.out.println("Data Not Found");

			}

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
