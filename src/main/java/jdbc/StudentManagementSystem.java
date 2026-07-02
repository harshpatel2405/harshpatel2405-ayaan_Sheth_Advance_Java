package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*
StudentManagementSystem.java 
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Count Students
7. Topper Details
8. Students Above Marks
9. Sort By Marks
10. Exit
 */

public class StudentManagementSystem {
	static Scanner sc = new Scanner(System.in); 
	
	// * add student
	public static void addStudent()
	{
		try
		{
			Connection con = JdbcUtils.getConnection();
			
			System.out.print("Enter ID : ");
			int id = sc.nextInt();
			
			sc.nextLine();
			System.out.print("Enter Name : ");
			String name = sc.nextLine();
			
			System.out.print("Enter Marks : ");
			int marks = sc.nextInt();
			
			String query = "INSERT INTO STUDENTDEMO VALUES(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1,id);
			ps.setInt(2,marks);
			ps.setString(3, name);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " record inserted Successfully in database");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// * remove student
	public static void removeStudent()
	{
		try
		{
			Connection con = JdbcUtils.getConnection();
			System.out.print("Enter ID which you want to delete : ");
			int id = sc.nextInt();
			
			String query = "delete from studentdemo where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0)
			{
				System.out.println(id + " deleted successfully");
			}else
			{
				System.out.println("Student not found");
			}
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// * get All Students 
	public static void getAllStudents()
	{
		try
		{
			Connection con = JdbcUtils.getConnection();
			String query = "select * from studentdemo";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				System.out.println(rs.getInt("id") + "\t" + rs.getInt("marks") + "\t"+ rs.getString("name"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// * update student
	public static void updateStudent()
	{
		try
		{
			Connection con = JdbcUtils.getConnection();
			System.out.print("Enter ID which you want to Update : ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter new Name to be updated : ");
			String name = sc.nextLine();
			
			System.out.println("Enter Marks to be updated : ");
			int marks = sc.nextInt();
			
			String query = "update studentdemo set name = ?, marks = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setInt(2, marks);
			ps.setInt(3, id);
			int rows = ps.executeUpdate();
			
			if(rows > 0)
			{
				System.out.println(id + " updated successfully");
			}else
			{
				System.out.println("Student not found");
			}
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String [] args)
	{
		try
		{
			Connection con = JdbcUtils.getConnection();
			
			if(con != null)
			{
				System.out.println("Connection Established Successfully..");
			}
			addStudent();
			removeStudent();
			getAllStudents();
			updateStudent();
			
			
			JdbcUtils.closeConnection(con);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
