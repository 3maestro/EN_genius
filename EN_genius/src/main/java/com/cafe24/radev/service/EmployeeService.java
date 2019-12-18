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
	
	public List<Employee> employeeList(){
		System.out.println(employeeMapper.employeeList());
		return employeeMapper.employeeList();
	}
}
