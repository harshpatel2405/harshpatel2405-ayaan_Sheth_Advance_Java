package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DatabaseMetaDataDemo {
	public static void main(String[] args) {
		try {
			Connection con = JdbcUtils.getConnection();
			if (con != null) {
				System.out.println("Connection Established Successfully");
			}
			// * database meta data
			DatabaseMetaData dbmd = con.getMetaData();

			// * information / meta data of database
			System.out.println("Database Name : " + dbmd.getDatabaseProductName());
			System.out.println("Database Version : " + dbmd.getDatabaseProductVersion());

			System.out.println("Driver Name : " + dbmd.getDriverName());
			System.out.println("Driver Version : " + dbmd.getDriverVersion());

			System.out.println("User Name : " + dbmd.getUserName());

			System.out.println("Supports Transaction : " + dbmd.supportsTransactions());
			System.out.println("Supports Batch Updates : " + dbmd.supportsBatchUpdates());

			JdbcUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
