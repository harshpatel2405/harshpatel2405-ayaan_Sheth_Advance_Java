/*
JDBC -- Java Database connectivity 
connect java with db 

1. Load the driver 
2. Create the connection
3. create statement
4. Execute sql statement
5. Process the result
6. close the connection


/ * 
search by id 
insert into table
display all rows of student table
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class JDBCRevisionDemo1 {
	public static void main(String [] args)
	{
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String username ="root";
		String password = "root123";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url , username , password);
			
			Scanner sc  = new Scanner(System.in);
			
			System.out.print("Enter ID to be inserted in database : ");
			int id = sc.nextInt();
			
			String query= "select * from student where id = ?";
			PreparedStatement st = con.prepareStatement(query);
			
			st.setInt(1,id);
			ResultSet rows = st.executeQuery();
			
			
			if(rows.next())
			{
				
				System.out.println("Data is already present");
			}else
			{
				sc.nextLine();
				System.out.print("Enter your name : ");
				String name = sc.nextLine();
				query = "Insert into student values(?,?)";
				
				st = con.prepareStatement(query);
				st.setInt(1, id);
				st.setString(2, name);
				
				int numberOfRows = st.executeUpdate();
				System.out.println(numberOfRows + " record inserted Successfullly");
			}
			
			
			query = "Select * from student";
			ResultSet rs = st.executeQuery(query);
			
			System.out.println("Result set : "+ rs);
			System.out.println("ID\tName\n--\t----");
			while(rs.next())
			{
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
			}
			
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
