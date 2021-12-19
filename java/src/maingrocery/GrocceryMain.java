package maingrocery;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import connection.GetConnection;
import projectDao.CustomerDao;
import projectDao.OrderDao;
import projectDao.ProductDao;
import projectmodel.Customer;
import projectmodel.Order;
import projectmodel.Product;

public class GrocceryMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int n = 0;
		int userid = 0;
		int orderid = 0;
		boolean flag = false;
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
		if(userid==21)
		{
			System.out.println("welcome admin");
			System.out.println("welcome\n 1)viewproduct \n 2)add product\n3)delete product \n4) change price of product");
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
			case 3:
				
				break;
			case 4:
				break;
			default:
				System.out.println("enter the valid option");
				break;
			}
			
			
		}
		else {
		System.out.println(" 1)view product/n 2)view profile");
		n = Integer.parseInt(sc.nextLine());
		switch (n) {
		case 1:
			// show product
			 viewProduct();
				// added to cart
				System.out.println("1)added to cart");
				switch (n) {
				// change password
				case 1:
					do {
						Order str = new Order();
						str.setCustomerid(userid);
						OrderDao order = new OrderDao();
						order.creatingOrderId(str);
						orderid = order.GettingOrderID(str);
						System.out.println("enter the product id");
						int pid = Integer.parseInt(sc.nextLine());
						System.out.println("enter the product quantiy");
						int quantity = Integer.parseInt(sc.nextLine());
						System.out.println("1)do you want added another product ");
						int pad = Integer.parseInt(sc.nextLine());
						if (pad == 1) {
							flag = true;
						}
					} while (flag);

					System.out.println(
							"1)do you want added another product \n2) do you want to place order \n3) change quantity");
					switch (n) {
					case 1:
						break;
					case 2:
						break;
					case 3:

						break;
					default:
						System.out.println("enter the valid option");
						break;
					}
				case 2:
					System.exit(0);
					break;
				default:
					System.out.println("enter the valid option");
					break;
				}			
			break;
		case 2:
			// view profile
			Customer str2 = new Customer();
			CustomerDao obj5 = new CustomerDao();
			str2.setCustomerid(userid);
			obj5.viewLoginUser(str2);
			System.out.println("1)do you want change password 2) exit");
			n = Integer.parseInt(sc.nextLine());
			switch (n) {
			// change password
			case 1:

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
				obj6.changepassword(str3);
				break;
			case 2:
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
public static void viewProduct() throws ClassNotFoundException, SQLException
{
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
