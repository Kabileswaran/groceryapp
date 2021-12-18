package maingrocery;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import connection.GetConnection;
import projectDao.CustomerDao;
import projectDao.ProductDao;
import projectmodel.Customer;
import projectmodel.Product;

public class GrocceryMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int n = 0;
		int userid=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome\n 1)login\n 2)register");
		n = Integer.parseInt(sc.nextLine());
		switch (n) {
		case 1:
			//login processs
			boolean flag = false;
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
			Customer str = new Customer();///nameing conv
			str.setUsername(username);
			str.setPassword(passname);
			CustomerDao obj = new CustomerDao();//name
			 userid = obj.login(str);
			System.out.println("hi" + userid);
			break;
		case 2:
			//registering process
			boolean flag1 = false;
			String username1;
			String password;
			String firstname;
			String lastname;
			String address;
			long phone = 0;
			String emailid;
			do {
				System.out.println("Enter the userName");
				username1 = sc.nextLine();
				if (username1.matches("[a-zA-Z]+") && username1 != "") {
					// System.out.println("valid");
					flag1 = false;
				} else {
					// System.out.println("invalid");
					flag1 = true;
				}
			} while (flag1);

			do {
				System.out.println("Enter the password");
				password = sc.nextLine();
				if (password.matches("[a-zA-Z0-9@#]+") && password != "") {
//					System.out.println("valid");
					flag1 = false;
				} else {
					// System.out.println("invalid");
					flag1 = true;
				}
			} while (flag1);

			do {
				System.out.println("Enter the firstName");
				firstname = sc.nextLine();
				if (firstname.matches("[a-zA-Z]+") && firstname != "") {
//					System.out.println("valid");
					flag1 = false;
				} else {
//					System.out.println("invalid");
					flag1 = true;
				}
			} while (flag1);

			do {
				System.out.println("Enter the lastName");
				lastname = sc.nextLine();
				if (lastname.matches("[a-zA-Z]+") && lastname != "") {
//					System.out.println("valid");
					flag1 = false;
				} else {
//					System.out.println("invalid");
					flag1 = true;
				}
			} while (flag1);

			do {
				System.out.println("Enter the address");
				address = sc.nextLine();
				if (address.matches("[a-z0-9A-Z,?-]+") && address != "") {
//					System.out.println("valid");
					flag1 = false;
				} else {
					// System.out.println("invalid");
					flag1 = true;
				}
			} while (flag1);

			do {
				System.out.println("Enter the phonenumber");
				String check = sc.nextLine();
				if (check.matches("[6-9]{1}[0-9]{9}") && (check != "")) {
//					System.out.println("valid");
					flag1 = false;
					phone = Long.parseLong(check);
					break;
				} else {
					// System.out.println("invalid");
					flag1 = true;
				}

			} while (flag1);

			do {
				System.out.println("Enter the email id");
				emailid = sc.nextLine();
				if (emailid.matches("[a-z]+[@][a-z]{5,}[.][a-z]+") && emailid != "") {
//					System.out.println("valid");
					flag1 = false;
				} else {
//					System.out.println("invalid");
					flag1 = true;
				}
			} while (flag1);

			Customer str1 = new Customer(username1, password, firstname, lastname, address, phone, emailid);
			CustomerDao obj1 = new CustomerDao();
			obj1.signup(str1);
			//login
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
			Customer str2 = new Customer();
			str2.setUsername(username);
			str2.setPassword(passname);
			CustomerDao obj2 = new CustomerDao();
			userid = obj2.login(str2);
			System.out.println("hi" + userid);
			break;
		default:
			System.out.println("enter the valid option");
			break;

		}
		System.out.println(" 1)view product/n 2)view profile");
		n = Integer.parseInt(sc.nextLine());

		switch (n) {
		case 1:
			// show product
			ProductDao obj = new ProductDao();
			List<Product> productList = obj.viewAllProducts();
			for (int i = 0; i < productList.size(); i++) {
				System.out.println(productList.get(i));
			}
			// System.out.println(" 2)add product to cart");
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
			//change password
			case 1:
				System.out.println("enter the new password ");
				Customer str3 = new Customer();
				CustomerDao obj6 = new CustomerDao();
				String passname = sc.nextLine();
				str3.setPassword(passname);
				str3.setCustomerid(userid);
				obj6.changepassword( str3);
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
