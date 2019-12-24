package com.cafe24.radev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.service.CarReferService;

@Controller
public class MainController {

	@Autowired private CarReferService carReferService;
	
	@GetMapping("/main/main")
	public String index() {
		return "/login/main";
	}
	
	@PostMapping("/main/carRefer")
	public @ResponseBody void carRefer(
			@RequestParam(value = "car", required = false)String carInfo) {
		System.out.println("carRefer MainController 호출");
		System.out.println(carInfo + " <-carInfo 조회 하려는 차량 정보");
		
		carReferService.getCarRefer(carInfo);
		
		//return null;
		
	}
	
}
