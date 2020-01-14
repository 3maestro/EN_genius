package com.cafe24.radev.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.WageMapper;
import com.cafe24.radev.vo.CcWage;
import com.cafe24.radev.vo.NowWork;
import com.cafe24.radev.vo.WageManHour;
import com.cafe24.radev.vo.WorkDecide;

@Service
public class WageService implements WageMapper {
	
	@Autowired private WageMapper wageMapper;
	
	public List<CcWage> ccStandardWage() {
		System.out.println("ccStandardWage WageService호출");
		return wageMapper.ccStandardWage();
	}
	
	/**
	 * 작업 목록과 표준작업시간과 배기량별 단가 
	 */
	public List<WageManHour> getWorkManHour(String ccCode) {
		System.out.println("getWorkManHour WageService 호출");
		List<WageManHour> list = wageMapper.getWorkManHour(ccCode);
		//System.out.println(list + " <-list getWorkManHour WageService.java");
		return list;
	}
	
	public int insertWorkWage(List<NowWork> totalList) {
		System.out.println("getWorkingNow WageService 호출");
		System.out.println("totalList getWorkingNow WageService : " + totalList);
		
		int result = wageMapper.insertWorkWage(totalList);
		System.out.println(result + " <-결과");
		
		
		return result;
	}

	public List<NowWork> workList(Map<String,Object> map) {
		System.out.println("workList WageService 호출");
		//System.out.println(wageMapper.workList() + " <- 너뭐니?");
		List<NowWork> nowWork = wageMapper.workList(map);
		System.out.println(nowWork + " <-nowWorknowWork");
		return nowWork;
	}
	
	public List<NowWork> getWorking(String recNum) {
		System.out.println("getWorking WageService 호출");
		System.out.println(recNum + " <-recNum getWorking WageService.java");
		
		List<NowWork> list = wageMapper.getWorking(recNum);
		System.out.println("list getWorking WageService : " + list);
		
		return list;
	}
	
	public void recEmpAssign(String recepNum) {
		System.out.println("recEmpAssign WageService 호출");
		System.out.println(recepNum + " <-recepNum recEmpAssign WageService.java");
	}
	
	/**
	 * 접수번호기준 작업배정
	 */
//	public List<NowWork> WorkCurrentList(String recepNum) {
//	System.out.println("WorkCurrentList WageService호출");
//	System.out.println(recepNum + " <-recepNum WorkCurrentList WageService.java");
//	
//	List<NowWork> workCurrentList = wageMapper.WorkCurrentList(recepNum);
//	System.out.println("workCurrentList : " + workCurrentList);
//	
//	return workCurrentList;
//}
	
}
