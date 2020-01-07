package com.cafe24.radev.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public int insertWorkWage(List<NowWork> totalList) {
		System.out.println("getWorkingNow WageService 호출");
		System.out.println("totalList getWorkingNow WageService : " + totalList);
		
//		System.out.println(list.size() + " <-list.size() getWorkingNow WageService.java");
//		
//		List<NowWork> totalList = new ArrayList<NowWork>();
//		NowWork nowWork = null;
//		for(int i=0; i<list.size(); i++) {
//			System.out.println("list 내의 데이터 추출 반복문 실행");
//			nowWork = list.get(i);
//			System.out.println(nowWork + " <-nowWork getWorkingNow WageService.java");
//			
//			// 견적 액 = 표준 정비 시간 *단가 *수량
//			int onePriceCount = nowWork.getOnePrice() * nowWork.getCount();
//			int totalPrice = (int) (onePriceCount * nowWork.getManHour());
//			System.out.println(totalPrice + " <-totalPrice 수량 * 단가 ");
//			nowWork.setTotalPrice(totalPrice);
//			System.out.println(nowWork + "견적액을 포함한 vo");
//			
//			totalList.add(nowWork);
//			System.out.println(totalList + " <-totalList 견적액을 포함한 list");
//		}
		
		//Map<String,Object> map = new HashMap<String, Object>();
		
		int result = wageMapper.insertWorkWage(totalList);
		System.out.println(result + " <-결과");
		
		
		return result;
	}

//	@Override
//	public void insertWorkWage(Map<String, Object> map) {
//		System.out.println("insertWorkWage WageService 호출");
//		
//	}

	public List<NowWork> workList(Map<String,Object> map) {
		System.out.println("workList WageService 호출");
		//System.out.println(wageMapper.workList() + " <- 너뭐니?");
		List<NowWork> nowWork = wageMapper.workList(map);
		System.out.println(nowWork + " <-nowWorknowWork");
		return nowWork;
	}
}
