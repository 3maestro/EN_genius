package com.cafe24.radev.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.radev.service.CarReferService;
import com.cafe24.radev.vo.CarRefer;

@Controller
public class MainController {
	
	@Autowired private CarReferService carReferService;
	
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
	
	@GetMapping("/main/main")
	public String main() {
		return "/login/main";
	}
	 
	//@RequestParam(value = "carCode", required = false)String carCode
	@PostMapping("/main/carRefer")
	public String carRefer(@RequestParam(name = "carNum", required = false)String carNum,
			@RequestParam(name = "carCode", required = false)String carCode, HttpSession session) {
		System.out.println("carRefer MainController 호출");
		System.out.println(carNum + " <-carNum 조회 하려는 차량 번호 정보");
		System.out.println(carCode + " <-carCode 조회 하려는 차대 번호 정보");
		CarRefer carRefer;
		String carInfo = null;
		//String re = null;
		if(carNum != null && !("").equals(carNum)) {
			carInfo = carNum;
		}else if(carCode != null && !("").equals(carCode)) {
			carInfo = carCode;
		}else {
			System.out.println("차량 정보 조회 실패!!!");
		}
		
		if(carInfo != null) {
			carRefer = carReferService.getCarRefer(carInfo);
			if(carRefer == null) {
				System.out.println("차량 정보 조회 실패!!!");
			}else {
				session.setAttribute("CARCODE", carRefer.getCusCarInfoCode()); 	//차대 번호
				session.setAttribute("CARNUM", carRefer.getCustomerCarNum()); 	//차량 번호 
				session.setAttribute("CARNAME", carRefer.getCarModelDetail());	//차량 이름
				session.setAttribute("CUSNAME", carRefer.getCustomerName());	//고객 이름
				session.setAttribute("CUSPHONE", carRefer.getCustomerPhone());	//고객 번호
				session.setAttribute("CCCODE", carRefer.getCcWageCode());		//배기량 코드
			}
		}
		String a = (String)session.getAttribute("CARCODE");
		System.out.println(a + " <-aaa");
//			System.out.println("차량 정보 조회 실패!!!");
//			carRefer = null;
//		}else {
//			carRefer = carReferService.getCarRefer(carInfo);
//			session.setAttribute("CARCODE", carRefer.getCusCarInfoCode()); 	//차대 번호
//			session.setAttribute("CARNUM", carRefer.getCustomerCarNum()); 	//차량 번호 
//			session.setAttribute("CARNAME", carRefer.getCarModelDetail());	//차량 이름
//			session.setAttribute("CUSNAME", carRefer.getCustomerName());	//고객 이름
//			session.setAttribute("CUSPHONE", carRefer.getCustomerPhone());	//고객 번호
//			session.setAttribute("CCCODE", carRefer.getCcWageCode());		//배기량 코드 
//		}
		//System.out.println(carCode + " <-carCode 조회 하려는 차대 번호");
//		CarRefer carRefer = null;
//		if(carNum != null) {
//		}else if(carCode != null) {
//			carRefer = carReferService.getCarRefer(carCode);
//		}else {
//			System.out.println("차량 정보 조회 실패!!!");
//		}
		
		return "/login/main";
		
	}
	
//	@GetMapping("/main/refer")
//	public String completeRefer() {
//		return "/login/refer";
//	}
	
	@GetMapping("/refer/reset")
	public String resetCarRefer(HttpSession session) {
		session.setAttribute("CARCODE", null); 	//차대 번호
		session.setAttribute("CARNUM", null); 	//차량 번호 
		session.setAttribute("CARNAME",null);	//차량 이름
		session.setAttribute("CUSNAME",null);	//고객 이름
		session.setAttribute("CUSPHONE",null);	//고객 번호
		session.setAttribute("CCCODE",null);
		return "redirect:/main/main";
	}
	
}
