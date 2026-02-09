package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tool {

	public static void main(String[] args) {
		System.out.println(Tool.connect_with_database());
	}
	//這是連結資料庫方法
	public static Connection connect_with_database() {
		String sql="jdbc:mysql://localhost:3306/bakery";
		String user="root";
		String password="1234";
		Connection Connect_with_database=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connect_with_database=DriverManager.getConnection(sql,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Connect_with_database;
		
	}
	
	
}
