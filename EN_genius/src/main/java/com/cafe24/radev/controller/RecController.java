package com.cafe24.radev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	
	
	@PostMapping("getListAdd")
	public @ResponseBody VoRecRegister getListAdd(HttpSession session) {
		System.out.println("@#@##@#@##############");
		String carinfo = "KMHEM42BPAC202444";
		VoRecRegister voRecRegister = recService.getListAdd(carinfo);
		System.out.println("컨56" + voRecRegister);
		return voRecRegister;
	}

	@GetMapping("recList")
	public String recList(Model model, HttpSession session) {
		List<VoRecRegister> recList = recService.getRecList(session);
		List<VoRecRegister> CC = recService.getRecListCC();
		model.addAttribute("vorecreg", recList);
		model.addAttribute("CC", CC);
		System.out.println(recList +"접수 리스트 값 확인");
		return "receptionregister/recList";
	}
	
}
