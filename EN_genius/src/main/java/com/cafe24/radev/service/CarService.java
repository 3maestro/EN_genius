package com.cafe24.radev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.CarMapper;
import com.cafe24.radev.vo.VoCarColor;
import com.cafe24.radev.vo.VoCarDetail;
import com.cafe24.radev.vo.VoCarFuel;
import com.cafe24.radev.vo.VoCarOption;
import com.cafe24.radev.vo.VoCarRegister;

@Service
public class CarService {
	
	@Autowired private CarMapper carMapper;
	
	
	public List<VoCarFuel> getPowTrainSelect() {
		System.out.println("CarService 클래스 getPowTrainSelect 메서드 실행");
		return carMapper.getPowTrainSelect();
	}
	
	public List<VoCarFuel> getDriveWaySelect() {
		System.out.println("CarService 클래스 getDriveWaySelect 메서드 실행");
		return carMapper.getDriveWaySelect();
	}
	
	public List<VoCarFuel> getTrnsMiSelect() {
		System.out.println("CarService 클래스 getTransMiSelect 메서드 실행");
		return carMapper.getTrnsMiSelect();
	}
	
	public List<VoCarFuel> getEngineSelect() {
		System.out.println("CarService 클래스 getEngineSelect 메서드 실행");
		return carMapper.getEngineSelect();
	}
	
	public List<VoCarFuel> getFuelSelect() {
		System.out.println("CarService 클래스 getFuelSelect 메서드 실행");
		return carMapper.getFuelSelect();
	}
	
	/**
	 * 차량 중분류 컬러선택 메서드
	 * @return
	 */
	public List<VoCarColor> getMidColSelect(){
		System.out.println("CarService 클래스 getMidColSelect 메서드 실행");
		return carMapper.getMidColSelect();
	}
	
	/**
	 * 차량 대분류 컬러선택 메서드
	 * @return
	 */
	public List<VoCarColor> getBigColSelect(){
		System.out.println("CarService 클래스 getBigColSelect 메서드 실행");
		return carMapper.getBigColSelect();
				
	}
		
	/**
	 * 차량 선택옵션 메서드
	 * @return
	 */
	public List<VoCarOption> getCarOpChoiceSelect () {
		System.out.println("CarService 클래스 getCarOpChoiceSelect 메서드 실행");
		return carMapper.getCarOpChoiceSelect();
	}
	
	/**
	 * 차량 옵션등급 메서드
	 * @return
	 */
	public List<VoCarOption> getOpGradeSelect() {
		System.out.println("CarService 클래스 getOpGradeSelect 메서드 실행");
		return carMapper.getOpGradeSelect();
	}
	
	/**
	 * 차량 Detail Insert 메서드
	 * @param voDetail
	 * @return
	 */
	public int getDetailInsert(VoCarDetail voDetail) {
		System.out.println("CarService 클래스 getDetailInsert 메서드 실행");
		return carMapper.getDetailInsert(voDetail);
	}
	
	/**
	 * 연도별 차량 메서드
	 * @return
	 */
	public List<VoCarDetail> getYearCarSelect() { 
		System.out.println("CarService 클래스 getYearCarSelect 메서드 실행");
		return carMapper.getYearCarSelect(); 
	}
	 
	
	/**
	 * 차량 모델 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarModelSelect() {
		System.out.println("CarService 클래스 getCarModelSelect 메서드 실행");
		return carMapper.getCarModelSelect();
	}
	
	/**
	 * 차량 종류 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarClassSelect() {
		System.out.println("CarService 클래스 getCarClassSelect 메서드 실행");
		return carMapper.getCarClassSelect();
	}
	
	/**
	 * 차량 제작회사 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarVendorSelect() {
		System.out.println("CarService 클래스 getCarVendorSelect 메서드 실행");
		return carMapper.getCarVendorSelect();
	}
	
	/**
	 * 차량 국가 선택 메서드
	 * @return
	 */
	public List<VoCarDetail> getCarOriginSelect() {
		System.out.println("CarService 클래스 getCarOriginSelect 메서드 실행");
		return carMapper.getCarOriginSelect();
	}
	
	//차량 수정 조회 메서드
	public VoCarRegister getCarUpdate(String cuscar) {
		System.out.println("CarService 클래스 getCarUpdate 메서드 실행");
		return carMapper.getCarUpdate(cuscar);
	}
	
	/**
	 * 차량 리스트 메서드
	 * @return
	 */
	public List<VoCarRegister> getCarList() {
		System.out.println("CarService 클래스 getCarList 메서드 실행");
	return carMapper.getCarList();
	}
	
	//받은 매개변수로 다른 메서드를 호출한다 이때 내가 받은 매개변수를 대입한다
	/**
	 * 차량 등록 메서드
	 * @param vcreg
	 * @return
	 */
	public int getCarInsert(VoCarRegister vcreg) {
		System.out.println("CarService 클래스 getCarInsert 메서드 실행");
		return carMapper.getCarInsert(vcreg);
		
		
	}
}
