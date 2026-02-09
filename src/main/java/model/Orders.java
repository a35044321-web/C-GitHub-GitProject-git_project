package model;

public class Orders {
	private int orders_id;
	private String orders_no;
	private String customer_no;
	private String product_no;
	private String employee_no;
	private int amount;
	private int total_price;
	
	
	
	public Orders() {
		super();
	}
	public Orders(int orders_id, String orders_no, String customer_no, String product_no, String employee_no, int amount, int total_price) {
	    this.orders_id = orders_id;
	    this.orders_no = orders_no;
	    this.customer_no = customer_no;
	    this.product_no = product_no;
	    this.employee_no = employee_no;
	    this.amount = amount;
	    this.total_price = total_price;
	}


	public Orders(String orders_no, String customer_no, String product_no, String employee_no, int amount,
			int total_price) {
		super();
		this.orders_no = orders_no;
		this.customer_no = customer_no;
		this.product_no = product_no;
		this.employee_no = employee_no;
		this.amount = amount;
		this.total_price = total_price;
	}



	public int getOrders_id() {
		return orders_id;
	}



	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}



	public String getOrders_no() {
		return orders_no;
	}



	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
	}



	public String getCustomer_no() {
		return customer_no;
	}



	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}



	public String getProduct_no() {
		return product_no;
	}



	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}



	public String getEmployee_no() {
		return employee_no;
	}



	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public int getTotal_price() {
		return total_price;
	}



	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	
	
	
}
