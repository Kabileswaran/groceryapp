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
@WebServlet("/ModifiyProduct")
public class ModifiyProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		doGet(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException  {
		// TODO Auto-generated method stub
		int Pid= Integer.parseInt(req.getParameter("pID"));
		String product= req.getParameter("pName");
		Product producte = new Product();
		producte.setProductName(product);
		producte.setProductId(Pid);
		ProductDaoImpl obj =new ProductDaoImpl();
		 PrintWriter out=resp.getWriter();  
	
			try {
				boolean	flag =obj.changeName(producte);
					if(flag)
					{
						 out.print("Change price product"); 
						 req.getRequestDispatcher("ChangeProductPrice.jsp").include(req, resp);
							
					}
					else
					{
						 out.print("Fail"); 	
						 req.getRequestDispatcher("ChangeProductPrice.jsp").include(req, resp);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
}
}