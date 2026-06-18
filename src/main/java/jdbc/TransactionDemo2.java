package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionDemo2 {
	public static void main(String[] args) {
		Connection con = JdbcUtils.getConnection();
		try {

			if (con != null) {
				System.out.println("Connection Established Successfully");
			}

			con.setAutoCommit(false);

			String withdraw = "Update accounts SET balance = balance - ? where id = ?";
			String deposit = "Update accounts set balance = balance + ? where id = ?";

			PreparedStatement ps1 = con.prepareStatement(withdraw);
			PreparedStatement ps2 = con.prepareStatement(deposit);

			// * withdraw
			ps1.setInt(1, 2000);
			ps1.setInt(2, 103);
			ps1.executeUpdate();
			System.out.println("Money Withdrawn from your accout");

			// * error
			int x = 10 / 0;

			// * deposit
			ps2.setInt(1, 3000);
			ps2.setInt(2, 104);
			ps2.executeUpdate();
			System.out.println("Money Depositted into your accout");

			con.commit();
			System.out.println("Transaction Comitted Successfully..");

			JdbcUtils.closeConnection(con);
		} catch (Exception e) {
			try {
				if (con != null) {
					con.rollback();
					System.out.println("Transaction rolled back");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			e.printStackTrace();
		}
	}
}
