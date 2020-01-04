package com.cafe24.radev.mapper;

import java.util.List;

import com.cafe24.radev.vo.NowWork;
import com.cafe24.radev.vo.WageManHour;
import com.cafe24.radev.vo.WorkDecide;

public interface WageMapper {

	public List<WageManHour> getWorkManHour(String ccCode);
	
	public void getWorkingNow(WorkDecide workDecide);
	//public void getWorkingNow(List<NowWork> list);
	
}
