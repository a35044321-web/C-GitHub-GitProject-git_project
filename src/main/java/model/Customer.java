package model;

public class Customer {

	public static void main(String[] args) {
		

	}
	//資料庫bakery裡的customer表
	//field
	private int customer_id;
	private String customer_no;
	private String customer_name;
	private String customer_phone_number;
	private String customer_adress;
	private String user_account;
	private String user_password;
	//Constructor
	//此建構式用來繼承
	public Customer() {
		super();
	}
	
	//此建構式用於註冊，需輸入除了privatekey以外的所有引數
	public Customer(String customer_no, String customer_name, String customer_phone_number, String customer_adress,
			String user_account, String user_password) {
		super();
		this.customer_no = customer_no;
		this.customer_name = customer_name;
		this.customer_phone_number = customer_phone_number;
		this.customer_adress = customer_adress;
		this.user_account = user_account;
		this.user_password = user_password;
	}
	
	//method

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_phone_number() {
		return customer_phone_number;
	}

	public void setCustomer_phone_number(String customer_phone_number) {
		this.customer_phone_number = customer_phone_number;
	}

	public String getCustomer_adress() {
		return customer_adress;
	}

	public void setCustomer_adress(String customer_adress) {
		this.customer_adress = customer_adress;
	}

	public String getUser_account() {
		return user_account;
	}

	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	
	
	
	
}
