package com.cafe24.radev.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.radev.service.RecService;
import com.cafe24.radev.vo.VoRecRegister;


@Controller
public class RecController {
	
	@Autowired private RecService recService;
	
	@GetMapping("repHistory")
	public String repHistory() {
		System.out.println("과거 정비 이력 조회");
		return "receptionregister/repHistory";
	}
	
	@GetMapping("carRecallInfo")
	public String carRecallInfo() {
		System.out.println("차량 리콜 조회");
		return "receptionregister/carRecallInfo";
	}
	
	@PostMapping("recList")
	public String register(VoRecRegister vcreg) {
		System.out.println("접수 등록");
		
		recService.getRecInsert(vcreg);
		
		return "redirect:recList";
		
	}
	
	
	@GetMapping("recRegister")
	public String register(Model model) {
		
		
		return "receptionregister/recRegister";
	}
	
	
	@GetMapping("recList")
	public String recList(Model model,HttpSession session) {
			
		List<VoRecRegister> recList = recService.getRecList(session);
		
		model.addAttribute("vorecreg", recList);
			System.out.println(recList +"접수 리스트 값 확인");
		
		
		return "receptionregister/recList";
	}
	
	
	/* 작업지시서 샘플 만드는 중
	 * @GetMapping("dustmq") public String dustmq(Model model) {
	 * 
	 * 
	 * 
	 * 
	 * return "receptionregister/dustmq"; }
	 */
}
