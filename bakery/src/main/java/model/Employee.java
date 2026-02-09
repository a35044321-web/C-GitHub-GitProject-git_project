package model;

public class Employee {
	private int employee_id;
	private String employee_no;
	private String employee_name;
	private String employee_phone_number;
	private String employee_account;
	private String employee_password;
	
	
	
	public Employee() {
		super();
	}



	public Employee( String employee_no, String employee_name, String employee_phone_number) {
		super();
		this.employee_no = employee_no;
		this.employee_name = employee_name;
		this.employee_phone_number = employee_phone_number;
	}



	public int getEmployee_id() {
		return employee_id;
	}



	public String getEmployee_account() {
		return employee_account;
	}



	public void setEmployee_account(String employee_account) {
		this.employee_account = employee_account;
	}



	public String getEmployee_password() {
		return employee_password;
	}



	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}



	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}



	public String getEmployee_no() {
		return employee_no;
	}



	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}



	public String getEmployee_name() {
		return employee_name;
	}



	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}



	public String getEmployee_phone_number() {
		return employee_phone_number;
	}



	public void setEmployee_phone_number(String employee_phone_number) {
		this.employee_phone_number = employee_phone_number;
	}
	
	@Override
	public String toString() {
	    // 下拉選單會自動抓取 return 的這個字串來顯示
	    // 確保你的變數名稱是 employee_name
	    return this.employee_name != null ? this.employee_name : "未命名員工"; 
	}
	
	
	
}
