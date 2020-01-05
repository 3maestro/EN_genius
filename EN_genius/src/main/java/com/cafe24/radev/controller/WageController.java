package com.cafe24.radev.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.service.WageService;
import com.cafe24.radev.vo.NowWork;
import com.cafe24.radev.vo.WageManHour;
import com.cafe24.radev.vo.WorkDecide;

@Controller
public class WageController {

	@Autowired private WageService wageService;
	
	@GetMapping("/work/ccStandardWage")
	public String standardWage() {
		return "/wage/ccStandardWage";
	}
	
	@GetMapping("/work/workManHour")
	public String workManHour(Model model, HttpSession session) {
		System.out.println("workManHour WageController 호출");
		String ccCode = (String)session.getAttribute("CCCODE");
		System.out.println(ccCode + " <-ccCode 차량 조회 성공시 세션에 등록된 배기량 기준 코드");
//		int num = 1;
		List<WageManHour> list = wageService.getWorkManHour(ccCode);
//		for(int i=0; i<list.size(); i++) {
//			if(i > 0) {
//				num = i;
//				model.addAttribute("num",num);
//			}
//		}
		//System.out.println(list + " <-list workManHour WageController.java");
		model.addAttribute("wageManHour",list);
		model.addAttribute("num",list.size());
		
		return "/wage/workManHour";
	}
	
	@PostMapping("/work/workingNow")
	public String workingNow(Model model, WorkDecide workDecide) {
		System.out.println("workingNow WageController 호출");
		
//		// 배기량별 공임 단가 구하기
//		String ccCode = (String)session.getAttribute("CCCODE");
//		System.out.println(ccCode + " <-ccCode workingNow WageController.java");
//		int onePrice = wageService.getOnePrice(ccCode);
//		System.out.println(onePrice + " <-onePrice workingNow WageController.java\"");
//		System.out.println("workDecide workingNow WageController.java : " + workDecide);

		// 반복문 반복 횟수 구하기
		List<String> workDecideList = workDecide.getWageSmallName();
		  
		  //model.addAttribute("workDecide", workDecide);
		 
		/**
		 * String ccWageSmallCode = workDecide.getCcWageSmallCode(); List<WorkDecide>
		 * list = new ArrayList<WorkDecide>();
		 */
		/**
		 * form으로 넘어온 데이터들을 각각 분해 하여 vo에 setting
		 */
		NowWork nowWork = null;
		List<NowWork> list = new ArrayList<NowWork>();
		for(int i=0; i<workDecideList.size(); i++) {
			//String ccWageSmallCode = workDecide.getCcWageSmallCode().get(i);
			String wageSmallName = workDecide.getWageSmallName().get(i);
			String stManHour = workDecide.getManHour().get(i);
			String ccStandardWage = workDecide.getCcStandardWage().get(i);
			String stCount = workDecide.getCount().get(i);
			double manHour = Double.parseDouble(stManHour);
			int onePrice = Integer.parseInt(ccStandardWage);
			int count = Integer.parseInt(stCount);
			
//			System.out.println(ccWageSmallCode + " <-wageSmallCode");
//			System.out.println(wageSmallName + " <-wageSmallName");
//			System.out.println(manHour + " <-manHour");
//			System.out.println(onePrice + " <-onePrice");
//			System.out.println(count + " <-count");
			
			nowWork = new NowWork();
			//nowWork.setCcWageSmallCode(ccWageSmallCode);
			nowWork.setWageSmallName(wageSmallName);
			nowWork.setManHour(manHour);
			nowWork.setOnePrice(onePrice);
			nowWork.setCount(count);
			
			list.add(nowWork);
		}
		
		System.out.println(list.size() + " <-list.size() workingNow WageController.java");
		
       

		/**
		 * setting된 vo객체를 활용하여 견적 구하기
		 */
		List<NowWork> totalList = new ArrayList<NowWork>();
		//Map<String, Object> map = new HashMap<String, Object>();
		//NowWork nowWork = null;
		//String nowWorkCode = null;
		for(int i=0; i<list.size(); i++) {
			
			 // 랜덤 고유키 생성
	        UUID uuid = UUID.randomUUID();
	        System.out.println(uuid);
	 
	        // 하이픈 제외
	        String nowWorkCode = UUID.randomUUID().toString().replace("-", "");
	        System.out.println(nowWorkCode);
	        
			System.out.println("list 내의 데이터 추출 반복문 실행");
			nowWork = list.get(i);
			System.out.println(nowWork + " <-nowWork workingNow WageController.java");
			nowWork.setNowWorkCode(nowWorkCode);
			// 견적 액 = 표준 정비 시간 *단가 *수량
			int onePriceCount = nowWork.getOnePrice() * nowWork.getCount();
			int totalPrice = (int) (onePriceCount * nowWork.getManHour());
			System.out.println(totalPrice + " <-totalPrice 수량 * 단가 ");
			nowWork.setTotalPrice(totalPrice);
			System.out.println(nowWork + "견적액을 포함한 vo");
			
//			map.put("nowWorkCode", nowWork.getNowWorkCode());
//			map.put("wageSmallName", nowWork.getWageSmallName());
//			map.put("manHour", nowWork.getManHour());
//			map.put("onePrice", nowWork.getOnePrice());
//			map.put("count", nowWork.getCount());
//			map.put("totalPrice", nowWork.getTotalPrice());
			
			totalList.add(nowWork);
			System.out.println(totalList + " <-totalList 견적액을 포함한 list");
		}
		
		//System.out.println("list workingNow WageController : " + list);
		
		//Map<String,Object> map = new HashMap<String, Object>();
		
		wageService.insertWorkWage(totalList);
		
		return "/wage/workingNow";
	}
	
	@GetMapping("/work/wageEstimate")
	public String wageEstimate() {
		return "/wage/wageEstimate";
	}
	
}
