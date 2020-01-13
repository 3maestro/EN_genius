package com.cafe24.radev.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.mapper.CarMapper;
import com.cafe24.radev.service.CarService;
import com.cafe24.radev.vo.VoCarDetail;
import com.cafe24.radev.vo.VoCarRegister;
import com.cafe24.radev.vo.VoRecRegister;

@Controller
public class CarController {
	//등록버튼 누르기 전 Datail쪽 마무리 하기
	
	// get방식은 값을 지정해서 보내줄때 사용
	// post방식은 지정한 값을 한방에 보내줄때 사용

	@Autowired
	private CarService carService;
	

	/**
	 * 차량 상세보기
	 * @param carUpList
	 * @return
	 */
	  @GetMapping("carUpdateList") 
	  public String getCarUpdateList(@RequestParam("carUpList") String carUpList, Model model) {
	  System.out.println("컨36" + carUpList);
	  model.addAttribute("carUpList", carService.getCarUpdateList(carUpList));
	  System.out.println("컨38" + carUpList);
	  return "carregister/carUpdateList"; 
	  }
	  
	 
	@PostMapping("carRegister")
	public String carRegister(VoCarDetail voDetailInsert, HttpSession session) {
		String sid		= (String)session.getAttribute("SID");
		String scode	= (String)session.getAttribute("SCODE");
		voDetailInsert.setSid(sid);
		voDetailInsert.setScode(scode);
		System.out.println("scode" + scode);
		System.out.println("컨46" + voDetailInsert);
		carService.getCarRegister(voDetailInsert);
		return "redirect:carList";
	}

	
	@GetMapping("carRegister")
	public String carRegister(Model CarSelect) {
		// model에 키,값 형태로 올려준다.
		//그룹화코드 잠시 건너뜀
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
		/*
		 * System.out.println(CarSelect + "차량 컬러 대분류 선택"); System.out.println(CarSelect
		 * + "제작 회사 선택"); System.out.println(CarSelect + "차량 국가 선택");
		 */
		return "carregister/carRegister";
	}

	  @PostMapping("customerNameSelect")
	  public @ResponseBody List<String> customerNameSelect (@RequestParam (value = "customerName")String customerName) {
		  List<String> customerNameList = carService.customerNameSelect(customerName);
		  System.out.println("컨88" + customerNameList);
		  return customerNameList;
		  
	  }
	
	  @GetMapping("/carList")
	  public String carList(VoCarDetail voDetail, Model model) {
	  List<VoCarDetail> CarList = carService.getCarList(); 
	  model.addAttribute("voDetail", CarList);
	  return "carregister/carList";
	  }
	  
	  @PostMapping("getDBCarMidCate")
	  public @ResponseBody List<VoCarDetail> getDBCarMidCate(@RequestParam(value ="bigColSm")String bigColSm) {
		  List<VoCarDetail> midColorList =carService.getDBCarMidCate(bigColSm);
		  return midColorList;
	  }
	  
	  @PostMapping("getDBCarBigCate")
	  public @ResponseBody List<VoCarDetail> getDBCarBigCate(@RequestParam(value = "carModelSm")String carModelSm) {
		  List<VoCarDetail> bigColorList = carService.getDBCarBigCate(carModelSm);
		return bigColorList;
	  }
	  
	  @PostMapping("getDBCarEngin")
	  public @ResponseBody List<VoCarDetail> getDBCarEngin(@RequestParam(value = "fuelSm")String fuelSm) {
		  List<VoCarDetail> carEnginList = carService.getDBCarEngin(fuelSm);
		return carEnginList;
	  }
	  
	  
	  @PostMapping("getDBCarfuel")
	  public @ResponseBody List<VoCarDetail> getDBCarfuel(@RequestParam(value = "opGradeSm")String opGradeSm) {
		  List<VoCarDetail> carfuelList = carService.getDBCarfuel(opGradeSm);
		return carfuelList;
		  
	  }
	 
	  @PostMapping("getDBCarGrade")
	  public @ResponseBody List<VoCarDetail> getDBCarGrade(@RequestParam(value = "yearCarSm")String yearCarSm) {
		  List<VoCarDetail> carGradeList = carService.getDBCarGrade(yearCarSm);
		  return carGradeList;
	  }
	 
	  @PostMapping("getDBCarDetail")
	  public @ResponseBody List<VoCarDetail> getDBCarDetail(@RequestParam(value = "carModelSmVal")String carModelSmVal,
			  @RequestParam(value = "carModelSmText")String carModelSmText){
		  List<VoCarDetail> carDetailList = carService.getDBCarDetail(carModelSmVal, carModelSmText);
		return carDetailList;
	  }
	  
	  @PostMapping("getCarModel")
	  public @ResponseBody List<VoCarDetail> getDBCarModel(VoCarDetail voCarDetail){
		  List<VoCarDetail> carModelList = carService.getDBCarModel(voCarDetail);
		  return carModelList;
	  }
	  
	  @PostMapping("getCarClass")
	  public @ResponseBody List<VoCarDetail> getDBCarClass(@RequestParam(value = "vendorSm")String vendorSm,
			  @RequestParam(value = "originCode")String originCode){
		  System.out.println(vendorSm + " : 벤더 에이작스에서 넘어올때 벤더");
		  System.out.println(originCode + " : 오리진 에이작스에서 넘어올때 벤더");
		  
		
		  List<VoCarDetail> vendorList = carService.getCarClass(originCode, vendorSm);
		  System.out.println(vendorList + "컨트롤러 클래스");
		 
		  return vendorList;
	  }
	  
	  @PostMapping("getCarVendor")
	  public @ResponseBody List<VoCarDetail> getDBCarVendor(@RequestParam(value = "originSm")String originSm){
		  List<VoCarDetail> originList = carService.getCarVendor(originSm);
		  System.out.println(originList + "컨트롤러 벤더");
		  return originList;
	  }
}
