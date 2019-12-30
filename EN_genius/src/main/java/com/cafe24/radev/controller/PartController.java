package com.cafe24.radev.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.service.PartService;
import com.cafe24.radev.vo.Part;

@Controller
public class PartController {
	@Autowired
	private PartService partService;
	
	
	
	@PostMapping(value = "/part/serchRecepCall", produces = "application/json")
	public @ResponseBody String serchRecepCall(
			@RequestParam(value = "serchRecep", defaultValue = "0", required = false) String serchRecep,HttpSession session) {
		System.out.println("부품로우조회ajax호출/controller");
		System.out.println(serchRecep + "<-paramr/ajax호출/controller");
		String val = "{val : 2019-11-23_wip001}";
		System.out.println(val + "<-");
		return val;
	};

	/**
	 * 통계 및 최근 구입,판매부품 표시관련
	 * 
	 * @return
	 */
	@GetMapping("/part/partMain")
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
	@GetMapping("/part/partList")
	public String getPartList(Model model,HttpSession session) {
		System.out.println("파트리스트/controller");

		model.addAttribute("partList", partService.getUsePartList(session));
		
		model.addAttribute("groupCode", partService.getGroup());
		return "/part/partList";
	};

	/**
	 * 부품등록창호출 카테고리 대 분류 데이터호출
	 * part테이블 데이터호출
	 * 
	 * @return
	 */
	@GetMapping("/part/partInsert")
	public String partCate(Model model,HttpSession session) {
		System.out.println("부품등록(카테고리호출)/컨트롤러");
		//대분류 리스트
		model.addAttribute("fCateList", partService.selectFristData());
		//부품목록
		model.addAttribute("guideList", partService.getPartList());
		
		
		return "/part/partInsert";
	};

	/**
	 * 부품로우하나조회 ajax selectForOrder()
	 * 
	 * @param partValue
	 * @return
	 */
	@PostMapping(value = "/part/serchPartCall", produces = "application/json")
	public @ResponseBody Part serchPartCall(
			@RequestParam(value = "partValue", defaultValue = "1", required = false) String partNumber, HttpSession session) {
		System.out.println("부품로우조회ajax호출/controller");
		System.out.println(partNumber + "<-paramr/ajax호출/controller");
		return partService.partSelectForOrder(partNumber, session);
	};
	

	/**
	 * 신규부품등록처리
	 * 
	 * @param parts
	 * @param session
	 * @return
	 */
	@GetMapping("/part/partInsertPro")
	public String partInsertPro(Part parts, HttpSession session) {
		
		partService.partInsertPro(parts,session);

		return "redirect:/part/partInsert";
	};

	/**
	 * ajax로 대분류에맞는 중분류값 호출
	 * 
	 * @param fVal
	 * @return
	 */
	@PostMapping(value = "/part/sCateCall", produces = "application/json")
	public @ResponseBody List<String> sCateCall(
			@RequestParam(value = "fVal", defaultValue = "engine", required = false) String firstVal) {
		System.out.println("카테고리ajax호출/컨트롤러");
		System.out.println(firstVal + "<-paramr/ajax호출/컨트롤러");

		return partService.selectSecondData(firstVal);
	};

	/**
	 * 부품주문호출 파트번호하나로 한로우조회 1품목 리스트목록에서 주문으로 넘어갈때 list -> order
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/part/partListToOrder")
	public String partSelectForOrder(Model model, @RequestParam(value = "partCheck") String partNumber, HttpSession session) {
		System.out.println(partNumber + "<select for order/controller");

		model.addAttribute("partRow", partService.partSelectForOrder(partNumber , session));

		model.addAttribute("groupCode", partService.getGroup());

		return "/part/partOrder";
	};
	
	/**
	 * 다중값을가지고 부품판매로이동
	 * @param model
	 * @param partCheck
	 * @return
	 */
	@PostMapping("/part/partGroupToOrder")
	public String getBuyPartGroup(Model model,@RequestParam(name = "partCheck") String partCheck,@RequestParam(name="groupCode") String groupCode,HttpSession session) {
		System.out.println("뭉탱이데이터호출");
		System.out.println(partCheck+"<체크값들");
		System.out.println(groupCode+"<코드값");
		
		model.addAttribute("checkPartList",partService.getPartGroupList(partCheck,groupCode, session));
		model.addAttribute("groupCode", partService.getGroup());
		
		return "/part/partOrder";
	}
	
	/**
	 * 다중값을가지고 부품견적으로 이동
	 * @param model
	 * @param partCheck
	 * @param groupCode
	 * @return
	 */
	@PostMapping("/part/partGroupToEstimate")
	public String getSellPartGroup(Model model,@RequestParam(name = "partCheck") String partCheck,@RequestParam(name="groupCode") String groupCode,HttpSession session) {
		System.out.println("뭉탱이데이터호출");
		System.out.println(partCheck+"<체크값들");
		System.out.println(groupCode+"<코드값");
		
		model.addAttribute("checkPartList",partService.getPartGroupList(partCheck,groupCode, session));
		model.addAttribute("groupCode", partService.getGroup());
		
		return "/part/partEstimate";
	}

	/**
	 * 부품주문호출 신규부품 주문시
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/part/partOrder")
	public String partorder(Model model) {
		model.addAttribute("groupCode", partService.getGroup());
		return "/part/partOrder";
	};
	
	/**
	 * 부품목록에서 부품견적 사용파트넘버가지고이동
	 * 
	 * @return
	 */
	@GetMapping("/part/partListToEstimate")
	public String setPartListToEstimate(Model model, @RequestParam(value = "partCheck") String partCheck) {
		System.out.println(partCheck + "<<푸붐체크값");
		model.addAttribute("groupCode", partService.getGroup());
		
		return "/part/partEstimate";
	}

	/**
	 * 부품견적으로이동
	 * @return
	 */
	@GetMapping("/part/partEstimate")
	public String setPartEstimate() {
		
		return "/part/partEstimate";
	}

	/**
	 * 부품수량업데이트 partInsert.html
	 * @param part
	 * @return
	 */
	@GetMapping("/part/partUpdate")
	public String partUpdate(Part part,HttpSession session) {
		System.out.println("업데이트");
		partService.partUpdateforMany(part,session);
		return "redirect:/part/partList";
	}
	
	/**
	 * 부품저장
	 * @param checks
	 * @return
	 */
	@PostMapping(value = "/part/cartCall", produces = "application/json")
	public @ResponseBody List<Part> addcartCall(
		@RequestParam(value = "checkvalues[]", required = false) List<String> checks,HttpSession session) {
		System.out.println("partCart/ajax호출/컨트롤러");
		System.out.println(checks + "<-partCart/ajax호출/컨트롤러");
		
		return partService.addCart(checks,session);
	};
	/**
	 * 부품영수증
	 * 최종견적서
	 * @return
	 */
	@GetMapping("/part/test")
	public String test() {
	
		return"/part/test";
	}
	
}
