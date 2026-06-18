package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataDemo {
	public static void main(String[] args) {
		try {
			Connection con = JdbcUtils.getConnection();

			if (con != null) {
				System.out.println("Connection Established Successfully");
			}

			PreparedStatement ps = con.prepareStatement("Select * from student");
			ResultSet rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();

			System.out.println("Total Columns : " + rsmd.getColumnCount());

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {

				System.out.println("Column Name : " + rsmd.getColumnName(i));
				System.out.println("Datatype : " + rsmd.getColumnTypeName(i));
				System.out.println("Column Sizes : " + rsmd.getColumnDisplaySize(i));
			}

//			while (rs.next()) {
//				System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
//			}
			JdbcUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
