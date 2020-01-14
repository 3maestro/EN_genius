package com.cafe24.radev.mapper;

import java.util.List;
import java.util.Map;

import com.cafe24.radev.vo.CcWage;
import com.cafe24.radev.vo.NowWork;
import com.cafe24.radev.vo.WageManHour;
import com.cafe24.radev.vo.WorkDecide;

public interface WageMapper {

	public List<CcWage> ccStandardWage();
	
	public List<WageManHour> getWorkManHour(String ccCode);
	
	public int insertWorkWage(List<NowWork> totalList);
	
	public List<NowWork> workList(Map<String,Object> map);
	
//	public List<NowWork> WorkCurrentList(String recepNum);
	
	public List<NowWork> getWorking(String recNum);
	
	public void recEmpAssign(String recepNum);
}
