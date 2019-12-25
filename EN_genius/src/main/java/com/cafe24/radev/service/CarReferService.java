package com.cafe24.radev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.CarReferMapper;
import com.cafe24.radev.vo.CarRefer;

@Service
public class CarReferService implements CarReferMapper {

	@Autowired CarReferMapper carReferMapper;
	
	public CarRefer getCarRefer(String carInfo) {
		System.out.println("getCarRefer CarRefer 호출");
		System.out.println(carInfo + " <-carInfo 값 분기 필요");
		//CarRefer carRefer = null;
//		int carInfoLength = carInfo.length();
//		System.out.println(carInfoLength + " <-조회 하고자 하는 차량 정보의 글자수");
		CarRefer carRefer = carReferMapper.getCarRefer(carInfo);
		System.out.println(carRefer + " <-carRefer 차량 정보 조회 성공한 고객 차량 정보");
//		if(carInfoLength < 9) {
//			System.out.println("차량 번호로 조회 했다");
//			//String carNum = carInfo;
//			System.out.println(carInfo + " <-carNum getCarRefer CarReferService.java");
//			carRefer = carReferMapper.getCarRefer(carInfo);
//			System.out.println(carRefer + " <-carRefer 차량 번호로 조회 성공한 고객 차량 정보");
//		}else {
//			System.out.println("차대 번호로 조회 했다");
//			//String carCode = carInfo;
//			System.out.println(carInfo + " <-carCode getCarRefer CarReferService.java");
//			carRefer = carReferMapper.getCarRefer(carInfo);
//			System.out.println(carRefer + " <-carRefer 차대 번호로 조회 성공한 고객 차량 정보");
//		}
		
		return carRefer;
	}
	
}
