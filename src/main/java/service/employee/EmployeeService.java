package service.employee;
import java.util.List;

import model.Employee;

public interface EmployeeService {
	 List<Employee> select_all_employees();
	 List<Employee> select_all();
	 Employee login(String account, String password);
	 void add_employee(Employee employee);
	 
}
