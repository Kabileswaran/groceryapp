package projectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.GetConnection;
import projectmodel.Cart;

public class CartDao {
	Scanner sc = new Scanner(System.in);

	public void addToCart() throws ClassNotFoundException, SQLException {
		int cout = 1;
		char check;
		do {
			System.out.println("enter the product name want to  added to cart");
			String pname = sc.nextLine();
			System.out.println("enter the quantity");
			int qp = Integer.parseInt(sc.nextLine());

			Connection con = GetConnection.getConnections();
			String query = "insert into cart value (?,?,?)";
			Cart str = new Cart();

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, 0);

			stmt.setDouble(3, 0);
			stmt.executeUpdate();
			System.out.println("Product Added");

			System.out.println("do you want another product ");
			System.out.println("enter y to continue");
			check = sc.nextLine().charAt(0);
		} while (check == 'y' || check == 'Y');
		cout++;

	}

}
