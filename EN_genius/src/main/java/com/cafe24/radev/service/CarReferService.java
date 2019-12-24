package com.cafe24.radev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.CarReferMapper;

@Service
public class CarReferService implements CarReferMapper {

	@Autowired CarReferMapper carReferMapper;
	
	public void getCarRefer(String carInfo) {
		System.out.println("getCarRefer CarRefer 호출");
		System.out.println(carInfo + " <-carInfo 값 분기 필요");
		
		int carInfoLength = carInfo.length();
		System.out.println(carInfoLength + " <-조회 하고자 하는 차량 정보의 글자수");
		
		if(carInfoLength < 9) {
			System.out.println("차량 번호로 조회 했다");
			String carNum = carInfo;
			carReferMapper.getCarRefer(carNum);
		}else {
			System.out.println("차대 번호로 조회 했다");
			String carCode = carInfo;
			carReferMapper.getCarRefer(carCode);
		}
		
		//carReferMapper.getCarRefer(carInfo);
		
		
	}
	
}
