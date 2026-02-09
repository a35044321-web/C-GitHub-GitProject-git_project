package dao.orders;

import model.Orders;

public interface OrderDao {
	  // 新增訂單
    void addOrder(String productNo, String customerNo, String employeeNo, int amount, int totalPrice);
    
    // 刪除訂單 (保留你之前要求的資料庫刪除方法)
    void delete_by_id(int id);
    
    public void addOrder(Orders order);
    // 你可以根據需求預留其他方法
    // List<Order> select_all();
}
