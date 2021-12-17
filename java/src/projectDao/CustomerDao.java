package projectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.GetConnection;
import projectmodel.Customer;
import projectmodel.Product;

public class CustomerDao {
	Scanner sc = new Scanner(System.in);


	public void signup() throws ClassNotFoundException, SQLException {
		boolean flag1 = false;
		String username;
		String password;
		String firstname;

		String lastname;
		String address;
		long phone = 0;
		String emailid;
		do {
			System.out.println("Enter the userName");
			username = sc.nextLine();
			if (username.matches("[a-zA-Z]+") && username != "") {
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
//				System.out.println("valid");
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
//				System.out.println("valid");
				flag1 = false;
			} else {
//				System.out.println("invalid");
				flag1 = true;
			}
		} while (flag1);

		do {
			System.out.println("Enter the lastName");
			lastname = sc.nextLine();
			if (lastname.matches("[a-zA-Z]+") && lastname != "") {
//				System.out.println("valid");
				flag1 = false;
			} else {
//				System.out.println("invalid");
				flag1 = true;
			}
		} while (flag1);

		do {
			System.out.println("Enter the address");
			address = sc.nextLine();
			if (address.matches("[a-z0-9A-Z,?-]+") && address != "") {
//				System.out.println("valid");
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
//				System.out.println("valid");
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
//				System.out.println("valid");
				flag1 = false;
			} else {
//				System.out.println("invalid");
				flag1 = true;
			}
		} while (flag1);

		Customer str = new Customer(username, password, firstname, lastname, address, phone, emailid);
		Connection con = GetConnection.getConnections();
		String query = "insert into bus (user_name ,password,first_name,last_name,address,phone, email) values(?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, str.getUsername());
		stmt.setString(2, str.getPassword());
		stmt.setString(3, str.getFirstName());
		stmt.setString(4, str.getLastName());
		stmt.setString(5, str.getAddress());
		stmt.setLong(6, str.getPhonenumber());
		stmt.setString(7, str.getEmailid());
		stmt.executeUpdate();
		System.out.println("successful ");

	}

	public void changepassword() throws ClassNotFoundException, SQLException {
		System.out.println("enter the new password ");
		String passname = sc.nextLine();
		System.out.println("enter the phone number");
		long phone = Long.parseLong(sc.nextLine());
		Customer str = new Customer();
		str.setUsername(passname);
		str.setPhonenumber(phone);
		Connection con = GetConnection.getConnections();
		String query = "update table ksm_customers set password = ? where phonenumber=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, str.getPassword());
		stmt.setLong(2, str.getPhonenumber());
		stmt.executeUpdate();
		System.out.println("password update successful ");
	}

	public void login() throws ClassNotFoundException, SQLException {
		boolean flag = false;
		String username;
		String passname;
		
		do {
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
//					System.out.println("valid");
					flag = false;
				} else {
					// System.out.println("invalid");
					flag = true;
				}
			} while (flag);
			Customer str = new Customer();
			str.setUsername(username);
			str.setPassword(passname);
			//List <Customer>  productList= new ArrayList<Customer>();
			Connection con = GetConnection.getConnections();
			String query = "select first_name,customer_id from bus where user_name= ? and password= ? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, str.getUsername());
			stmt.setString(2, str.getPassword());
			// stmt.executeUpdate();
			
			ResultSet rs = stmt.executeQuery();
	
			if (rs.next()) {
				System.out.println("welcome " + rs.getString("first_name"));
				
				flag = false;
			} else {
				System.out.println("error");
				flag = true;
			}
		} while (flag);
		
	} 

	public void viewLoginUser() throws ClassNotFoundException, SQLException {
		Connection con = GetConnection.getConnections();
		String query = "select first_name,last_name,address,phone,email from bus where customer_id = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		
		Customer str = new Customer();
		//System.out.println(str.getFindcustomerid());
		stmt.setInt(1, 21);
		// stmt.executeUpdate();
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			System.out.println("FIRSTNAME "+rs.getString("first_name") + "\nLASTNAME " + rs.getString("last_name") + "\nADDRESS "
					+ rs.getString("address") + "\nPHONE " + rs.getLong("phone") +"\nEMAIL "+ rs.getString("email"));
		}
		else {
			System.out.println("error");
		}

	}
}
