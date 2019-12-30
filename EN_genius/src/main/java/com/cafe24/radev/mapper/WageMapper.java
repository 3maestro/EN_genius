package com.cafe24.radev.mapper;

import java.util.List;

import com.cafe24.radev.vo.WageManHour;

public interface WageMapper {

	public List<WageManHour> getWorkManHour(String ccCode);
}
