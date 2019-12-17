package com.cafe24.radev.pet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.pet.vo.FirstCategoryForCar;
import com.cafe24.radev.pet.vo.SecondCategoryForCar;

@Mapper
public interface CategoryForCarMapper{
	/**
	 * 차량관리대분류 목록조회
	 * @return
	 */
	List<FirstCategoryForCar> getFirstCateList();
	/**
	 * 차량관리중분류 목록조회
	 * @return
	 */
	List<SecondCategoryForCar> getSecondCateList(String fVal);
}
