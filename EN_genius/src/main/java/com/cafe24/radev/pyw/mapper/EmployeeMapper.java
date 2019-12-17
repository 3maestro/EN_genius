package com.cafe24.radev.pyw.mapper;
import java.util.List;

/**
 * 	직원 mapper
 * @author 박연우
 *
 */
import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.pyw.vo.Employee;

@Mapper
public interface EmployeeMapper {

	int addEmployee();
	
	List<Employee> employeeList();
	
	Employee employeeLogin(Employee employee);
}
