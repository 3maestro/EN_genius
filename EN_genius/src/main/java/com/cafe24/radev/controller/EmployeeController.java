package com.cafe24.radev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.radev.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 직원등록
	 * @return
	 */
	@GetMapping("/employeeInsert")
	public String addEmployee() {
		return "/employee/employeeInsert";
	}
	/**
	 * 직원수정
	 * @param employeeCode
	 * @return
	 */
	@GetMapping("/updateE")			
	public String updateEmployee(String employeeCode) {
		System.out.println(employeeCode);
		//employeeService.
		return "/index";
	}
	/**
	 * 직원조회
	 * @param model
	 * @return
	 */
	@GetMapping("/employeeSelect")
	public String employeeList(Model model) {
		model.addAttribute("employeeList", employeeService.employeeList());
		return "/employee/employeeList";
	}
	/**
	 * 직원작업현황
	 * @return
	 */
	@GetMapping("/workCurrentState")
	public String WorkCurrentState() {
		return "/employee/employeeWorkCurrentState";
	}
	/**
	 * 직원별 통계
	 * @return
	 */
	@GetMapping("/statistics")
	public String Statistics() {
		return "/employee/employeeStatistics";
	}
}
