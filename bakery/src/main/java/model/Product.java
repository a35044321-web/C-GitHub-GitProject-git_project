package model;

public class Product {
	private int product_id;
	private String product_no;
	private String product_name;
	private int product_cost;
	
	
	
	public Product() {
		super();
	}



	public Product(String product_no, String product_name, int product_cost) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_cost = product_cost;
	}



	public int getProduct_id() {
		return product_id;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}



	public String getProduct_no() {
		return product_no;
	}



	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public int getProduct_cost() {
		return product_cost;
	}



	public void setProduct_cost(int product_cost) {
		this.product_cost = product_cost;
	}
	
	@Override
    public String toString() {
        // 選單會自動抓取 return 的這個字串來顯示
        return this.product_name; 
    }
	
	
}
