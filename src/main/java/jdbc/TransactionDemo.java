package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionDemo {
	public static void main(String[] args) {
		Connection con = JdbcUtils.getConnection();
		try {

			if (con != null) {
				System.out.println("Connection Established Successfully");
			}

			con.setAutoCommit(false);

			String withdraw = "Update accounts SET balance = balance - 1500 where id = 101";
			String deposit = "Update accounts set balance = balance + 1500 where id = 102";

			PreparedStatement ps1 = con.prepareStatement(deposit);
			PreparedStatement ps2 = con.prepareStatement(withdraw);

			ps1.executeUpdate();
			ps2.executeUpdate();

			con.commit();

			JdbcUtils.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * Transaction - group of SQL queries which executes as a one unit
 * 
 * Deduct 1000 from Account A Deposit 100 in Account B
 * 
 * If any one fails , money is lost
 * 
 * 1. both queries should successfully get executed (commit) -> commit -> will
 * save changes to database
 * 
 * 2. if one fails , cancel everything (Rollback)
 * 
 */
