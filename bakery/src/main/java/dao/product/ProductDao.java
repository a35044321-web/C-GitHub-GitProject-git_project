package dao.product;

import java.util.List;

import model.Product;

public interface ProductDao {
	    //新增產品的方法
		void add_product(Product product);
		//更新產品的方法
		void update_product(Product product);
		//查詢
		//第一個查詢全部
		List<Product>select_all();
		//第二個查詢by_name
		List<Product>select_by_name(String name);
		//刪除byId
		void delete_by_id(int id);
}
