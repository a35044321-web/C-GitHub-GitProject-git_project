package dao.customer;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	
	//新增
	void create_account(Customer customer);
	//修改
	void update_account(Customer customer);
	//查詢
	//第一個查詢by_account&password
	List<Customer>select_by_user_account_password(String user_account,String user_password);
	//第二個查詢by_name
	List<Customer>select_by_user_account(String user_account);
	
	
	
	//刪除byId
	void delete_by_id(int id);
	
	
}
