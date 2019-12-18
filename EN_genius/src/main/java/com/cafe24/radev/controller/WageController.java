package com.cafe24.radev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WageController {

	@GetMapping("/ccStandardWage")
	public String standardWage() {
		return "/wage/ccStandardWage";
	}
	
	@GetMapping("/workManHour")
	public String workManHour() {
		return "/wage/workManHour";
	}
	
	@GetMapping("/workingNow")
	public String workingNow() {
		return "/wage/workingNow";
	}
	
	@GetMapping("/wageEstimate")
	public String wageEstimate() {
		return "/wage/wageEstimate";
	}
	
}
