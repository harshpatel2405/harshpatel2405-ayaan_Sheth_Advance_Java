package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	// * mysql credentails
	private static final String url = "jdbc:mysql://localhost:3306/studentdb";
	private static final String username = "root";
	private static final String password = "root123";

	// * method for connection
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database Connection Failed");
			e.printStackTrace();
		}

		return con;
	}

	// * method for closing connection
	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
				System.out.println("Connection closed successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
