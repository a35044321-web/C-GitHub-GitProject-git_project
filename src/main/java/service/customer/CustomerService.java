package service.customer;
import java.util.List;

import model.Customer;

public interface CustomerService {
	//新增
	public void add_customer(Customer customer);
	//查詢
	Customer find_customerdata_by_user_account_password(String user_account,String user_password);
	boolean find_customerdata_by_user_account(String user_account);
	//更新
	boolean update_customerdata(Customer customer);
	//刪除
	boolean delete_customerdata_by_id(int id);
}
