package service.customer;

import java.util.List;

import dao.customer.CustomerDaoImpl;
import model.Customer;

public class CustomerServiceImpl implements CustomerService{

	public static void main(String[] args) {
		

	}
	//先NEW
	Customer cutomer=new Customer();
	CustomerDaoImpl customer_dao_impl=new CustomerDaoImpl();
	
	//此為給客戶註冊UI頁面使用的方法
	@Override
	public void add_customer(Customer customer) {
		
		customer_dao_impl.create_account(customer);
	}
	
	//此為給customer查詢是否兩者皆符合
	@Override
	public Customer find_customerdata_by_user_account_password(String user_account, String user_password) {
		 List<Customer> registered = customer_dao_impl.select_by_user_account_password(user_account, user_password);
		   
		    if (registered != null && !registered.isEmpty()) {
		        return registered.get(0); 
		    }
		    return null;
	}
	
	//此為給customer查詢是否帳號重複
	@Override
	public boolean find_customerdata_by_user_account(String user_account) {
		List<Customer>registered=customer_dao_impl.select_by_user_account(user_account);
		return registered.isEmpty();
	}

	//此為更新客戶資料
	@Override
	public boolean update_customerdata(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	//此為刪除客戶資料
	@Override
	public boolean delete_customerdata_by_id(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}



	
