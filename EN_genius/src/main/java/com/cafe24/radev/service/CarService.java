package com.cafe24.radev.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.radev.mapper.CarMapper;
import com.cafe24.radev.vo.VoCarColor;
import com.cafe24.radev.vo.VoCarDetail;
import com.cafe24.radev.vo.VoCarFuel;
import com.cafe24.radev.vo.VoCarOption;
import com.cafe24.radev.vo.VoCarRegister;

@Service
public class CarService {
	
	@Autowired private CarMapper carMapper;
	
	public int getCarRegister(VoCarRegister voDetail) {
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
	  VoCarDetail a = carMapper.getCarUpdateList(carUpList);
	  return a; 
	  }
	 
	
	/**
	 * 차량 리스트 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarList() {
	return carMapper.getCarList();
	}
	
	//받은 매개변수로 다른 메서드를 호출한다 이때 내가 받은 매개변수를 대입한다
	/**
	 * 차량 등록 메서드
	 * @param vcreg
	 * @return
	 */
	/*
	 * public int getCarInsert(VoCarDetail voDetailInsert) {
	 * System.out.println("CarService 클래스 getCarInsert 메서드 실행"); return
	 * carMapper.getDetailInsert(voDetailInsert);
	 * 
	 * 
	 * }
	 */
	
//  셀렉트한 값을 가져와서 벤더사(모델명) 가져오기
	/*
	 * public List<String> getDBVendor(int selectVal){ 
	 * List<VoCarDetail> list = carMapper.getDBVendor(selectVal); 
	 * List<String> nameList = newArrayList<String>();
	 * 
	 * for(int i =0; i < list.size(); i++) {
	 * nameList.add(list.get(i).getCarModelName());
	 * System.out.println((i+1)+"번째 모델명 : "+list.get(i).getCarModelName()); 
	 * } return nameList; }
	 */

	public List<VoCarDetail> getDBCarDatail(@RequestParam(value = "carModelSmVal")String carModelSmVal,
			  @RequestParam(value = "carModelSmText")String carModelSmText) {
				return carMapper.getDBCarDatail(carModelSmVal, carModelSmText);
		
	}
	
	public List<VoCarDetail> getDBCarModel(VoCarDetail voCarDetail) {
		return carMapper.getDBCarModel(voCarDetail);
	}
	
	public List<VoCarDetail> getCarClass(String originCode, String vendorSm){
		System.out.println(originCode + "국가 서비스");
		System.out.println(vendorSm + "벤더 서비스");
		List<VoCarDetail> vendorList = carMapper.getCarClass(originCode, vendorSm);
		  
	return vendorList;
	}

	public List<VoCarDetail> getCarVendor(String originSm){
		List<VoCarDetail> originList = carMapper.getCarVendor(originSm);
	return originList;
	}


}
