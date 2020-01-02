package com.cafe24.radev.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.radev.service.StoreService;
import com.cafe24.radev.vo.Store;

@Controller
public class StoreController {
	@Autowired private StoreService storeservice;
	/**
	 * 거래처 목록
	 * @return
	 */
	@GetMapping("/storeList")
	public String getStoreList(Model model,HttpSession session) {
		System.out.println("storeList/controller");
		
		model.addAttribute("storeList", storeservice.getStoreList(session));
		
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
	@PostMapping("/store/storeInsert")
	public  String storeInsertPro(Store store, HttpSession session) {
		System.out.println("등록/controller");
		storeservice.storeInsertPro(store, session);
		
//		return "redirect:/storeList";
		return null;
	}
	
}
