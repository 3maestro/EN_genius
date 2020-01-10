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
	
	public 	Employee employeeMypage(String employeeCode){
		System.out.println(employeeMapper.employeeMypage(employeeCode));
		return employeeMapper.employeeMypage(employeeCode);
	}
	public List<String> DepartmentDutySelect(String bsCode){
		return employeeMapper.DepartmentDutySelect(bsCode);
	}
	
	public void modifyEmployee(Employee employee) {
		employee.setEmployeeAddr(employee.getEmployeeAddr() + employee.getAddrDetail());
		employeeMapper.modifyEmployee(employee);
	}
	
	public void resignationEmployee(Employee employee) {
		employeeMapper.resignationEmployee(employee);
	}
	
	public void addEmployee(Employee employee) {
		employee.setEmployeeAddr(employee.getEmployeeAddr() + employee.getAddrDetail());
		employeeMapper.addEmployee(employee);
	}
}
