package com.grocery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grocery.daoimpl.ProductDaoImpl;
import com.grocery.model.Product;
@WebServlet("/InActiveproduct")


public class InActiveProduct extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productname= req.getParameter("pname");
		String productstatus=req.getParameter("status");
		Product product =new Product();
		product.setProductName(productname);
		product.setProducStatus(productstatus);
		ProductDaoImpl obj =new ProductDaoImpl();
		PrintWriter out=resp.getWriter(); 
		 resp.setContentType("text/html");
		try {
			
			
			boolean	flag =obj.delete(product);
			if(flag)
			{
				 out.print("change product"); 
				 req.getRequestDispatcher("InActiveProducts.jsp").include(req, resp);
					
			}
			else
			{
				 out.print("Fail"); 	
				 req.getRequestDispatcher("InActiveProducts.jsp").include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
