package com.JDBC_project;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class JdbcTest {
	
	static String CLASS_PATH="com.mysql.cj.jdbc.Driver";
	static String URL="jdbc:mysql://127.0.0.1:3306/student";
	static String USER_NAME="root";
	static String PASSWORD="Admin";  
	
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query="insert into course values(1,'wassi','mcs',45)";
		String query1="select *from course";
		
		
		
		Class.forName(CLASS_PATH);
		System.out.println("classes loaded");
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		DatabaseMetaData db=con.getMetaData();
		//System.out.println("connected...");
		
		Statement stmt=con.createStatement();
		/*stmt.execute(query);
		System.out.println("values inserted");
		*/
		ResultSet rs=stmt.executeQuery(query1);
		
		
		while(rs.next()){
			int id=rs.getInt(1);
			String courseName=rs.getString(2);
			String hod=rs.getString(3);
			int minMarks=rs.getInt(4);
			
			System.out.println("id:::"+id);
			System.out.println("course name::"+courseName);
			System.out.println("hod:::"+hod);
			System.out.println("min marks::"+minMarks);
			
			System.out.println("***********");		
			
		}
		
		ResultSetMetaData data=rs.getMetaData();
		System.out.println("total column"+data.getColumnCount());
		System.out.println(data.getColumnTypeName(1));
		
		
		
		
		
		
		
		

	}

}
