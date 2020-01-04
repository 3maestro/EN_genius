package com.cafe24.radev.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<String> workDecideList = workDecide.getCcWageSmallCode();
		  
		  //model.addAttribute("workDecide", workDecide);
		 
		/*
		 * String ccWageSmallCode = workDecide.getCcWageSmallCode(); List<WorkDecide>
		 * list = new ArrayList<WorkDecide>();
		 */
		NowWork nowWork = null;
		List<NowWork> list = new ArrayList<NowWork>();
		for(int i=0; i<workDecideList.size(); i++) {
			String ccWageSmallCode = workDecide.getCcWageSmallCode().get(i);
			String wageSmallName = workDecide.getWageSmallName().get(i);
			String manHour = workDecide.getManHour().get(i);
			String ccStandardWage = workDecide.getCcStandardWage().get(i);
			String stCount = workDecide.getCount().get(i);
			int onePrice = Integer.parseInt(ccStandardWage);
			int count = Integer.parseInt(stCount);
			
			System.out.println(ccWageSmallCode + " <-wageSmallCode");
			System.out.println(wageSmallName + " <-wageSmallName");
			System.out.println(manHour + " <-manHour");
			System.out.println(onePrice + " <-onePrice");
			System.out.println(count + " <-count");
			
			nowWork = new NowWork();
			nowWork.setCcWageSmallCode(ccWageSmallCode);
			nowWork.setWageSmallName(wageSmallName);
			nowWork.setManHour(manHour);
			nowWork.setOnePrice(onePrice);
			nowWork.setCount(count);
			
			list.add(nowWork);
		}
		
		System.out.println(list + " <-list workingNow WageController.java");
		
		wageService.getWorkingNow(workDecide);
		
		return "/wage/workingNow";
	}
	
	@GetMapping("/work/wageEstimate")
	public String wageEstimate() {
		return "/wage/wageEstimate";
	}
	
}
