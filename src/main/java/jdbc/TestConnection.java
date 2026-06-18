package jdbc;

import java.sql.Connection;

public class TestConnection {
	public static void main(String[] args) {
		Connection con = JdbcUtils.getConnection();

		if (con != null) {
			System.out.println("Connection established successfully");
		} else {
			System.out.println("Connection not established");
		}

		JdbcUtils.closeConnection(con);
	}
}

