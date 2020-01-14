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
import com.cafe24.radev.service.RecService;
import com.cafe24.radev.service.StoreService;
import com.cafe24.radev.vo.Part;
import com.cafe24.radev.vo.PartEsimate;

@Controller
public class PartController {
	@Autowired
	private PartService partService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private RecService recSevice;
	
	String many = "";
	
	/**
	 * 접수번호찾기 ajax
	 * @param serchRecep
	 * @param session
	 * @return
	 */
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
	 * @param fVal(firstValue)
	 * @return
	 */
	@PostMapping(value = "/part/sCateCall", produces = "application/json")
	public @ResponseBody List<String> sCateCall(
			@RequestParam(value = "fVal", defaultValue = "0", required = false) String firstVal) {
		System.out.println("카테고리ajax호출/컨트롤러");
		System.out.println(firstVal + "<-paramr/ajax호출/컨트롤러");

		return partService.selectSecondData(firstVal);
	};
	
	/**
	 * 부품정보를가지고 부품구매로이동
	 * 0:구매 , 1:판매
	 * @param model
	 * @param partCheck
	 * @return
	 */
	@PostMapping("/part/partOrder")
	public String getBuyPartGroup(Model model,@RequestParam(name = "partCheck", required = false) String partNumber,HttpSession session) {
		System.out.println(partNumber+"<체크값들");
		partNumber.indexOf(",");
		if(partNumber != null) {
			many=null;
			model.addAttribute("checkPartList",partService.getPartGroupList(partNumber, session,many));
			model.addAttribute("groupCode", partService.getGroup(0,session));
		}
		model.addAttribute("store", storeService.getStoreList(session));
		return "/part/partOrder";
	}

	/**
	 * 부품주문호출 신규부품 주문시
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/part/partOrder")
	public String partOrder(Model model,HttpSession session) {
		model.addAttribute("store", storeService.getStoreList(session));
		model.addAttribute("groupCode", partService.getGroup(0,session));
		return "/part/partOrder";
	};
	
	/**
	 * 부품수량업데이트 partInsert.html
	 * @param part
	 * @return
	 */
	@GetMapping("/part/partUpdate")
	public String partUpdate(Part part,HttpSession session) {
		System.out.println("업데이트");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(part.getPartMany());
		
		partService.partUpdateforMany(part,session,"plus");
		
		return "redirect:/part/partList";
	}

	
	/**
	 * 부품저장 ajax
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
	 * 일반구매
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/part/orderDoc")
	public String order(Model model, HttpSession session) {
		System.out.println("발주서");
		model.addAttribute("info", partService.factoryInfo(session));
		model.addAttribute("docNo", partService.getDocNo(0, session));
		return"/document/documentByOrder";
	}
	
	/**
	 * 부품값가지고 발주서
	 * @param model
	 * @param session 
	 * @return
	 */
	@PostMapping("/part/orderDoc")
	public String order(Model model, HttpSession session ,Part part, @RequestParam(name = "check", required = false)String check,
			@RequestParam(name = "partMany", required = false)String many,@RequestParam(name="sCheck", required = true)String storeCode) {
		System.out.println("발주서");
		
		//거래처정보
		if(storeCode != null) {
			System.out.println(storeCode+" : 거래처코드");
			System.out.println("거래처정보");
			model.addAttribute("store", storeService.getStoreRow(storeCode));
		}
		//부품정보
		many = part.getPartMany();
		many = many.replace("0","");
		System.out.println(many+"<<입력갯수");
		if(part != null && "".equals(part.getPartNumber())) {
			//System.out.println("단일값문서");
			//System.out.println(part.getPartName()+"1개");
			String partNumber = part.getPartNumber();
			part = partService.partSelectForOrder(partNumber, session);
			part.setPartMany(many);
			model.addAttribute("part", part );
		}else if(check != null) {
			//System.out.println("다중값문서");
			model.addAttribute("part", partService.getPartGroupList(check,session,many));
		}
		//사업장정보
		model.addAttribute("info", partService.factoryInfo(session));
		//문서번호
		model.addAttribute("docNo", partService.getDocNo(0, session));

		return"/document/documentByOrder";
	}

	/**
	 * list에서
	 * 부품견적으로 이동
	 * @param model
	 * @param partCheck
	 * @param groupCode
	 * @return
	 */
	@PostMapping("/part/partEstimate")
	public String getSellPartGroup(Model model,@RequestParam(name = "partCheck") String partCheck,HttpSession session) {
		System.out.println(partCheck+"<체크값들");
		
		//현제 접수목록
		model.addAttribute("recNum",recSevice.getRecList(session));
		model.addAttribute("recMany",recSevice.getRecList(session).size());
		if(partCheck!=null) {
			//부품정보
			many=null;
			model.addAttribute("checkPartList",partService.getPartGroupList(partCheck, session,many));
		}
		return "/part/partEstimate";
	}
	
