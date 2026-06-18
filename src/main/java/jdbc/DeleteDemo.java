package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo {
	public static void main(String[] args) {
		// * mysql credentails
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username = "root";
		String password = "root123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, username, password);

			String sql = "Delete from student where id= ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, 101);

			int rows = ps.executeUpdate();
			System.out.println("Rows Deleted: " + rows);

			if (rows > 0) {
				System.out.println("Rows Deleted Successfully");
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
