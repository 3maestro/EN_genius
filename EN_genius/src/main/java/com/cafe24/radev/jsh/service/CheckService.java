package com.cafe24.radev.jsh.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.jsh.mapper.CheckMapper;
import com.cafe24.radev.jsh.vo.AskCheck;
import com.cafe24.radev.jsh.vo.BasicCheck;
import com.cafe24.radev.jsh.vo.RoutineCheck;

@Service
public class CheckService {

	@Autowired private CheckMapper checkMapper;
	
	
	public List<RoutineCheck> getRoutineCheckList(){
		System.out.println("getRoutineCheckList CheckService 호출");
		
		List<RoutineCheck> list = checkMapper.getRoutineCheckList();
		
		return list;
	}
	
	public List<String> getAskCheck(List<String> check, String car){
		System.out.println("getRoutineCheckList CheckService 호출");
		System.out.println("check getAskCheck CheckService.java -> " + check);
		System.out.println("car getAskCheck CheckService.java -> " + car);
		
		List<AskCheck> list = checkMapper.getAskCheck(car);
		System.out.println("list getAskCheck CheckService : " + list);
		
//		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
//		Calendar time = Calendar.getInstance();
//		String date = format.format(time.getTime());
//		System.out.println(date + "<-date getAskCheck CheckService.java");
		
		
		List<String> oxList = new ArrayList<String>();
//		List<String> getRiCodeList = new ArrayList<String>();

		//Map<String,String> map = new HashMap<String,String>();
		AskCheck ask = null;
		
		/**
		 *수리 내역중 정기점검 목록이 체그한 리스트보다 많을 때 
		 * 
		 */
		if(list.size() >= check.size()) {
			System.out.println("수리 내역중 정기점검 목록이 체크한 리스트(조회할 항목)보다 많거나 같을 때 ");
			
			//최근 수리 목록
			for(int i=0; i<list.size(); i++) {
				//체크한 목록
				for(int j=0; j<check.size(); j++){
					//체크한 목록의 항목코드
					String getCheckCode = check.get(j);		
					ask = new AskCheck();
					ask = list.get(i);
					//과거 수리목록중 최근 항목코드
					String getRiCode = ask.getRiCode();
					//과거 수리목록중 최근 수리 날짜
					String repairDate = ask.getAskRepairDate();
					// 체크항목과 최근 정비 내역의 정기 점검 항목이 일치 하다면 
					
					if(getRiCode.equals(getCheckCode)) {
						System.out.println("01. 체크 항목과 최근 정비 내역의 정기점검 항목이 일치 하다면 ");
						String period = checkMapper.getDate(repairDate);
						System.out.println(repairDate + "<-최근 수리 일자");
						//과거 수리 내역의 최근 수리 일자와 현재일자의 차이
						System.out.println(period + "<- 01기간");
						
						//형변환
						int intPeriod = Integer.parseInt(period);
						System.out.println(intPeriod + "<-intPeriod");
						
						//과거 수리 내역의 최근수리 일자와 현재 일자의 차이가 기간별 교환주기 보다 크거나 같다면 교환 필요
						if(intPeriod >= ask.getPeriodCycle()) {
							System.out.println("01 교환 필요");
							System.out.println(getRiCode + " 01 교환 필요 getRiCode");
							oxList.add(getRiCode);
							
						//과거 수리 내역의 최근 수리 일자와 현재 일자의 차이가 기간별 교환 주기보다 작다면 교환 필요 없음
						}
//						if(intPeriod < ask.getPeriodCycle()) {
//							System.out.println("01 교환 필요 없음");
//							System.out.println(getRiCode + " 01 교환 필요 없음 getRiCode");
//							oxList.add(getCheckCode);	
//						}
					}
				}
				
			}
			
		}else {
			// 체크한 리스트가 수리 내역중 정기 점검 내역 보다 많을 때
			System.out.println("체크한 리스트(조회할 항목)이 수리 내역중 정기점검 목록이 보다 많을 때 ");
			//체크 리스트 목록 
			for(int i=0; i<check.size(); i++) {
				//과서 수리 내역
				for(int j=0; j<list.size(); j++) {
					//체크한 항목의 목록
					String getCheckCode = check.get(i);
					ask = new AskCheck();
					ask = list.get(j);
					//과거수리 내역중 최근 수리 받은 코드
					String getRiCode = ask.getRiCode();
					//과거수리 내역중 최근 수리 일자
					String repairDate = ask.getAskRepairDate();
					// 체크 항목과 최근 정비 내역의 정기점검 항목이 일치 하다면 
					if(getCheckCode.equals(getRiCode)) {
						System.out.println("02. 체크 항목과 최근 정비 내역의 정기점검 항목이 일치 하다면 ");
						String period = checkMapper.getDate(repairDate);
						System.out.println(repairDate + "<-최근 수리 일자");
						//최근 수리일자와 현재 일자의 차이(날짜계산)
						System.out.println(period + "<- 02기간");
						
						//현재시간 - 당시 교환할때 날짜 
						int intPeriod = Integer.parseInt(period);
						System.out.println(intPeriod + "<-intPeriod");
						
						//최근 수리 받은 일자와 현재날짜의 차이를 계산후 기간별 교환 주기보다 크거나 같을때 교환필요
						if(intPeriod >= ask.getPeriodCycle()) {
							System.out.println("02 교환 필요");
							oxList.add(getRiCode);
						//최근 수리 받은 일자와 현재날짜의 차이를 계산후 기간별 교환 주기보다 작을 때 교환 필요 없음
						}
//						if(intPeriod < ask.getPeriodCycle()) {
//							System.out.println("02 교환 필요 없음");
//							oxList.add(getCheckCode);	
//						}					
					}
				}
			}
		}
		

		
		return oxList;
	}
	
