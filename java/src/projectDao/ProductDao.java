package projectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.GetConnection;
import projectmodel.Product;

public class ProductDao {
	Scanner sc = new Scanner(System.in);

	public void insert(Product str) throws ClassNotFoundException, SQLException {
			Connection con = GetConnection.getConnections();
			String query = " insert INTO busesd (products_name,standard_cost)VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, str.getProductName());
			stmt.setDouble(2, str.getProductPrice());
			stmt.executeUpdate();
			System.out.println("Product Added");
	}

	public void delete(Product str) throws ClassNotFoundException, SQLException {
			Connection con = GetConnection.getConnections();
			String query = "delete from  busesd where products_id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, str.getProductId());
			stmt.executeUpdate();
			System.out.println("Product deleted");
	}

	public void changePrice(Product str) throws ClassNotFoundException, SQLException {

			Connection con = GetConnection.getConnections();
			String query = "update ksm_products set price =? where pi=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setDouble(1, str.getProductPrice());
			stmt.setInt(2, str.getProductId());
			stmt.executeUpdate();
			System.out.println("Product price update");
		

	}

	public void changeName() throws ClassNotFoundException, SQLException {
		char check;
		System.out.println("Do You Want Change price of Product \n Y /N");
		check = sc.nextLine().charAt(0);
		if (check == 'y' || check == 'Y') {
			System.out.println("Enter the Product id");
			int cusId = Integer.parseInt(sc.nextLine());
			System.out.println("enter the new Product");
			String productname = sc.nextLine();
			Connection con = GetConnection.getConnections();
			Product str = new Product();
			str.setProductId(cusId);
			str.setProductName(productname);
			String query = "update ksm_products set productname =? where pi=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, str.getProductName());
			stmt.setInt(2, str.getProductId());
			stmt.executeUpdate();
			System.out.println("Product name change");
		}

	}

	public List<Product> viewAllProducts() throws ClassNotFoundException, SQLException {
		Connection con = GetConnection.getConnections();
		Statement stmt = con.createStatement();
		List<Product> productList = new ArrayList<Product>();
		String view = " SELECT * FROM busesd";
		ResultSet rs = stmt.executeQuery(view);
		while (rs.next()) {
			// System.out.println(rs.getInt(2) + " " + rs.getString(1)+" "+ rs.getInt(3));
			Product product = new Product(rs.getInt(2), rs.getString(1), rs.getDouble(3));
			productList.add(product);
		}
		return productList;

	}

}