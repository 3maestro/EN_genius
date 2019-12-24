package com.cafe24.radev.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.CarFactory;
import com.cafe24.radev.vo.Employee;
import com.cafe24.radev.vo.ImageFile;

@Mapper
public interface UserMapper {

	int addCarFactory(CarFactory carFactory);
	
	int addDocumentFile(ImageFile imageFile);
	
	int bsCodeMax();
	
	CarFactory adminLogin(CarFactory carFactory);
	
	List<CarFactory> carFactoryList();
	
	String selectImage(String bsCode);
	
	int approvalCheck(Map<String, Object> map);
	
	int approvalRefusal(List<String> checkArray);
}