	public List<String> getBasicCheckList(String bigCate) {
		
		System.out.println("getBasicCheckList CheckService 호출");
		System.out.println(bigCate + " <-bigCate getBasicCheckList CheckService.java");
		
		List<BasicCheck> list = checkMapper.getBasicCheckList(bigCate);
		System.out.println(list + " <-list getBasicCheckList CheckService.java");
		System.out.println(list.size() + " <-list.size() getBasicCheckList");
		
		List<String> midCateList = new ArrayList<String>();;
		
		for(int i=0; i<list.size(); i++) {
			BasicCheck basicCaheck = list.get(i);
			midCateList.add(basicCaheck.getCkMidName());
		}
		
		return midCateList;
	
	}
	
//	public List<Map<String, Object>> getCheckList(String bigcate){
//		System.out.println("getCheckList CheckService 호출");
//		System.out.println(bigcate + " <-bigCate getCheckList CheckService.java");
//		
//		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
//		
//		List<Check> listCheck = checkMapper.getCheckList(bigcate);
//		System.out.println(listCheck.size() + " <-사이즈 CheckService");
//		
//		//List<String> listMidName = new ArrayList<String>();
//		Map<String, Object> mapMidName = null;
//		
//		for(int i=0; i<listCheck.size(); i++) {
//			Check check = listCheck.get(i);
//			String midName = check.getCkMidName();
//			System.out.println(midName + " <-midName getCheckList CheckService.java");	
//			mapMidName = new HashMap<String, Object>();
//			mapMidName.put(bigcate, midName);
//			
//			listMap.add(mapMidName);
//		}
//		
//		return listMap;
//	}
	
}



//		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
//		listMap = checkMapper.getCheckList(bigcate);
//		System.out.println(listMap.size() + " <-사이즈");
//		for(int i=0; i<listMap.size(); i++) {
//			Map<String,Object> map = null;
//			map = listMap.get(i);
//			map.put(bigcate, 34f);
////			System.out.println(map + " <-나오니?");
////			for(int j=0; j<map.size(); j++) {
////				Map<String,String> checkMap = new HashMap<String,String>();
////				Check check = map.get(j);
////				String midCate = check.getCkMidName();
////				String bigCate = check.getCkBigName();
//////				map.put(bigcate, midCate );
////				checkMap.put(bigCate , midCate);
////				System.out.println(checkMap.get(bigCate));
//////			}
//		}
//		
//