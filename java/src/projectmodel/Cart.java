package projectmodel;

public class Cart {
	private int orderid;
	private int productid;
	private int quantity;
	private int price;
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart(int orderid, int productid, int quantity) {
		super();
		this.orderid = orderid;
		this.productid = productid;
		this.quantity = quantity;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

}
