package com.cafe24.radev.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.radev.service.WageService;
import com.cafe24.radev.vo.WageManHour;

@Controller
public class WageController {

	@Autowired private WageService wageService;
	
	@GetMapping("/work/ccStandardWage")
	public String standardWage() {
		return "/wage/ccStandardWage";
	}
	
	@GetMapping("/work/workManHour")
	public String workManHour(Model model, HttpSession session) {
		System.out.println("workManHour WageController 호출");
		String ccCode = (String)session.getAttribute("CCCODE");
		System.out.println(ccCode + " <-ccCode 차량 조회 성공시 세션에 등록된 배기량 기준 코드");
		
		List<WageManHour> list = wageService.getWorkManHour(ccCode);
		//System.out.println(list + " <-list workManHour WageController.java");
		model.addAttribute("wageManHour",list);
		return "/wage/workManHour";
	}
	
	@GetMapping("/work/workingNow")
	public String workingNow() {
		return "/wage/workingNow";
	}
	
	@GetMapping("/work/wageEstimate")
	public String wageEstimate() {
		return "/wage/wageEstimate";
	}
	
}
