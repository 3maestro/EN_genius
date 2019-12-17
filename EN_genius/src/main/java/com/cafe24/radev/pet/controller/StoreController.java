package com.cafe24.radev.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.radev.pet.service.StoreService;

@Controller
public class StoreController {
	@Autowired private StoreService storeservice;
	/**
	 * 거래처 목록
	 * @return
	 */
	@GetMapping("/storeList")
	public String getStoreList(Model model) {
		System.out.println("storeList/controller");
		
		model.addAttribute("storeList", storeservice.getStoreList());
		
		return "/store/storeList";
	}
	/**
	 * 거래처
	 * 등록폼으로 이동 
	 * @return
	 */
	@GetMapping("/storeInsert")
	public  String storeInsert() {
		return "/store/storeInsert";
	}
	/**
	 * 거래처
	 * 등록처리
	 * @return
	 */
	@PostMapping("/storeInsert")
	public  String setStoreInsert() {
		return "redirect:/storeList";
	}
	
}
