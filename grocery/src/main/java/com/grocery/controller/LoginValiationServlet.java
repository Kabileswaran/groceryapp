package com.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grocery.daoimpl.CustomerDaoImpl;
import com.grocery.model.Customer;
@WebServlet("/login")
public class LoginValiationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	  long phoneNumber=Long.parseLong(req.getParameter("uname"));
	 String Password=req.getParameter("pword");
	 Customer customer =new Customer();
	 customer.setPhonenumber(phoneNumber);
	 customer.setPassword(Password);
	 CustomerDaoImpl obj=new  CustomerDaoImpl();
	 PrintWriter out=resp.getWriter();  
	 resp.setContentType("text/html");
	 try {
		 
		customer= obj.login(customer);
	
		if(customer.getCustomerid()!=0)
		{
			 HttpSession session=req.getSession();  
		        session.setAttribute("logincustomer", customer);  
			if(customer.getCustomerid()==1)
			{
				resp.sendRedirect("AdminView.jsp");
			}
			else
			{
				resp.sendRedirect("CustomerView.jsp");
			}
		}
		else {
			 out.print("Sorry, username or password incorrect!");  
	
			 req.getRequestDispatcher("Login.jsp").include(req, resp);
			 
			
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
