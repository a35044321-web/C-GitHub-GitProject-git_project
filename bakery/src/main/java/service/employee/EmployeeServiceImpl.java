package service.employee;

import java.util.List;
import java.util.ArrayList;

import dao.employee.EmployeeDao;      // 必須匯入 DAO 介面
import dao.employee.EmployeeDaoImpl;  // 匯入 DAO 實作類
import model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
    
    // 修正：指向 DAO 實作類
    private EmployeeDao employee_dao = new EmployeeDaoImpl();

    @Override
    public Employee login(String account, String password) {
        // 1. 業務邏輯防呆：若帳號或密碼沒填，直接回傳 null，不浪費資料庫資源
        if (account == null || account.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            return null;
        }

        // 2. 呼叫 DAO 層的 selectByAccount 進行資料庫比對
        // 這會執行你之前寫好的 SELECT * FROM employee WHERE ...
        Employee emp = employee_dao.selectByAccount(account, password);

        // 3. 回傳結果 (若找不到則 emp 為 null)
        return emp;
    }

    @Override
    public List<Employee> select_all_employees() {
        // 呼叫 DAO 獲取所有員工清單 (供下拉選單使用)
        return employee_dao.select_all();
    }

    @Override
    public void add_employee(Employee employee) {
        // 呼叫 DAO 新增員工
        employee_dao.add_employee(employee);
    }

    @Override
    public List<Employee> select_all() {
        // 通常這個方法與 select_all_employees 重複，可以視需求移除或導向同一個方法
        return employee_dao.select_all();
    }
}
