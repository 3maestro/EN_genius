package com.cafe24.radev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.WageMapper;
import com.cafe24.radev.vo.WageManHour;

@Service
public class WageService implements WageMapper {
	
	@Autowired private WageMapper wageMapper;
	
	public List<WageManHour> getWorkManHour() {
		System.out.println("getWorkManHour WageService 호출");
		List<WageManHour> list = wageMapper.getWorkManHour();
		//System.out.println(list + " <-list getWorkManHour WageService.java");
		return list;
	}
	
}
