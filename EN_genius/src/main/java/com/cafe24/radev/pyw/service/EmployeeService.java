package com.cafe24.radev.pyw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.pyw.mapper.EmployeeMapper;
import com.cafe24.radev.pyw.vo.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> employeeList(String bsCode){
		System.out.println(employeeMapper.employeeList(bsCode));
		return employeeMapper.employeeList(bsCode);
	}
}
