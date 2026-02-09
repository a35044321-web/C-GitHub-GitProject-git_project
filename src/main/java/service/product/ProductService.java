package service.product;

import java.util.List;

import model.Product;

public interface ProductService {
	
	public void add_product(Product product);
	
	public List<Product> select_all();
	
	public List<Product> select_by_name(String name);
	
	public String calculate_total_price(int price,String amount);
	
	public void delete_product(int id);
	
	public void update_product(Product product);
}
