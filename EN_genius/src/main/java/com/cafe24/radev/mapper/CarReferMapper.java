package com.cafe24.radev.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarReferMapper {

	public void getCarRefer(String carInfo);
}
