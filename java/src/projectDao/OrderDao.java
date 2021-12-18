package projectDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import connection.GetConnection;
import projectmodel.Customer;
import projectmodel.Order;

public class OrderDao {
	int custmerid=0;
	public void creatingOrderId(Order str)
	{
		Connection con = null;
		try {
			con = GetConnection.getConnections();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query =" INSERT INTO buses (customer_id) VALUES (?)";
	//	String query1="  SELECT order_id FROM buses where customer_id = customer_id  order by order_date desc fetch first rows only";
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, 21);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int GettingOrderID(Order str)
	{Connection con=null;
		try {
			 con =GetConnection.getConnections();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query1="  SELECT order_id FROM buses where customer_id = customer_id  order by order_date desc fetch first rows only";
		try {
			PreparedStatement stmt =con.prepareStatement(query1);
			stmt.setInt(1, 21);
			//stmt.executeUpdate();
			ResultSet rs= stmt.executeQuery();
			if(rs.next())
			{
				 custmerid= rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return custmerid;
}
	

}
