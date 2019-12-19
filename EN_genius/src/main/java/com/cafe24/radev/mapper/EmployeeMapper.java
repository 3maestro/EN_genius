package com.cafe24.radev.mapper;
import java.util.List;

/**
 * 	직원 mapper
 * @author 박연우
 *
 */
import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.DepartmentDuty;
import com.cafe24.radev.vo.Employee;
import com.cafe24.radev.vo.EmployeeDepartment;

@Mapper
public interface EmployeeMapper {

	int addEmployee();
	
	List<Employee> employeeList(String bsCode);
	
	List<String> DepartmentDutySelect(String bsCode);
	
	Employee employeeLogin(Employee employee);
	
}
