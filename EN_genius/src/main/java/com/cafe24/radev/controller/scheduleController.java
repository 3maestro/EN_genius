package com.cafe24.radev.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.service.CustomerService;
import com.cafe24.radev.vo.Customer;

@Controller
public class scheduleController {
	@Autowired CustomerService customerService;
	
	@GetMapping("/schedule")
	public String getMemberList(Model model) {
		model.addAttribute("title", "일정");
		return "/schedule/schedule";
	}
}
