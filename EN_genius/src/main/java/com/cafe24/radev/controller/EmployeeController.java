package com.cafe24.radev.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.radev.service.EmployeeService;
import com.cafe24.radev.vo.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 직원등록
	 * @return
	 */
	@PostMapping("/addEmployee")
	public String addEmployee(Employee employee, HttpSession session) {
		String bsCode = (String)session.getAttribute("SCODE");
		String bossName = (String)session.getAttribute("SNAME");
		employee.setBsCode(bsCode);
		employee.setBossName(bossName);
		System.out.println("직원등록 폼에서 받아온 값===>"+ employee.toString());
		int r = employeeService.addEmployee(employee);
		System.out.println("직원 등록 결과 값==>"+ r);
		return "redirect:/employeeSelect";
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
	public String employeeList(Model model, HttpSession session) {
		String bsCode = (String)session.getAttribute("SCODE");
		System.out.println("사업장코드==>"+ bsCode);
		model.addAttribute("employeeList", employeeService.employeeList(bsCode));
		model.addAttribute("dutyList", employeeService.DepartmentDutySelect(bsCode));
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
