package projectDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.GetConnection;
import projectmodel.Cart;

public class CartDao {
	Scanner sc = new Scanner(System.in);

	public void addToCart(Cart stt) throws ClassNotFoundException, SQLException {
			Connection con = GetConnection.getConnections();
			String query = "insert into bsus(order_id,product_id,quantity,price) values (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, stt.getOrderid());
			stmt.setInt(2, stt.getProductid());
			stmt.setInt(3, stt.getQuantity());
			stmt.setInt(4, stt.getPrice());
			stmt.executeUpdate();
			System.out.println("order place success");
			

	}

}
