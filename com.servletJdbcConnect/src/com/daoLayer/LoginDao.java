package com.daoLayer;

import java.util.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Service.User;

public class LoginDao {
	
	static String CLASS_PATH="com.mysql.cj.jdbc.Driver";
	static String URL_PATH="jdbc:mysql://localhost:3306/Student";
	static String USER_NAME="root";
	static String PASSWORD="Admin";
	
	Connection connection=null;
	
	
	
	static String sql="select *from user";
	ResultSet resultSet=null;
	PreparedStatement prepare=null;
	
	public Connection connectTest() throws ClassNotFoundException, SQLException{
		
		Class.forName(CLASS_PATH);
		connection= DriverManager.getConnection(URL_PATH,USER_NAME,PASSWORD);
		System.out.println("DB connected...");
		return connection;
	}
	
	public List<User> getUser() throws ClassNotFoundException, SQLException {
		System.out.println("DAO layer....");
		List<User> list=new ArrayList<>();
		connection=connectTest();
		prepare=connection.prepareStatement(sql);
		resultSet=prepare.executeQuery();
		
		
		while(resultSet.next()) {
			User user=new User();
			 user.setUserName(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			
			list.add(user);
			
		}
		
		System.out.println("Sending list from dao layer....");
		return list;
		
		
		
	}

}
