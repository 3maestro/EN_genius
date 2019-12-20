package com.cafe24.radev.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.service.CheckService;
import com.cafe24.radev.vo.BasicCheck;
import com.cafe24.radev.vo.RoutineCheck;

@Controller
public class CheckController {

	@Autowired private CheckService checkService;
	
	@GetMapping("/check/routineCheckList")
	public String routineCheckList(Model model) {
		System.out.println("routineCheckList CheckController 호출");
		
		List<RoutineCheck> list = checkService.getRoutineCheckList();
		model.addAttribute("routineCheckList", list);
		
		return "/check/routineCheckList";
	}
	
	@PostMapping("/check/askCheck")
	public @ResponseBody List<String> askCheck(
			@RequestParam(value="check[]", required = false) List<String> check, String car) {
		System.out.println("askCheck CheckController 호출");
		System.out.println(check + " <-check askCheck CheckController.java");
		System.out.println(car + " <-car askCheck CheckController.java");
		
		List<String> list = new ArrayList<String>();
		list = checkService.getAskCheck(check, car);
		System.out.println(list + " <-re askCheck CheckController.java");
		
		return list;
	}
	
	@GetMapping("/check/basicCheck")
	public String basicCheck() {
		return "/check/basicCheckList";
	}
	
	@PostMapping("/check/bigCheckList")
	public @ResponseBody List<BasicCheck> bigCheckList(
			@RequestParam(value="bigCate", required = false) String bigCate) {
		System.out.println("bigCheckList CheckController 호출");
		System.out.println(bigCate + " <-bigCate bigCheckList CheckController.java");
		
		List<BasicCheck> bigCateList = checkService.getBigCheckList(bigCate);
		System.out.println(bigCateList + " <-midCateList bigCheckList CheckController.java");
		
		return bigCateList;
	}
	
	@PostMapping("/check/midCheckList")
	public @ResponseBody List<BasicCheck> midCheckList(
			@RequestParam(value="midCate", required = false) String midCate){
		System.out.println("midCheckList CheckController 호출");
		System.out.println(midCate + " <-midCate midCheckList CheckController.java");
		
		List<BasicCheck> smallCateList = checkService.getMidCheckList(midCate);
		System.out.println(smallCateList + " <-smallCateList midCheckList CheckController.java");
		
		return smallCateList;
	}
	
	@PostMapping("/check/smallCheckList")
	public @ResponseBody BasicCheck smallCheckList(
			@RequestParam(value="smallCate", required = false) String smallCate){
		System.out.println("smallCheckList CheckController 호출");
		System.out.println(smallCate + " <-smallCate smallCheckList CheckController.java");
		
		BasicCheck basicCheck = checkService.getSamllCheckList(smallCate);
		System.out.println(basicCheck + " <-basicCheck smallCheckList CheckController.java");
		
		return basicCheck;
	}
	
	
	//@ResponseBody Map<String, Object>
	//@ResponseBody List<Map<String, Object>>
	@GetMapping("/check/diagnosisGuide") 
	public String checkList() {
		System.out.println("checkList CheckController 호출");
		return "/check/diagnosisGuide";
	}
	 
//	@PostMapping(value="/checkList", produces = "application/json")
//	public @ResponseBody List<Map<String, Object>> checkList(
//			 @RequestParam(value="bigcate", defaultValue = "engine", required=false) String bigcate) {
//		
//		System.out.println("checkList 오버로딩 CheckController 호출"); 
//		System.out.println("대분류 : " + bigcate);
//		 
//		List<Map<String, Object>> checkMap = checkService.getCheckList(bigcate);
//		System.out.println(checkMap + " <-checkMap checkList CheckController.java");
//		 
//
//		return checkMap;
//	}
 
}
