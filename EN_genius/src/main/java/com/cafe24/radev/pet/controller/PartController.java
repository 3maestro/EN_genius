package com.cafe24.radev.pet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.pet.service.PartService;
import com.cafe24.radev.pet.vo.Part;

@Controller
public class PartController {
	@Autowired
	private PartService partService;

	/**
	 * 통계 및 최근 구입,판매부품 표시관련
	 * 
	 * @return
	 */
	@GetMapping("/partMain")
	public String partMain() {
		return "/part/partMain";
	};

	/**
	 * 부품목록(리스트)호출
	 * 그룹코드 호출
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/partList")
	public String getPartList(Model model) {
		System.out.println("파트리스트/controller");

		model.addAttribute("partList", partService.getPartList());
		
		model.addAttribute("groupCode", partService.getGroup());
		return "/part/partList";
	};

	/**
	 * 부품등록창호출 카테고리 대 분류 데이터호출
	 * 
	 * @return
	 */
	@GetMapping("/partInsert")
	public String partCate(Model model) {
		System.out.println("부품등록(카테고리호출)/컨트롤러");

		model.addAttribute("fCateList", partService.selectFristDate());

		return "/part/partInsert";
	};

	/**
	 * 부품로우하나조회 ajax selectForOrder()
	 * 
	 * @param partValue
	 * @return
	 */
	@PostMapping(value = "/serchPartCall", produces = "application/json")
	public @ResponseBody Part serchPartCall(
			@RequestParam(value = "partValue", defaultValue = "1", required = false) String partValue) {
		System.out.println("부품로우조회ajax호출/controller");
		System.out.println(partValue + "<-paramr/ajax호출/controller");

		return partService.partSelectForOrder(partValue);
	};

	/**
	 * 신규부품등록처리
	 * 
	 * @param parts
	 * @param session
	 * @return
	 */
	@GetMapping("/partInsertPro")
	public String partInsertPro(Part parts, HttpSession session) {
		// 등록자입력을 위한 세션값
		// String id = (String)session.getAttribute("userId");
		System.out.println(parts.getPartName() + "<<<부품등록값");
		partService.partInsertPro(parts);

		return "redirect:/partInsert";
	};

	/**
	 * ajax로 대분류에맞는 중분류값 호출
	 * 
	 * @param fVal
	 * @return
	 */
	@PostMapping(value = "/sCateCall", produces = "application/json")
	public @ResponseBody List<String> sCateCall(
			@RequestParam(value = "fVal", defaultValue = "engine", required = false) String firstVal) {
		System.out.println("카테고리ajax호출/컨트롤러");
		System.out.println(firstVal + "<-paramr/ajax호출/컨트롤러");

		return partService.selectSecondDate(firstVal);
	};

	/**
	 * 부품주문호출 파트번호하나로 한로우조회 1품목 리스트목록에서 주문으로 넘어갈때 list -> order
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/partListToOrder")
	public String partSelectForOrder(Model model, @RequestParam(value = "partCheck") String partNumber) {
		System.out.println(partNumber + "<select for order/controller");

		model.addAttribute("partRow", partService.partSelectForOrder(partNumber));

		model.addAttribute("groupCode", partService.getGroup());

		return "/part/partOrder";
	};
	/**
	 * 
	 * @param model
	 * @param partCheck
	 * @return
	 */
	@PostMapping("/partGroupToOrder")
	public String getPartGroup(Model model,@RequestParam(name = "partCheck") String partCheck,@RequestParam(name="groupCode") String groupCode) {
		System.out.println("뭉탱이데이터호출");
		System.out.println(partCheck+"<체크값들");
		System.out.println(groupCode+"<코드값");
		
		model.addAttribute("checkPartList",partService.getPartGroup(partCheck,groupCode));
		model.addAttribute("groupCode", partService.getGroup());
		
		return "/part/partOrder";
	}

	/**
	 * 부품주문호출 신규부품 주문시
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/partOrder")
	public String partorder(Model model) {
		model.addAttribute("groupCode", partService.getGroup());
		return "/part/partOrder";
	};

	/**
	 * 부품목록에서 부품견적 사용파트넘버가지고이동
	 * 
	 * @return
	 */
	@GetMapping("/partListToEstimate")
	public String setPartListToEstimate(Model model, @RequestParam(value = "partCheck") String partCheck) {
		System.out.println(partCheck + "<<푸붐체크값");
		model.addAttribute("groupCode", partService.getGroup());
		
		return "/part/partEstimate";
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/partEstimate")
	public String setPartEstimate() {
		
		return "/part/partEstimate";
	}

	/**
	 * 부품업데이트 partInsert.html
	 * 
	 * @param part
	 * @return
	 */
	@GetMapping("/partUpdate")
	public String partUpdate(Part part) {
		System.out.println("업데이트");
		partService.partUpdateforMany(part);
		return "redirect:/partList";
	}
}
