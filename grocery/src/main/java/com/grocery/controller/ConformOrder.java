package com.grocery.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grocery.daoimpl.CartDaoImpl;
import com.grocery.daoimpl.OrderDaoImpl;
import com.grocery.daoimpl.ProductDaoImpl;
import com.grocery.model.Cart;
import com.grocery.model.Order;
import com.grocery.model.Product;

/**
 * Servlet implementation class ConformOrder
 */
@WebServlet("/ConformOrder")
public class ConformOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConformOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		 int oid= (int) session.getAttribute("logincustomerorderId");	
		 Cart stt=new Cart();
		 stt.setOrderid(oid);
		 CartDaoImpl obj=new CartDaoImpl();
		 try {
			List<Integer> prdid= obj.gettingproductidincart(stt);
			for(int i=0;i<prdid.size();i++)
			{
				Product product=new Product();
				product.setProductId(prdid.get(i));
				ProductDaoImpl obj1= new ProductDaoImpl();
				int value= obj1.gettingRate(product);
				stt.setOrderid(oid);
				stt.setPrice(value);
				stt.setProductid(prdid.get(i));
				obj.insertcurrentvalue(stt);
				
				
			}
			Order order =new Order();
			order.setOrderid(oid);
			OrderDaoImpl obj3=new OrderDaoImpl();
			obj3.makefinal(order);
			response.sendRedirect("CustomerView.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
