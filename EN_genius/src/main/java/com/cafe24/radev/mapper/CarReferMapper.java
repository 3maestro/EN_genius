package com.cafe24.radev.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.CarRefer;

@Mapper
public interface CarReferMapper {

	public CarRefer getCarRefer(String carInfo);
}
