package dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;
import util.Tool;

public class EmployeeDaoImpl implements EmployeeDao{

	public static void main(String[] args) {
		//新增new EmployeeDaoImpl().create_account(new Employee("e006","阿貝","0988-777-584"));
		//System.out.println(new EmployeeDaoImpl().select_by_id(4));
		new EmployeeDaoImpl().delete_by_id(5);
	}
	
	Connection connect_database = Tool.connect_with_database();

	@Override
	//此為新增員工資料庫資料
	public void add_employee(Employee employee) {
		// 增加帳號密碼的寫入
        String sql = "insert into employee(employee_no,employee_name,employee_phone_number,employee_account,employee_password) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connect_database.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmployee_no());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setString(3, employee.getEmployee_phone_number());
            preparedStatement.setString(4, employee.getEmployee_account());
            preparedStatement.setString(5, employee.getEmployee_password());
            preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print("連結失敗，語法錯誤");
			e.printStackTrace();
		}
		
	}

	@Override
	public void update_employee(Employee employee) {
		 // 修正：原本你的 SQL 有 4 個問號但只填了 3 個，且欄位名稱 id 應為 employee_id
        String sql = "update employee set employee_no=?, employee_name=?, employee_phone_number=? where employee_id=?";
        try {
            PreparedStatement preparedStatement = connect_database.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmployee_no());
            preparedStatement.setString(2, employee.getEmployee_name());
            preparedStatement.setString(3, employee.getEmployee_phone_number());
            preparedStatement.setInt(4, employee.getEmployee_id()); // 補上 ID 參數
            preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print("連結失敗，語法錯誤");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> select_all() {
		String sql="select * from employee";
		 List<Employee>employee_alldata=new ArrayList<>();
		 try {
			PreparedStatement preparedstatement=connect_database.prepareStatement(sql);
			ResultSet show_database=preparedstatement.executeQuery();
			while(show_database.next()) {
				Employee employee=new Employee();
				employee.setEmployee_id(show_database.getInt("employee_id"));
				employee.setEmployee_no(show_database.getString("employee_no"));
				employee.setEmployee_name(show_database.getString("employee_name"));
				employee.setEmployee_phone_number(show_database.getString("employee_phone_number"));
				employee_alldata.add(employee);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee_alldata;
	}

	@Override
	public List<Employee> select_by_id(int id) {
		String sql="select * from employee where employee_id=?";
		 List<Employee>employee_alldata=new ArrayList<>();
		 try {
			PreparedStatement preparedstatement=connect_database.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			ResultSet show_database=preparedstatement.executeQuery();
			while(show_database.next()) {
				Employee employee=new Employee();
				employee.setEmployee_id(show_database.getInt("employee_id"));
				employee.setEmployee_no(show_database.getString("employee_no"));
				employee.setEmployee_name(show_database.getString("employee_name"));
				employee.setEmployee_phone_number(show_database.getString("employee_phone_number"));
				employee_alldata.add(employee);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee_alldata;
	}

	@Override
	public void delete_by_id(int id) {
		String sql="delete from employee where employee_id=?";
		try {
			PreparedStatement preparedstatement=connect_database.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee selectByAccount(String account, String password) {
		String sql = "SELECT * FROM employee WHERE employee_account = ? AND employee_password = ?";
        try {
            PreparedStatement ps = connect_database.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setEmployee_no(rs.getString("employee_no"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setEmployee_account(rs.getString("employee_account"));
                // 登入成功，回傳物件
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

}
