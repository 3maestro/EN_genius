package com.cafe24.radev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.service.CarService;
import com.cafe24.radev.vo.VoCarDetail;
import com.cafe24.radev.vo.VoCarRegister;

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
	
	
	/*
	 * @GetMapping("repHistory") public String getCarRepHistory(Model model) {
	 * System.out.println("CarController 클래스 getCarRepHistory 메서드 실행"); return
	 * "carregister/repHistory"; }
	 */
	
	/**
	 * 차량 상세보기
	 * @param carUpList
	 * @return
	 */
	  @GetMapping("carUpdateList") 
	  public String getCarUpdateList(@RequestParam("carUpList") String carUpList, Model model) {
	  System.out.println(carUpList + "UpList 값 확인");
	  model.addAttribute("carUpList", carService.getCarUpdateList(carUpList));
	  System.out.println(carUpList + "<---aaaa");
	  
	  System.out.println("CarController 클래스 carUpdateList 메서드 실행");
	  return "carregister/carUpdateList"; 
	  }
	  
	 
	@PostMapping("carRegister")
	public String carRegister(VoCarRegister voDetailInsert) {
		System.out.println("CarController 클래스 carRegister 메서드 실행");
		System.out.println(voDetailInsert + "차량등록 값 확인");

		carService.getCarRegister(voDetailInsert);
		return "redirect:carList";
	}

	
	@GetMapping("carRegister")
	public String carRegister(Model CarSelect) {
		// model에 키,값 형태로 올려준다.
		//그룹화코드 잠시 건너뜀
		System.out.println("CarController 클래스 VoCarDetail 메서드 실행");
		CarSelect.addAttribute("powTrainSelect", carService.getPowTrainSelect());
		CarSelect.addAttribute("driveWaySelect", carService.getDriveWaySelect());
		CarSelect.addAttribute("trnsMielect", carService.getTrnsMiSelect());
		CarSelect.addAttribute("engineSelect", carService.getEngineSelect()); //차량 엔진
		CarSelect.addAttribute("fuelSelect", carService.getFuelSelect()); //차량 연료
		CarSelect.addAttribute("midColSelect", carService.getMidColSelect()); //차량 색상 중분류
		CarSelect.addAttribute("bigColSelect", carService.getBigColSelect()); //차량 색상 대분류
		CarSelect.addAttribute("opChoiceSelect", carService.getCarOpChoiceSelect()); // 차량 선택옵션
		CarSelect.addAttribute("opGradeSelect", carService.getOpGradeSelect()); // 차량 등급
		CarSelect.addAttribute("yearCarSelect", carService.getYearCarSelect()); //연도별 차량 상세모델
		CarSelect.addAttribute("carModelSelect", carService.getCarModelSelect()); // 차량 모델
		CarSelect.addAttribute("carClassSelect", carService.getCarClassSelect()); //차량 종류
		CarSelect.addAttribute("vendorSelect", carService.getCarVendorSelect()); // 제작 업체
		CarSelect.addAttribute("originSelect", carService.getCarOriginSelect()); // 차량 국가
		System.out.println(CarSelect + "차량 컬러 대분류 선택");
		System.out.println(CarSelect + "제작 회사 선택");
		System.out.println(CarSelect + "차량 국가 선택");
		return "carregister/carRegister";
	}

	
	// ajax 컨트롤러에서 받는 방법
	/*
	 * @PostMapping(value = "/test", produces = "application/json")
	 * public @ResponseBody String ajaxTest(@RequestParam Map<String, String> json)
	 * { System.out.println("CarController 클래스 ajaxTest 메서드 실행"); String a =
	 * json.get("age"); return a; }
	 */
	
	  @GetMapping("/carList")
	  public String carList(VoCarDetail voDetail, Model model) {
	  System.out.println("CarController 클래스 carList 메서드 실행");
	  List<VoCarDetail> CarList = carService.getCarList(); 
	  System.out.println("값확인"+ CarList); model.addAttribute("voDetail", CarList); //어트리뷰트 : 어딘가에 등록이 되어있다 
	  return "carregister/carList";
	  
	  }
	 

	/*
	 * @GetMapping("/dustmq") public String dustmq() {
	 * System.out.println("CarController 연습 메서드 실행"); return "carregister/dustmq";
	 * 
	 * }
	 */
	/*
	 * @PostMapping("/getModel") public @ResponseBody List<String>
	 * getModel(@RequestParam(value = "selectVal")int selectVal){ List<String>
	 * nameList = carService.getDBVendor(selectVal); //Map<String,List<String>> map
	 * = new HashMap<String, List<String>>(); //map.put("carName", nameList); return
	 * nameList; }
	 */
	  
	  @PostMapping("/getCarModel")
	  public @ResponseBody List<String> getDBCarModel(@RequestParam(value = "originSm")String originSm){
		  System.out.println(originSm + "assasadasdsadsadas");
		  List<String> CarModelList = carService.getDBCarModel(originSm);
		  return CarModelList;
		  //Map<String,List<String>> map = new HashMap<String, List<String>>();
		  //map.put("carName", nameList);
	  }
}
