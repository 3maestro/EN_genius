package com.cafe24.radev.controller;

import java.util.List;

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
	public String workManHour(Model model) {
		System.out.println("workManHour WageController 호출");
		List<WageManHour> list = wageService.getWorkManHour();
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
