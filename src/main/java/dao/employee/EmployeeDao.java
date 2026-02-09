package dao.employee;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	
	//新增
		void add_employee(Employee employee);
		//修改
		void update_employee(Employee employee);
		//查詢
		//第一個查詢全部
		List<Employee>select_all();
		//第二個查詢byId
		List<Employee>select_by_id(int id);
		//
		public Employee selectByAccount(String account, String password);
		
		//刪除byId
		void delete_by_id(int id);
	
}
