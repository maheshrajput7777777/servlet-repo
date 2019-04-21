package com.Service;

import java.sql.SQLException;
import java.util.List;

import com.daoLayer.LoginDao;

public class User {
	
	
	private String userName;
	private String password;
	
	LoginDao loginDao=null;
	
	public boolean getLogin(String user, String password) {
		
		System.out.println("service lyer..");
		List<User> userList=getUserData();
		for(User login:userList) {
			if(user.equals(login.getUserName())&&password.equals(login.getPassword()))
				return true;
		}
		
		return false;
		
	}
	
	public List<User> getUserData(){
		System.out.println("getUserData");
		loginDao=new LoginDao();
		List<User> list = null;
		try {
			list = (List<User>) loginDao.getUser();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public String getPassword() {
		return password;
		
	}
	
		
	public String getUserName() {
		return userName;
		
	}
	
	public void setUserName(String userName) {
		this.userName=userName;
		
	}

	public void setPassword(String password) {
		this.password=password;
		
	}
	

}
