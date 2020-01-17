package com.cafe24.radev.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.radev.service.CarReferService;
import com.cafe24.radev.service.RecService;
import com.cafe24.radev.vo.CarRefer;
import com.cafe24.radev.vo.VoRecRegister;

@Controller
public class MainController {
	
	@Autowired private CarReferService carReferService;
	@Autowired private RecService recService;
	
	@GetMapping("/")
		public String index() {
		return "/index";
	}
	
//	@GetMapping("/main/")
//	public String main() {
//		return "/login/main";
//	}
	@GetMapping("/main/recSearchMain")
	public String recSearchMain() {
		return "/login/recSearchMain";
	}
	
	@GetMapping("/main/carSearchMain")
	public String carSearchMain() {
		return "/login/carSearchMain";
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping("/rec/recSearch")
	public String recSearch(@RequestParam(name = "recNum", required = false)String recNum, HttpSession session) {
		System.out.println("recSearch RecController호출");
		System.out.println(recNum + " <-recNum recSearch RecController.java");
		String bsCode=(String)session.getAttribute("SCODE"); 
		System.out.println(bsCode + " <-bsCode recSearch RecController.java");
		
		VoRecRegister recVo = recService.getRecSearch(bsCode, recNum);
		System.out.println(recVo + " <-recVo recSearch RecController.java");
		
		if(recVo != null && !("").equals(recVo)) {
//			VoRecRegister recVo = null;
//			String recCode;
//			for(int i=0; i<recList.size();i++) {
//				//recVo에 wip번호만 담기
//				recVo = recList.get(i);
//				recCode = recVo.getReceptionCode();
//				recCode = recCode.substring(recCode.lastIndexOf("_")+1);
//				recVo.setReceptionCode(recCode);
//			}
			System.out.println("wip번호 : " + recVo.getReceptionCode());
			System.out.println("배기량 코드 : " + recVo.getCcCode());
			session.setAttribute("RECNUM", recVo.getReceptionCode());
			session.setAttribute("CCCODE", recVo.getCcCode());
		}else if(("").equals(recVo)){
			System.out.println("접수 번호 조회 실패!!!");
		}
		
		return "redirect:/main/recSearchMain";
	}
	
	//@RequestParam(name = "recepNum", required = false)String recepNum,
	//@RequestParam(value = "carCode", required = false)String carCode
	@PostMapping("/car/carSearch")
	public String carRefer(@RequestParam(name = "carNum", required = false)String carNum,
			@RequestParam(name = "carCode", required = false)String carCode, HttpSession session) {
		System.out.println("carRefer MainController 호출");
//		System.out.println(recepNum + " <-recepNum 조회 하려는 접수 번호 정보");
		System.out.println(carNum + " <-carNum 조회 하려는 차량 번호 정보");
		System.out.println(carCode + " <-carCode 조회 하려는 차대 번호 정보");
		CarRefer carRefer;
		String carInfo = null;
		//String re = null;
//		if(recepNum != null && !("").equals(recepNum)) {
//			carInfo = recepNum;
//		} 
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
		
		return "redirect:/main/carSearchMain";
		
	}
	
//	@GetMapping("/main/refer")
//	public String completeRefer() {
//		return "/login/refer";
//	}
	
	@GetMapping("/rec/reset")
	public String resetRecNum(HttpSession session) {
		session.setAttribute("RECNUM", null); 	//접수 번호
		session.setAttribute("CCCODE",null);	//배기량 코드
		return "redirect:/main/recSearchMain";
	}
	
	@GetMapping("/refer/reset")
	public String resetCarRefer(HttpSession session) {
		session.setAttribute("CARCODE", null); 	//차대 번호
		session.setAttribute("CARNUM", null); 	//차량 번호 
		session.setAttribute("CARNAME",null);	//차량 이름
		session.setAttribute("CUSNAME",null);	//고객 이름
		session.setAttribute("CUSPHONE",null);	//고객 번호
		session.setAttribute("CCCODE",null);	//배기량 코드
		return "redirect:/main/carSearchMain";
	}
	
	@GetMapping("/go/portfolio")
	public String portfolio(HttpSession session) {
		session.invalidate();
		return "/index";
	}
	
}
