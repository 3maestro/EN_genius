package com.cafe24.radev.cyj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.cyj.service.CustomerService;
import com.cafe24.radev.cyj.vo.Customer;

@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	
	@GetMapping("/customerList")
	public String getMemberList(Model model) {
		List<Customer> list = customerService.getCustomerList();
		
		model.addAttribute("customerList", list);
		
		return "/customer/customerList";
	}
	
	@GetMapping("/customerInsert")
	public String getCustomerInsert(Model model) {
		model.addAttribute("title", "고객등록");
		return "/customer/customerInfo";
	}

	@GetMapping("/customerUpdate")
	public String getCustomerUpdate(Model model, @RequestParam(value="customerCode") String customerCode) {
		model.addAttribute("title", "고객수정");
		String bsCode = "bs001";
		System.out.println(bsCode+"_"+customerCode);
		customerService.getCustomerSelectForOne(customerCode);
		return "/customer/customerInfo";
	}
	
	@PostMapping("/customerInsert")
	public String getCustomerInsert(Model model, Customer customer) {
		System.out.println(customer);
		customerService.getCustomerInsert(customer);
		return "redirect:/customerList";
	}
	
	@GetMapping("/customerVisit")
	public String getCustomerVisit(Model model) {
		System.out.println("Visit");
		return "/customer/customerVisit";
	}
	
	@PostMapping(value="/customerInsertAjax", produces = "application/json")
	public @ResponseBody String getCustomerInsertAjax(@RequestParam(value="name") String name, @RequestParam(value="birth") String birth, @RequestParam(value="phone") String phone) {
		String code = customerService.getCustomerInsertAjax(name,birth,phone);
		return code;
	}
	
	@GetMapping("/customerSMS")
	public String getCustomerSMS(Model model) {
		System.out.println("SMS");
		return "/customer/customerSMS";
	}

}
