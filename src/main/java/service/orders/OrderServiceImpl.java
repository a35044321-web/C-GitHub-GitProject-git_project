package service.orders;

import dao.orders.OrderDaoImpl;
import model.Orders;
import dao.orders.OrderDao;
public class OrderServiceImpl implements OrderService{
	// 取得 DAO 實作物件
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void addOrder(String productNo, String customerNo, String employeeNo, int amount, int totalPrice) {
        
        // 1. 業務邏輯防呆 (Business Logic)
        if (amount <= 0) {
            System.out.println("[Service 警告] 數量不可小於或等於 0");
            return;
        }
        
        if (totalPrice < 0) {
            System.out.println("[Service 警告] 總價不可為負數");
            return;
        }

        // 2. 呼叫 DAO 執行 SQL 寫入
        orderDao.addOrder(productNo, customerNo, employeeNo, amount, totalPrice);
        System.out.println("[Service 訊息] 訂單驗證通過，已交由 DAO 處理");
    }

    @Override
    public void delete_by_id(int id) {
        if (id > 0) {
            orderDao.delete_by_id(id);
        } else {
            System.out.println("[Service 警告] 無效的訂單編號");
        }
    }

	@Override
	public void addOrder(Orders order) {
		 // 1. 業務邏輯防呆 (MVC 的核心：在進入 DAO 前檢查資料)
        if (order.getAmount() <= 0) {
            System.out.println("訂單數量不正確");
            return;
        }
        
        // 2. 呼叫 DAO 存入資料庫
        // 這裡會對應到 OrderDaoImpl 裡面的 addOrder(Orders order)
        orderDao.addOrder(order);
		
	}
}
