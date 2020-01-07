package com.cafe24.radev.mapper;

import java.util.List;
import java.util.Map;

import com.cafe24.radev.vo.NowWork;
import com.cafe24.radev.vo.WageManHour;
import com.cafe24.radev.vo.WorkDecide;

public interface WageMapper {

	public List<WageManHour> getWorkManHour(String ccCode);
	
	//public void getWorkingNow(WorkDecide workDecide);
	//public void getWorkingNow(Map<String,Object> map);
	public int insertWorkWage(List<NowWork> totalList);
	//public void insertWorkWage(Map<String, Object> map);
	//public void insertWorkWage(Map<String,Object> map);
	public List<NowWork> workList(Map<String,Object> map);
}
