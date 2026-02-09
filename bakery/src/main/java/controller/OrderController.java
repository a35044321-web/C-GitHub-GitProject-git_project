package controller;
import model.Orders;
import service.orders.OrderService;
import service.orders.OrderServiceImpl;

public class OrderController {
	// 針對介面編程 (Programming to Interface)
    private OrderService orderService = new OrderServiceImpl();

    public void processOrder(Orders order) {
        orderService.addOrder(order);
    }
    
    public void removeOrder(int id) {
        orderService.delete_by_id(id);
    }
}
