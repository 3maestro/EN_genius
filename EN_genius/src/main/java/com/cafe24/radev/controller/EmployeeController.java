package com.cafe24.radev.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		employee.setBsCode((String)session.getAttribute("SCODE"));
		employee.setEiWriter((String)session.getAttribute("SCODE"));
		System.out.println("직원등록 폼에서 받아온 값===>"+ employee.toString());
		System.out.println(employee + " <-employee");
		employeeService.addEmployee(employee);
		return "redirect:/employeeSelect";
	}
	/**
	 * 직원수정
	 * @param employeeCode
	 * @return
	 */
	@PostMapping("/modifyE")			
	public String modifyEmployee(Employee employee, HttpSession session) {
		System.out.println("수정화면에서 받아온 값 ==>" + employee);
		employeeService.modifyEmployee(employee);
		return "redirect:/employeeSelect";
	}
	/**
	 * 직원퇴사
	 * @param employee
	 * @return
	 */
	@PostMapping("/resignationE")
	public String resignationEmployee(Employee employee) {
		System.out.println("퇴사버튼클릭시==>" + employee);
		employeeService.resignationEmployee(employee);
		return "redirect:/employeeSelect";
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
		System.out.println("========>"+model.addAttribute("employeeList", employeeService.employeeList(bsCode)));
		System.out.println("========"+model.addAttribute("dutyList", employeeService.DepartmentDutySelect(bsCode)));
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
