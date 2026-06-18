// * procedure -- queries which are used again and again and stored inside database and is given a name , and called whenever needed
// * callable statement -- used to call a procedure

package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class CallableStatementDemo {
	public static void main(String[] args) {
		try {
			Connection con = JdbcUtils.getConnection();

			if (con != null) {
				System.out.println("Connection Established Successfully");
			}

			CallableStatement cs = con.prepareCall("{call getStudent()}");

			ResultSet rs = cs.executeQuery();

			while (rs.next()) {
				System.out.println("ID : " + rs.getInt("id") + " \tName : " + rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
