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
	public String register(VoRecRegister voRecRegister, Model model) {
		model.addAttribute("voRecRegister", voRecRegister);
		
		return "receptionregister/recRegister";
	}
	
	
	@GetMapping("recList")
	public String recList(Model model, HttpSession session) {
		System.out.println("컨53");
		List<VoRecRegister> recList = recService.getRecList(session);
		System.out.println("@@@@@@@2222" + recList);
		List<VoRecRegister> CC = recService.getRecListCC();
		System.out.println("@@@@@@@" + CC);
		model.addAttribute("vorecreg", recList);
		model.addAttribute("CC", CC);
		System.out.println(recList +"접수 리스트 값 확인");
		return "receptionregister/recList";
	}
	
	
}
