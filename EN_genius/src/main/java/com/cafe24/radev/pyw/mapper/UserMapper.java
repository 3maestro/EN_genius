package com.cafe24.radev.pyw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.pyw.vo.CarFactory;
import com.cafe24.radev.pyw.vo.Employee;
import com.cafe24.radev.pyw.vo.ImageFile;

@Mapper
public interface UserMapper {

	int addCarFactory(CarFactory carFactory);
	
	int addDocumentFile(ImageFile imageFile);
	
	int bsCodeMax();
	
	int imageCodeMax();
	
	CarFactory adminLogin(CarFactory carFactory);
	
	List<CarFactory> carFactoryList();
	
	String selectImage(String bsCode);
	
	int approvalCheck(String[] bsCode);
}
