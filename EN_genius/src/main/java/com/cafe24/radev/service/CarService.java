package com.cafe24.radev.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.mapper.CarMapper;
import com.cafe24.radev.vo.VoCarColor;
import com.cafe24.radev.vo.VoCarDetail;
import com.cafe24.radev.vo.VoCarFuel;
import com.cafe24.radev.vo.VoCarOption;
import com.cafe24.radev.vo.VoCarRegister;

@Service
public class CarService {
	
	@Autowired private CarMapper carMapper;
	
	public List<String> customerNameSelect (@RequestParam (value = "customerName")String customerName) {
		return carMapper.customerNameSelect(customerName);
		  
	  }
	
	public int getCarRegister(VoCarDetail voDetail) {
		System.out.println("섭3스" + voDetail);
		return carMapper.getCarRegister(voDetail);
	}
	
	public List<VoCarFuel> getPowTrainSelect() {
		return carMapper.getPowTrainSelect();
	}
	
	public List<VoCarFuel> getDriveWaySelect() {
		return carMapper.getDriveWaySelect();
	}
	
	public List<VoCarFuel> getTrnsMiSelect() {
		return carMapper.getTrnsMiSelect();
	}
	
	public List<VoCarFuel> getEngineSelect() {
		return carMapper.getEngineSelect();
	}
	
	public List<VoCarFuel> getFuelSelect() {
		return carMapper.getFuelSelect();
	}
	
	/**
	 * 차량 중분류 컬러선택 메서드
	 * @return
	 */
	public List<VoCarColor> getMidColSelect(){
		return carMapper.getMidColSelect();
	}
	
	/**
	 * 차량 대분류 컬러선택 메서드
	 * @return
	 */
	public List<VoCarColor> getBigColSelect(){
		return carMapper.getBigColSelect();
	}
		
	/**
	 * 차량 선택옵션 메서드
	 * @return
	 */
	public List<VoCarOption> getCarOpChoiceSelect () {
		return carMapper.getCarOpChoiceSelect();
	}
	
	/**
	 * 차량 옵션등급 메서드
	 * @return
	 */
	public List<VoCarOption> getOpGradeSelect() {
		return carMapper.getOpGradeSelect();
	}
	
	/**
	 * 차량 Detail Insert 메서드
	 * @param voDetail
	 * @return
	 */
	
	/**
	 * 연도별 차량 메서드
	 * @return
	 */
	public List<VoCarDetail> getYearCarSelect() { 
		return carMapper.getYearCarSelect(); 
	}
	 
	
	/**
	 * 차량 모델 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarModelSelect() {
		return carMapper.getCarModelSelect();
	}
	
	/**
	 * 차량 종류 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarClassSelect() {
		return carMapper.getCarClassSelect();
	}
	
	/**
	 * 차량 제작회사 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarVendorSelect() {
		return carMapper.getCarVendorSelect();
	}
	
	/**
	 * 차량 국가 선택 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarOriginSelect() {
		return carMapper.getCarOriginSelect();
	}
	
	//차량 상세 조회 메서드
	public VoCarDetail getCarUpdateList(String carUpList) {
		System.out.println("서비스" + carUpList);
	  VoCarDetail updateList = carMapper.getCarUpdateList(carUpList);
	  return updateList; 
	  }
	 
	
	/**
	 * 차량 리스트 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarList() {
	return carMapper.getCarList();
	}
	
	//받은 매개변수로 다른 메서드를 호출한다 이때 내가 받은 매개변수를 대입한다
	
	public List<VoCarDetail> getDBCarMidCate (String bigColSm) {
		return carMapper.getDBCarMidCate(bigColSm);
	}
	
	public List<VoCarDetail> getDBCarBigCate(String carModelSm) {
		return carMapper.getDBCarBigCate(carModelSm);
	}
	
	public List<VoCarDetail> getDBCarEngin(String fuelSm) {
		return carMapper.getDBCarEngin(fuelSm);
	}
	
	public List<VoCarDetail> getDBCarfuel(String opGradeSm) {
		return carMapper.getDBCarfuel(opGradeSm);
	}
	
	public List<VoCarDetail> getDBCarGrade(String yearCarSm) {
		return carMapper.getDBCarGrade(yearCarSm);
	}

	/**
	 * 차량모델 선택시 상세차량 동적 셀렉트 박스.
	 * @param carModelSmVal
	 * @param carModelSmText
	 * @return
	 */
	public List<VoCarDetail> getDBCarDetail(@RequestParam(value = "carModelSmVal")String carModelSmVal,
			  @RequestParam(value = "carModelSmText")String carModelSmText) {
				return carMapper.getDBCarDetail(carModelSmVal, carModelSmText);
		
	}
	
	/**
	 * 차량종류 선택시 차량모델 동적 셀렉트 박스
	 * @param voCarDetail
	 * @return
	 */
	public List<VoCarDetail> getDBCarModel(VoCarDetail voCarDetail) {
		return carMapper.getDBCarModel(voCarDetail);
	}
	
	/**
	 * 벤더 선택시 차량종류 동적 셀렉트 박스
	 * @param originCode
	 * @param vendorSm
	 * @return
	 */
	public List<VoCarDetail> getCarClass(String originCode, String vendorSm){
		System.out.println(originCode + "국가 서비스");
		System.out.println(vendorSm + "벤더 서비스");
		List<VoCarDetail> vendorList = carMapper.getCarClass(originCode, vendorSm);
		  
	return vendorList;
	}

	/**
	 * 국가선택시 벤더사 동적셀렉트 박스
	 * @param originSm
	 * @return
	 */
	public List<VoCarDetail> getCarVendor(String originSm){
		List<VoCarDetail> originList = carMapper.getCarVendor(originSm);
	return originList;
	}


}
