package maingrocery;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import projectDao.CustomerDao;
import projectDao.ProductDao;
import projectmodel.Product;

public class GrocceryMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int n = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome\n 1)login\n 2)register");
		n = Integer.parseInt(sc.nextLine());
		switch (n) {
		case 1:
			CustomerDao obj = new CustomerDao();
			obj.login();
			break;
		case 2:
			CustomerDao obj1 = new CustomerDao();
			obj1.signup();
			obj1.login();
			break;
		default:
			System.out.println("enter the valid option");
			break;

		}
		System.out.println(" 1)view product/n 2)exit");
		n = Integer.parseInt(sc.nextLine());
		
		switch (n) {
		case 1:
			ProductDao obj = new ProductDao();
			List<Product> productList=obj.viewAllProducts();
			for(int i=0;i<productList.size();i++)
			{
			System.out.println(productList.get(i));
			}
			//System.out.println(" 2)add product to cart");
			break;
		case 2:
			CustomerDao obj1 = new CustomerDao();
			//obj1.insert();
			break;
		default:
			System.out.println("enter the valid option");
			break;

		}
		

	}

}
