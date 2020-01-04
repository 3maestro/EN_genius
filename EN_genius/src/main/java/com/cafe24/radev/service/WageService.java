package com.cafe24.radev.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.WageMapper;
import com.cafe24.radev.vo.NowWork;
import com.cafe24.radev.vo.WageManHour;
import com.cafe24.radev.vo.WorkDecide;

@Service
public class WageService implements WageMapper {
	
	@Autowired private WageMapper wageMapper;
	
	/**
	 * 작업 목록과 표준작업시간과 배기량별 단가 
	 */
	public List<WageManHour> getWorkManHour(String ccCode) {
		System.out.println("getWorkManHour WageService 호출");
		List<WageManHour> list = wageMapper.getWorkManHour(ccCode);
		//System.out.println(list + " <-list getWorkManHour WageService.java");
		return list;
	}
	
	public void getWorkingNow(WorkDecide workDecide) {
		System.out.println("getWorkingNow WageService 호출");
		System.out.println(workDecide + " <-workDecide getWorkingNow WageService.java");
		
		
		//wageMapper.getWorkingNow(list);
	}


}
