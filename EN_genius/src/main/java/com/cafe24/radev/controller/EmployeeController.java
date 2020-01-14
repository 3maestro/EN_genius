package com.cafe24.radev.controller;

import java.util.List;

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
	@PostMapping("/employee/addEmployee")
	public String addEmployee(Employee employee, HttpSession session) {
		employee.setBsCode((String)session.getAttribute("SCODE"));
		employee.setEiWriter((String)session.getAttribute("SCODE"));
		System.out.println("직원등록 폼에서 받아온 값===>"+ employee.toString());
		System.out.println(employee.getEmployeeGender());
		employeeService.addEmployee(employee);
		return "redirect:/employee/employeeSelect";
	}
	/**
	 * 직원수정
	 * @param employeeCode
	 * @return
	 */
	@PostMapping("/employee/modifyE")			
	public String modifyEmployee(Employee employee, HttpSession session) {
		System.out.println("수정화면에서 받아온 값 ==>" + employee);
		employeeService.modifyEmployee(employee);
		return "redirect:/employee/employeeSelect";
	}
	/**
	 * 직원퇴사
	 * @param employee
	 * @return
	 */
	@PostMapping("/employee/resignationE")
	public String resignationEmployee(Employee employee) {
		System.out.println("퇴사버튼클릭시==>" + employee);
		employeeService.resignationEmployee(employee);
		return "redirect:/employee/employeeSelect";
	}
	/**
	 * 직원조회
	 * @param model
	 * @return
	 */
	@GetMapping("/employee/employeeSelect")
	public String employeeList(Model model, HttpSession session) {
		String bsCode = (String)session.getAttribute("SCODE");
		System.out.println("사업장코드==>"+ bsCode);
		model.addAttribute("employeeList", employeeService.employeeList(bsCode));
		model.addAttribute("dutyList", employeeService.DepartmentDutySelect(bsCode));
		return "/employee/employeeList";
	}
	/**
	 * 직원 마이페이지
	 * @return
	 */
	@GetMapping("/employee/employeeMypage")
	public String employeeMypage(Model model, HttpSession session){
		String employeeCode = (String)session.getAttribute("ECODE");
		employeeService.employeeMypage(employeeCode);
		model.addAttribute("Employee", employeeService.employeeMypage(employeeCode));
		return "/employee/employeeMypage";
	}
	
	/**
	 * 직원 마이페이지
	 * @return
	 */
	@GetMapping("/employee/employeeDetail")
	public String employeeDetail(Model model, HttpSession session){
		String employeeCode = (String)session.getAttribute("ECODE");
		employeeService.employeeMypage(employeeCode);
		model.addAttribute("Employee", employeeService.employeeMypage(employeeCode));
		return "/employee/employeeDetail";
	}
	/**
	 * 직원별 통계
	 * @return
	 */
	@GetMapping("/employee/statistics")
	public String Statistics() {
		return "/employee/employeeStatistics";
	}
}
