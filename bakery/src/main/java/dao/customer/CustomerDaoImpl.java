package dao.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import util.Tool;

public class CustomerDaoImpl implements CustomerDao{

	public static void main(String[] args) {
		// 此為新增 new CustomerDaoImpl().create_account(new Customer("c006","張明明","0945-499-888","士林","eqw998","q999"));
		// 此為抓全部的資料 System.out.println(new CustomerDaoImpl().select_all());
		// 此為抓根據ID的部分資料 System.out.println(new CustomerDaoImpl().select_by_id(5));
		//new CustomerDaoImpl().delete_by_id(5);

	}
	
	Connection connect_database=new Tool().connect_with_database();
	
	//此為新增customer資料庫
	@Override
	public void create_account(Customer customer) {
		//此為新增資料庫的sql語法
		String sql="insert into customer(customer_no,customer_name,customer_phone_number,"
				+ "customer_adress,user_account,user_password) values(?,?,?,?,?,?)";
		try {
			//此為連接資料庫資料透過SQL語法，將資料丟入變數做調整
			PreparedStatement preparedStatement=connect_database.prepareStatement(sql);
			preparedStatement.setString(1,customer.getCustomer_no());
			preparedStatement.setString(2,customer.getCustomer_name());
			preparedStatement.setString(3,customer.getCustomer_phone_number());
			preparedStatement.setString(4,customer.getCustomer_adress());
			preparedStatement.setString(5,customer.getUser_account());
			preparedStatement.setString(6,customer.getUser_password());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.print("連結失敗，語法錯誤");
			e.printStackTrace();
		}
			
	}
	
	//此為撈出資料庫欄位account與password是否有跟引數一樣的方法
	@Override
	public List<Customer> select_by_user_account_password(String user_account, String user_password) {
		String sql="select * from customer where user_account=? and user_password=?";
		 List<Customer>customer_alldata=new ArrayList<>();
		 try {
			PreparedStatement preparedstatement=connect_database.prepareStatement(sql);
			preparedstatement.setString(1,user_account);
			preparedstatement.setString(2,user_password);
			ResultSet show_database=preparedstatement.executeQuery();
			while(show_database.next()) {
				Customer customer=new Customer();
				customer.setCustomer_id(show_database.getInt("customer_id"));
				customer.setCustomer_no(show_database.getNString("customer_no"));
				customer.setCustomer_name(show_database.getString("customer_name"));
				customer.setCustomer_phone_number(show_database.getString("customer_phone_number"));
				customer.setCustomer_adress(show_database.getString("customer_adress"));
				customer.setUser_account(show_database.getString("user_account"));
				customer.setUser_password(show_database.getString("user_password"));
				customer_alldata.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer_alldata;
	}
	
	//此為撈出資料庫欄位account是否有跟引數一樣的方法
	@Override
	public List<Customer> select_by_user_account(String user_account) {
		String sql="select * from customer where user_account=?";
		 List<Customer>customer_alldata=new ArrayList<>();
		 try {
			PreparedStatement preparedstatement = connect_database.prepareStatement(sql);
			//透過SQL語法，設定撈出的資料庫欄位ID名稱並指派根據輸入的引數，來顯示資料。
			preparedstatement.setString(1,user_account);
			ResultSet show_database=preparedstatement.executeQuery();
			while(show_database.next()) {
				Customer customer=new Customer();
				customer.setCustomer_id(show_database.getInt("customer_id"));
				customer.setCustomer_no(show_database.getNString("customer_no"));
				customer.setCustomer_name(show_database.getString("customer_name"));
				customer.setCustomer_phone_number(show_database.getString("customer_phone_number"));
				customer.setCustomer_adress(show_database.getString("customer_adress"));
				customer.setUser_account(show_database.getString("user_account"));
				customer.setUser_password(show_database.getString("user_password"));
				customer_alldata.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		
		return customer_alldata;
	}
	
	
	//此為customer資料庫修改
	@Override
	public void update_account(Customer customer) {
		String sql="update customer set customer_no=?,customer_name=?,cusotmer_phone_number=?,"
				  + "customer_adress=?,user_account=?,user_password=? where id=?";
		try {
			PreparedStatement preparedStatement=connect_database.prepareStatement(sql);
			preparedStatement.setString(1,customer.getCustomer_no());
			preparedStatement.setString(2,customer.getCustomer_name());
			preparedStatement.setString(3,customer.getCustomer_phone_number());
			preparedStatement.setString(4,customer.getCustomer_adress());
			preparedStatement.setString(5,customer.getUser_account());
			preparedStatement.setString(6,customer.getUser_password());
			preparedStatement.setInt(7,customer.getCustomer_id());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print("連結失敗，語法錯誤");
			e.printStackTrace();
		}
		
	}
	//此為刪除的功能
	@Override
	public void delete_by_id(int id) {
		String sql="delete from customer where customer_id=?";
		try {
			PreparedStatement preparedstatement = connect_database.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

}




