package com.cafe24.radev.mapper;

import java.util.List;

import com.cafe24.radev.vo.NowWork;
import com.cafe24.radev.vo.WageManHour;

public interface WageMapper {

	public List<WageManHour> getWorkManHour(String ccCode);
	
	public void getWorkingNow(List<NowWork> list);
}
