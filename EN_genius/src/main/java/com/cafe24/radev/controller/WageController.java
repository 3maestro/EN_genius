package com.cafe24.radev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WageController {

	@GetMapping("/work/ccStandardWage")
	public String standardWage() {
		return "/wage/ccStandardWage";
	}
	
	@GetMapping("/work/workManHour")
	public String workManHour() {
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
