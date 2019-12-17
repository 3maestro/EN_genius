package com.cafe24.radev.jcs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.jcs.service.CarService;
import com.cafe24.radev.jcs.vo.VoCarDetail;
import com.cafe24.radev.jcs.vo.VoCarRegister;

@Controller
public class CarController {
	//등록버튼 누르기 전 Datail쪽 마무리 하기
	
	// get방식은 값을 지정해서 보내줄때 사용
	// post방식은 지정한 값을 한방에 보내줄때 사용

	@Autowired
	private CarService carService;
	
	


	/**
	 * 등록버튼 누르기 전 Datail쪽 마무리 해야됨
	 * 등록버튼 누르기 전 Color쪽 마무리 해야됨
	 * @param voDetail
	 * @return
	 */
	@PostMapping("carRegister")
	public String carRegister(VoCarDetail voDetailInsert) {
		System.out.println("CarController 클래스 carRegister 메서드 실행");
		System.out.println(voDetailInsert + "차량등록 값 확인");

		carService.getDetailInsert(voDetailInsert);
		return "redirect:carList";
	}


	@GetMapping("carRegister")
	public String carRegister(Model originSelect, Model vendorSelect, Model carClassSelect,Model carModelSelect, 
								Model yearCarSelect, Model voDetail, Model opGradeSelect, Model opChoiceSelect,
								  Model bigColSelect, Model midColSelect, Model fuelSelect, Model engineSelect,
								  	Model transMiSelect, Model driveWaySelect, Model powTrainSelect) {
		// model에 키,값 형태로 올려준다.
		//그룹화코드 잠시 건너뜀
		System.out.println("CarController 클래스 VoCarDetail 메서드 실행");
		
		powTrainSelect.addAttribute("powTrainSelect", carService.getPowTrainSelect());
		driveWaySelect.addAttribute("driveWaySelect", carService.getDriveWaySelect());
		transMiSelect.addAttribute("trnsMielect", carService.getTrnsMiSelect());
		engineSelect.addAttribute("engineSelect", carService.getEngineSelect()); //차량 엔진
		fuelSelect.addAttribute("fuelSelect", carService.getFuelSelect()); //차량 연료
		midColSelect.addAttribute("midColSelect", carService.getMidColSelect()); //차량 색상 중분류
		bigColSelect.addAttribute("bigColSelect", carService.getBigColSelect()); //차량 색상 대분류
		opChoiceSelect.addAttribute("opChoiceSelect", carService.getCarOpChoiceSelect()); // 차량 선택옵션
		opGradeSelect.addAttribute("opGradeSelect", carService.getOpGradeSelect()); // 차량 등급
		yearCarSelect.addAttribute("yearCarSelect", carService.getYearCarSelect()); //연도별 차량 상세모델
		carModelSelect.addAttribute("carModelSelect", carService.getCarModelSelect()); // 차량 모델
		carClassSelect.addAttribute("carClassSelect", carService.getCarClassSelect()); //차량 종류
		vendorSelect.addAttribute("vendorSelect", carService.getCarVendorSelect()); // 제작 업체
		originSelect.addAttribute("originSelect", carService.getCarOriginSelect()); // 차량 국가
		System.out.println(vendorSelect + "차량 컬러 대분류 선택");
		System.out.println(vendorSelect + "제작 회사 선택");
		System.out.println(originSelect + "차량 국가 선택");
		return "carregister/carRegister";
	}

	
	// ajax 컨트롤러에서 받는 방법
	@PostMapping(value = "/test", produces = "application/json")
	public @ResponseBody String ajaxTest(@RequestParam Map<String, String> json) {
		System.out.println("CarController 클래스 ajaxTest 메서드 실행");
		String a = json.get("age");
		return a;
	}
	
	  @GetMapping("/carList")
	  public String carList(VoCarRegister vcreg, Model model) {
	  System.out.println("CarController 클래스 carList 메서드 실행");
	  List<VoCarRegister> CarList = carService.getCarList(); 
	  System.out.println("값확인"+ CarList); model.addAttribute("vcreg", CarList); //어트리뷰트 : 어딘가에 등록이 되어있다 
	  return "carregister/carList";
	  
	  }
	 

}
