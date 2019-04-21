package com.servletJdbcConnect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.User;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	User login=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp=request.getRequestDispatcher("Login.html");
		PrintWriter pw=response.getWriter();
		
		String user=request.getParameter("unm");
		String pass=request.getParameter("pwd");
		
		if(checkLogin(user,pass))
			response.sendRedirect("New.html");
		
		else {
			disp.include(request, response);
			pw.print("<b><br>Sorry try again with proper details!1</b>");
		}
		
	}
	public boolean checkLogin(String user, String pass) {
		System.out.println("Controller layer");
		login=new User();
		return login.getLogin(user,pass);
		
		
	}

	

}
