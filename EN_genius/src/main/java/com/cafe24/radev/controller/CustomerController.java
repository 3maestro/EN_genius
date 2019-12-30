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
public class CustomerController {
	@Autowired CustomerService customerService;
	
	@GetMapping("/customer/customerList")
	public String getMemberList(Model model) {
		model.addAttribute("title", "고객목록");
		return "/customer/customerList";
	}
	
	@GetMapping(value="/customerSelcet", produces = "application/json")
	public @ResponseBody List<Customer> getMemberList() {
		List<Customer> list = customerService.getCustomerList();
		return list;
	}
	
	@GetMapping("/customer/customerInsert")
	public String getCustomerInsert(Model model) {
		model.addAttribute("title", "고객등록");
		return "/customer/customerInfo";
	}
	
	@PostMapping("/customer/customerInsert")
	public String getCustomerInsert(Model model, Customer customer) {
		System.out.println(customer);
		customerService.getCustomerInsert(customer);
		return "redirect:/customer/customerList";
	}

	@GetMapping("/customer/customerUpdate")
	public String getCustomerUpdate(Model model, @RequestParam(value="customerCode") String customerCode) {
		model.addAttribute("title", "고객수정");
		Customer customer = customerService.getCustomerSelect("bs001_"+customerCode);
		model.addAttribute("customer", customer);
		return "/customer/customerInfo";
	}
	
	@PostMapping("/customerUpdate")
	public String getCustomerUpdate(Customer customer) {
		System.out.println(customer);
		customerService.getCustomerUpdate(customer);
		return "redirect:/customer/customerList";
	}
	
	@GetMapping("/customer/customerX")
	public String getCustomerVisit(Model model) {
		model.addAttribute("title", "미구현");
		System.out.println("Visit");
		return "/customer/customerX";
	}
	
	@PostMapping(value="/customerInsertAjax", produces = "text/plain")
	public @ResponseBody String getCustomerInsertAjax(@RequestParam(value="name") String name, @RequestParam(value="birth") String birth, @RequestParam(value="phone") String phone) {
		String code = customerService.getCustomerInsertAjax(name,birth,phone);
		return code;
	}
	
	@GetMapping("/customer/customerSMS")
	public String getCustomerSMS(Model model) {
		System.out.println("SMS");
		return "/customer/customerSMS";
	}

	@GetMapping("/calendar")
	public String getCalendar(Model model) {
		System.out.println("calendar");
		return "/calendar";
	}
}