	/**
	 * 부품견적문서
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("/part/estimateDoc")
	public String estimateDoc(Model model,HttpSession session,Part part) {
		
		//담당자
		String emp = (String)session.getAttribute("SNAME");
		model.addAttribute("emp", emp );
		//부품정보
		String partCheck = part.getPartNumber();
		many = part.getPartMany();
		List<Part> list = partService.getPartGroupList(partCheck, session, many);
		Part sPart = list.get(0);
		if(sPart==null) {
			model.addAttribute("part", partService.getPartGroupList(part, session, many));
		}
		
		model.addAttribute("part", list);
		//그룹코드
		model.addAttribute("groupCode", partService.getGroup(1,session));
		//사업장정보
		model.addAttribute("info", partService.factoryInfo(session));
		//문서번호
		model.addAttribute("docNo", partService.getDocNo(1, session));
		
		return "/document/documentByEstimate";
	}
	/**
	 * main에서
	 * 부품견적문서로이동
	 * @return
	 */
	@GetMapping("/part/estimate")
	public String estimateDoc(Model model,HttpSession session) {
		//현제접수목록
		model.addAttribute("recNum",recSevice.getRecList(session));
		//그룹코드
		model.addAttribute("groupCode", partService.getGroup(1,session));
		//담당자
		String emp = (String)session.getAttribute("SNAME");
		model.addAttribute("emp", emp );
		//사업장정보
		model.addAttribute("info", partService.factoryInfo(session));
		//문서번호
		model.addAttribute("docNo", partService.getDocNo(1, session));
		return "/document/documentByEstimate";
	}
	
	/**
	 * 판매등록
	 * @param partDoc
	 * @param session
	 * @param gCode
	 * @return
	 */
	@PostMapping("/part/estimatePro")
	public String estimatePro(PartEsimate partDoc,HttpSession session,@RequestParam(name="groupCode")String gCode) {
		Part part = new Part();
		
		//partService.addGrCode(gCode, session);
		int s = partDoc.getPartNumber().indexOf(",");
		if(s == -1) {
			partService.estimatePro(partDoc, session, gCode);
			//-수량업데이트
			part.setPartNumber(partDoc.getPartNumber());
			part.setPartMany(partDoc.getPartMany());
			partService.partUpdateforMany(part, session,"minus");
		}else{
			System.out.println("두개!!!!!!");
			System.out.println(partDoc.toString());
			String aNum[] = partDoc.getPartNumber().split(",");
			String aMany[] = partDoc.getPartMany().split(",");
			String aPrice[] = partDoc.getPartPrice().split(",");
			String aDec[] = partDoc.getEsDec().split(",");
			
			for(int i=0; i<aNum.length; i++) {
				String num = aNum[i];
				String many = aMany[i];
				String price = aPrice[i];
				String dec = aDec[i];
				
				partDoc.setPartNumber(num);
				partDoc.setPartMany(many);
				partDoc.setPartPrice(price);
				partDoc.setEsDec(dec);
				//System.out.println(partDoc.toString()+":"+i+"번째객체");
				partService.estimatePro(partDoc, session, gCode);
				part.setPartNumber(num);
				part.setPartMany(many);
				partService.partUpdateforMany(part, session,"minus");
			}
			
		}
		return "redirect:/part/pEstiList";
	}
	
	/**
	 * 판매목록
	 */
	@GetMapping("/part/pEstiList")
	public String esList(Model model,HttpSession session) {
		//전체보기
		
		
		//상세보기
		
		
		return "/part/pEstiList";
	}
	
	/**
	 * 최종견적서
	 * 
	 * @return
	 */
	@GetMapping("/part/reciptDoc")
	public String recipt(Model model,HttpSession session) {
		
		//사업장정보
		model.addAttribute("info", partService.factoryInfo(session));
		//문서번호
		model.addAttribute("docNo", partService.getDocNo(0, session));
		return"/document/doucmentByTotalRecitp";
	}
	/**
	 * 
	 * 최종견적문서 
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("/part/reciptDoc")
	public String trecipt(Model model,HttpSession session) {
		//그룹코드
		model.addAttribute("groupCode", partService.getGroup(1,session));
		//사업장정보
		model.addAttribute("info", partService.factoryInfo(session));
		//문서번호
		model.addAttribute("docNo", partService.getDocNo(0, session));
		return"/document/doucmentByTotalRecitp";
	}
	
	
	@GetMapping("/part/test")
	public String test(Model model,HttpSession session) {
		model.addAttribute("list", partService.getUsePartList(session));
		return"/part/partList2";
	}
	
	@PostMapping(value = "/part/test", produces = "application/json;charset=utf-8")
	public @ResponseBody List<Part> getList(
			HttpSession session) {
		System.out.println("partCart/ajax호출/컨트롤러");
		
		return partService.getUsePartList(session);
	};
}
