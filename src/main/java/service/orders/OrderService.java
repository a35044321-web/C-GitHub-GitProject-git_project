package service.orders;

import model.Orders;

public interface OrderService {
	  void addOrder(String productNo, String customerNo, String employeeNo, int amount, int totalPrice);
	    
	    // 刪除訂單：執行資料庫刪除
	    void delete_by_id(int id);
	    
	    void addOrder(Orders order);
	    
	    // 可以在這裡增加更多業務功能，例如：計算折扣、檢查庫存
}
