package dao.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Orders;
import util.Tool;

public class OrderDaoImpl implements OrderDao {
	
	Connection conn = Tool.connect_with_database();
	@Override
	public void addOrder(String productNo, String customerNo, String employeeNo, int amount, int totalPrice) {
		String sql = "INSERT INTO orders (product_no, customer_no, employee_no, amount, total_price) VALUES (?,?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			 ps.setString(1, productNo);
	            ps.setString(2, customerNo);
	            ps.setString(3, employeeNo);
	            ps.setInt(4, amount);
	            ps.setInt(5, totalPrice);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		
	}

	@Override
	public void delete_by_id(int id) {
		String sql = "DELETE FROM orders WHERE orders_id = ?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
	}

	@Override
	public void addOrder(Orders order) {
		 String sql = "INSERT INTO orders (orders_id, orders_no, product_no, customer_no, employee_no, amount, total_price) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    
	    // 修正：直接在 try 中獲取連線，避免 conn 為 null 的問題
	    try (Connection methodConn = Tool.connect_with_database();
	         PreparedStatement ps = methodConn.prepareStatement(sql)) {
	        
	        // 防呆：確認連線是否成功
	        if (methodConn == null) {
	            System.err.println("錯誤：無法連線至資料庫，請檢查 Tool 類別與資料庫狀態。");
	            return;
	        }

	        ps.setInt(1, order.getOrders_id());
	        ps.setString(2, order.getOrders_no());
	        ps.setString(3, order.getProduct_no());
	        ps.setString(4, order.getCustomer_no());
	        ps.setString(5, order.getEmployee_no());
	        ps.setInt(6, order.getAmount());
	        ps.setInt(7, order.getTotal_price());
	        
	        ps.executeUpdate();
	        System.out.println("訂單 " + order.getOrders_no() + " 已成功存入資料庫");
	    } catch (SQLException e) {
	        // 如果手打的 ID 重複，這裡會抓到 Duplicate entry 錯誤
	        e.printStackTrace(); 
	    }
		}
		
	}


