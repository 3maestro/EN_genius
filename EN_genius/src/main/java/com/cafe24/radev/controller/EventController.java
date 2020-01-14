package com.cafe24.radev.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
public class EventController {
	@Autowired CustomerService customerService;
	
	@GetMapping("/event/eventX")
	public String getCustomerList(Model model) {
		model.addAttribute("title", "이벤트");
		return "/event/eventX";
	}
}
