// * Batch - group 
// * batch Processing -- directing group to database instead of one by one 

package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchProcessingDemo {
	public static void main(String[] args) {
		try {
			Connection con = JdbcUtils.getConnection();

			if (con != null) {
				System.out.println("Connection Established Successfully..");
			}

			// *batch
			String query = "Insert into student values (?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, 101);
			ps.setString(2, "Ram");
			ps.addBatch();

			ps.setInt(1, 102);
			ps.setString(2, "Shyam");
			ps.addBatch();

			ps.setInt(1, 103);
			ps.setString(2, "Madhav");
			ps.addBatch();

			int[] result = ps.executeBatch();
			System.out.println("Rows Inserted : " + result.length);
			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
			}

			// * this is time consuming and makes two trips to database
			/*
			 * String query = "Insert into student values(102,'Vasu')"; PreparedStatement ps
			 * = con.prepareStatement(query); ps.executeUpdate();
			 * 
			 * query = "Insert into student values(103,'Dev')"; ps =
			 * con.prepareStatement(query); ps.executeUpdate();
			 */
			JdbcUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
