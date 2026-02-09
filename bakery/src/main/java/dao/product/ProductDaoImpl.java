package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import util.Tool;

public class ProductDaoImpl implements ProductDao{

	public static void main(String[] args) {
		//new ProductDaoImpl().add_product(new Product("p013","甜甜圈",12));
		
		System.out.println(new ProductDaoImpl().select_by_name("蔥捲"));
	}
	//Tool所提供的連接資料方法
	Connection connect_database=new Tool().connect_with_database();
	
	@Override
	//此為新增的方法
	public void add_product(Product product) {
		String sql = "INSERT INTO product(product_no, product_name, product_cost) VALUES(?,?,?)";
	    try (PreparedStatement ps = connect_database.prepareStatement(sql)) {
	        ps.setString(1, product.getProduct_no());
	        ps.setString(2, product.getProduct_name());
	        ps.setInt(3, product.getProduct_cost());
	        ps.executeUpdate();
	    } catch (SQLException e) { e.printStackTrace(); }
		
	}

	@Override
	//此為更新的方法
	public void update_product(Product product) {
		String sql = "UPDATE product SET product_name=?, product_cost=? WHERE product_no=?";
	    try (PreparedStatement ps = connect_database.prepareStatement(sql)) {
	        ps.setString(1, product.getProduct_name());
	        ps.setInt(2, product.getProduct_cost());
	        ps.setString(3, product.getProduct_no()); // 這是 WHERE 的條件
	        ps.executeUpdate();
	    } catch (SQLException e) { e.printStackTrace(); }
	}

	@Override
	public List<Product> select_all() {
		String sql="select * from product";
		List<Product>list=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=connect_database.prepareStatement(sql);
			ResultSet show_all_database=preparedStatement.executeQuery();
			while(show_all_database.next()) {
				Product product_for_data=new Product();
				product_for_data.setProduct_id(show_all_database.getInt("product_id"));
				product_for_data.setProduct_no(show_all_database.getString("product_no"));
				product_for_data.setProduct_name(show_all_database.getString("product_name"));
				product_for_data.setProduct_cost(show_all_database.getInt("product_cost"));
				list.add(product_for_data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void delete_by_id(int id) {
		String sql = "DELETE FROM product WHERE product_id = ?";
	    try {
	        PreparedStatement ps = connect_database.prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public List<Product> select_by_name(String name) {
		String sql="select * from product where product_name=?";
		List<Product>list=new ArrayList<>();
		try {
			PreparedStatement preparedStatement=connect_database.prepareStatement(sql);
			preparedStatement.setString(1,name);
			ResultSet show_all_database=preparedStatement.executeQuery();
			while(show_all_database.next()) {
				Product product_for_data=new Product();
				product_for_data.setProduct_id(show_all_database.getInt("product_id"));
				product_for_data.setProduct_no(show_all_database.getString("product_name"));
				product_for_data.setProduct_name(show_all_database.getString("product_name"));
				product_for_data.setProduct_cost(show_all_database.getInt("product_cost"));
				list.add(product_for_data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
