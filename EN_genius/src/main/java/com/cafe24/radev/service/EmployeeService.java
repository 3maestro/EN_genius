package com.cafe24.radev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.EmployeeMapper;
import com.cafe24.radev.vo.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> employeeList(String bsCode){
		System.out.println(employeeMapper.employeeList(bsCode));
		return employeeMapper.employeeList(bsCode);
	}
	
	public List<String> DepartmentDutySelect(String bsCode){
		return employeeMapper.DepartmentDutySelect(bsCode);
	}
	
	public int addEmployee(Employee employee) {
		employee.setEmployeeAddr(employee.getEmployeeAddr() + employee.getAddrDetail());
		return employeeMapper.addEmployee(employee);
	}
}
