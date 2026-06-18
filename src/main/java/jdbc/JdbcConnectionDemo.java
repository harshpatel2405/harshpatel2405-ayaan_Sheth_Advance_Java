package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionDemo {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    "root123");

            if (con != null) {
                System.out.println("Database Connected Successfully!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}