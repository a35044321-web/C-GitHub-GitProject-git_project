package service.product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.product.ProductDaoImpl;
import model.Product;
import util.Tool;

public class ProductServiceImpl implements ProductService {

    // 初始化 DAO 供 Service 使用
    private ProductDaoImpl product_dao_impl = new ProductDaoImpl();

    @Override
    public void add_product(Product product) {
    	if (product.getProduct_no() != null && !product.getProduct_no().trim().isEmpty()) {
            product_dao_impl.add_product(product); // 這裡要改呼叫 DAO 的 add 方法
        }
    }

    @Override
    public List<Product> select_all() {
        // 直接向 DAO 索取所有資料並回傳給 UI
        return product_dao_impl.select_all();
    }

    @Override
    public List<Product> select_by_name(String name) {
        // 這裡可以加入邏輯，例如：如果 name 為空，直接回傳空清單
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return product_dao_impl.select_by_name(name);
    }

    @Override
    public String calculate_total_price(int price, String amount) {
    	try {
            // 在 Service 層處理字串轉數字的邏輯是非常符合 MVC 規範的
            // 因為這保護了 Model 不受非法輸入影響
            if (amount == null || amount.trim().isEmpty()) {
                return "0";
            }
            int qty = Integer.parseInt(amount.trim());
            if (qty < 0) return "0"; 
            
            return String.valueOf(price * qty);
        } catch (NumberFormatException e) {
            // 回傳錯誤訊息給 UI (View) 顯示
            return "請輸入正確數字!";
        }
    }

	@Override
	public void delete_product(int id) {
		// TODO Auto-generated method stub
		 product_dao_impl.delete_by_id(id);
	}

	@Override
	public void update_product(Product product) {
		if (product.getProduct_no() != null && !product.getProduct_no().trim().isEmpty()) {
	        product_dao_impl.update_product(product); // 這裡呼叫 DAO 的 update 方法
	    }
		
	}
}
