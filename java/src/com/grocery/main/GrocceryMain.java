package com.grocery.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.grocery.dao.CartDao;
import com.grocery.dao.CustomerDao;
import com.grocery.dao.OrderDao;
import com.grocery.dao.ProductDao;
import com.grocery.model.Cart;
import com.grocery.model.Customer;
import com.grocery.model.Order;
import com.grocery.model.Product;

public class GrocceryMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int n = 0;
		int userid = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome\n 1)login\n 2)register");
		n = Integer.parseInt(sc.nextLine());
		switch (n) {
		case 1:
			userid = login();
			break;
		case 2:
			// registering process
			registion();
			// login
			userid = login();
			break;
		default:
			System.out.println("enter the valid option");
			break;
		}
		if (userid == 1) {
			System.out.println("welcome admin");
			do {
			System.out.println(
					"1)viewproduct \n2)add product\n3)delete product \n4) change price of product \n5) today sale\n6) week sale\n7) change password\n8)changeproduct\n9)show all user\n10 logout");
			n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				// show all product to admin
				viewProduct();
				break;
			case 2:
				// add product to admin
				addProduct();
				break;
			case 3:
				// delete product to admin
				deleteProduct();
				break;
			case 4:
				// change price of product
				changePrice();
				break;
			case 5:
				// today sale
				OrderDao obj = new OrderDao();
				obj.todaySale();
				break;
			case 6:
				// week sale
				OrderDao obj1 = new OrderDao();
				obj1.weekSale();
				break;
			case 7:
				// change password
				changePassword(userid);
			case 8:
				// show user
				changeproduct();
				break;
			case 9:
				CustomerDao obj5 = new CustomerDao();
				obj5.viewallLoginUser();
				break;
				
			
			}
			} while(n!=10);
			System.exit(0);
		} else {
			System.out.println(" 1)view product/n 2)view profile");
			n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				viewProduct();
				System.out.println("1)To make order 2)exit");
				n = Integer.parseInt(sc.nextLine());
				switch (n) {
				case 1:
					makeOrder(userid);
					break;
				case 2:
					System.exit(0);
					break;
				}
				break;
			case 2:
				// view profile
				Customer str2 = new Customer();
				CustomerDao obj5 = new CustomerDao();
				str2.setCustomerid(userid);
				obj5.viewLoginUser(str2);
				System.out.println("1)do you want change password \n2)view order \n3) exit");
				n = Integer.parseInt(sc.nextLine());
				switch (n) {
				case 1:
					// change password
					changePassword(userid);
					break;
				case 2:
					System.out.println(userid);
					viewOrder(userid);
					System.out.println("1) enter the orderId to view full detail \n2)exit");
					n = Integer.parseInt(sc.nextLine());
					switch (n) {
					case 1:
						viewUserOrder();
						break;
					case 2:
						System.exit(0);
						break;
					default:
						System.out.println("enter the valid option");
						break;
					}
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("enter the valid option");
					break;
				}
				break;
			default:
				System.out.println("enter the valid option");
				break;
			}
		}
	}

	public static void viewUserOrder() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the order id");
		int orders =Integer.parseInt(sc.nextLine());
		Order order = new Order();
		order.setOrderid(orders);
		OrderDao obj = new OrderDao();
		obj.userOrderDetails(order);
	}

	public static void viewOrder(int userid) throws ClassNotFoundException, SQLException {
		Order order1 = new Order();
		order1.setCustomerid(userid);
		OrderDao obj = new OrderDao();
		obj.orderdetails(order1);
	}

	public static void makeOrder(int userid) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		int productprice;
		List<Integer> productid = new ArrayList<Integer>();
		List<Integer> productquantiy = new ArrayList<Integer>();
		int n = 0;
		int quantity;
		Scanner sc = new Scanner(System.in);
		// added to cart
		System.out.println("1)added to cart");
		n = Integer.parseInt(sc.nextLine());
		switch (n) {
		case 1:
			
			char wh;
			do {
				System.out.println("enter the product id");
				int pid = Integer.parseInt(sc.nextLine());
				// List<Integer> productid = new ArrayList<Integer>();
				// List<Integer> productquantiy = new ArrayList<Integer>();
				// productid.add(2);
				// check duplicate
				// System.out.println(productid.size());
				// System.out.println(productid.get(0));
				//int i = 0;
				if(!productid.isEmpty())
				{
				 for (int i = 0; i < productid.size(); i++)
				 {
					if (pid == productid.get(i))
					{
						System.out.println("1)do you want to increase quantiy to previous product press 1");
						int valid = Integer.parseInt(sc.nextLine());
						if (valid == 1)
						{
							System.out.println("enter the product quantiy");
							 quantity = Integer.parseInt(sc.nextLine());
							productquantiy.add(productquantiy.size() - 1);
						}
						else 
						{
							break;
						}
					} 
					else {
						//System.out.println("one added");
						productid.add(pid);
					}
				 }
				}
				else {
					//System.out.println("one added");
					productid.add(pid);
					System.out.println("enter the product quantiy");
					quantity = Integer.parseInt(sc.nextLine());
					productquantiy.add(quantity);
				}
//				
//				} while(i <productid.size());
				//productid.add(pid);
//				System.out.println("enter the product quantiy");
//				quantity = Integer.parseInt(sc.nextLine());
//				productquantiy.add(quantity);//
				//ProductDao obj = new ProductDao();
				//Product str12 = new Product();/// check
//				str12.setProductId(productid.indexOf(i));
//				str12.setProductPrice(productquantiy.indexOf(i));
//				productprice = obj.gettingRate(str12);	

				System.out.println("do you want added another product Y/n");
				// int pad = Integer.parseInt(sc.nextLine());
				wh = sc.nextLine().charAt(0);
			} while (wh == 'y' || wh == 'Y');
			
			Order str = new Order();
			str.setCustomerid(userid);
			str.setStatus("place order");
			OrderDao order = new OrderDao();
			order.creatingOrderId(str);
			// getting orderid
			int orderid = order.GettingOrderID(str);

			// break;
			for (int j = 0; j < productid.size(); j++) {
				ProductDao obj1 = new ProductDao();
				Product str11 = new Product();
				str11.setProductId(productid.get(j));//
				// System.out.println(productid.get(j));
				// System.out.println(productid.size());///
				// str12.setProductPrice(productquantiy.indexOf(i));
				productprice = obj1.gettingRate(str11);// productprice
				// for (int k = 0; k < productquantiy.size(); k++) {
				// ProductDao obj12 = new ProductDao();
				// Product str123 = new Product();//
				// str12.setProductPrice(productquantiy.indexOf(k));
				Cart stt = new Cart();
				stt.setOrderid(orderid);
				stt.setProductid(productid.get(j));
				stt.setQuantity(productquantiy.get(j));
				stt.setPrice(productprice);
				CartDao obj5 = new CartDao();
				obj5.addToCart(stt);
				// System.out.println(productquantiy.size());
				// System.out.println("product placed");
				// System.exit(0);
				// }
			}
		}
		System.exit(0);
	}

	public static void changeproduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product id");
		int cusId = Integer.parseInt(sc.nextLine());
		System.out.println("enter the new Product");
		String productname = sc.nextLine();
		Product str = new Product();
		str.setProductId(cusId);
		str.setProductName(productname);
		ProductDao obj = new ProductDao();
		try {
			obj.changeName(str);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void changePassword(int userid) {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		String passname;
		do {
			System.out.println("Enter the password");
			passname = sc.nextLine();
			if (passname.matches("[a-zA-Z0-9@#]+") && passname != "") {
				/// System.out.println("valid");
				flag = false;
			} else {
				// System.out.println("invalid");
				flag = true;
			}
		} while (flag);
		Customer str3 = new Customer();
		CustomerDao obj6 = new CustomerDao();
		str3.setPassword(passname);
		str3.setCustomerid(userid);
		try {
			obj6.changepassword(str3);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void changePrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product id");
		int cusId = Integer.parseInt(sc.nextLine());
		System.out.println("enter the new price");
		int price = Integer.parseInt(sc.nextLine());
		Product str = new Product();
		str.setProductId(cusId);
		str.setProductPrice(price);
		ProductDao obj = new ProductDao();
		try {
			obj.changePrice(str);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product id");
		int cusId = Integer.parseInt(sc.nextLine());
		Product str = new Product();
		str.setProductId(cusId);
		ProductDao obj = new ProductDao();
		try {
			obj.delete(str);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addProduct() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Product Name");
		String pronme = sc.nextLine();
		System.out.println("Enter the price");
		Double price = Double.parseDouble(sc.nextLine());
		Product str = new Product();
		str.setProductName(pronme);
		str.setProductPrice(price);
		ProductDao obj = new ProductDao();
		obj.addproduct(str);
	}

	public static void viewProduct() throws ClassNotFoundException, SQLException {
		// view product
		ProductDao obj = new ProductDao();
		List<Product> productList = obj.viewAllProducts();
		for (int i = 0; i < productList.size(); i++) {
			System.out.println(productList.get(i));
		}
	}

	public static int login() throws ClassNotFoundException, SQLException {

		// login processs
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		String username;
		String passname;
		do {
			System.out.println("Enter the userName");
			username = sc.nextLine();
			if (username.matches("[a-zA-Z]+") && username != "") {
				// System.out.println("valid");
				flag = false;
			} else {
				// System.out.println("invalid");
				flag = true;
			}
		} while (flag);
		do {
			System.out.println("Enter the password");
			passname = sc.nextLine();
			if (passname.matches("[a-zA-Z0-9@#]+") && passname != "") {
				/// System.out.println("valid");
				flag = false;
			} else {
				// System.out.println("invalid");
				flag = true;
			}
		} while (flag);
		Customer str = new Customer();/// nameing conv
		str.setUsername(username);
		str.setPassword(passname);
		CustomerDao obj = new CustomerDao();// name
		int userid = obj.login(str);
		System.out.println("hi" + userid);

		return userid;
	}

	public static void registion() throws ClassNotFoundException, SQLException {
		boolean flag = false;
		String username;
		String password;
		String firstname;
		String lastname;
		String address;
		long phone = 0;
		String emailid;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter the userName");
			username = sc.nextLine();
			if (username.matches("[a-zA-Z]+") && username != "") {
				// System.out.println("valid");
				flag = false;
			} else {
				// System.out.println("invalid");
				flag = true;
			}
		} while (flag);

		do {
			System.out.println("Enter the password");
			password = sc.nextLine();
			if (password.matches("[a-zA-Z0-9@#]+") && password != "") {
//			System.out.println("valid");
				flag = false;
			} else {
				// System.out.println("invalid");
				flag = true;
			}
		} while (flag);

		do {
			System.out.println("Enter the firstName");
			firstname = sc.nextLine();
			if (firstname.matches("[a-zA-Z]+") && firstname != "") {
//			System.out.println("valid");
				flag = false;
			} else {
//			System.out.println("invalid");
				flag = true;
			}
		} while (flag);

		do {
			System.out.println("Enter the lastName");
			lastname = sc.nextLine();
			if (lastname.matches("[a-zA-Z]+") && lastname != "") {
//			System.out.println("valid");
				flag = false;
			} else {
//			System.out.println("invalid");
				flag = true;
			}
		} while (flag);

		do {
			System.out.println("Enter the address");
			address = sc.nextLine();
			if (address.matches("[a-z0-9A-Z,?-]+") && address != "") {
//			System.out.println("valid");
				flag = false;
			} else {
				// System.out.println("invalid");
				flag = true;
			}
		} while (flag);

		do {
			System.out.println("Enter the phonenumber");
			String check = sc.nextLine();
			if (check.matches("[6-9]{1}[0-9]{9}") && (check != "")) {
//			System.out.println("valid");
				flag = false;
				phone = Long.parseLong(check);
				break;
			} else {
				// System.out.println("invalid");
				flag = true;
			}

		} while (flag);
		do {
			System.out.println("Enter the email id");
			emailid = sc.nextLine();
			if (emailid.matches("[a-z]+[@][a-z]{5,}[.][a-z]+") && emailid != "") {
//			System.out.println("valid");
				flag = false;
			} else {
//			System.out.println("invalid");
				flag = true;
			}
		} while (flag);

		Customer str1 = new Customer(username, password, firstname, lastname, address, phone, emailid);
		CustomerDao obj1 = new CustomerDao();
		obj1.signup(str1);
	}

}
