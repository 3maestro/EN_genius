package com.cafe24.radev.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.service.EmployeeService;
import com.cafe24.radev.service.WageService;
import com.cafe24.radev.vo.Employee;
import com.cafe24.radev.vo.NowWork;
import com.cafe24.radev.vo.WageManHour;
import com.cafe24.radev.vo.WorkDecide;

@Controller
public class WageController {

	@Autowired private WageService wageService;
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("/work/ccStandardWage")
	public String standardWage(Model model) {
		model.addAttribute("ccWage", wageService.ccStandardWage());
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
	
	@PostMapping("/work/insertWorking")
	public String workingNow(Model model, WorkDecide workDecide) {
		System.out.println("workingNow WageController 호출");
		
		if(workDecide.equals(null) || workDecide.equals("")){
			System.out.println(workDecide + " <-workDecide workingNow WageController.java");
		}else {
			
			
	//		// 배기량별 공임 단가 구하기
	//		String ccCode = (String)session.getAttribute("CCCODE");
	//		System.out.println(ccCode + " <-ccCode workingNow WageController.java");
	//		int onePrice = wageService.getOnePrice(ccCode);
	//		System.out.println(onePrice + " <-onePrice workingNow WageController.java\"");
	//		System.out.println("workDecide workingNow WageController.java : " + workDecide);
	
			// 반복문 반복 횟수 구하기
			List<String> workDecideList = workDecide.getWageSmallName();
			  
			  //model.addAttribute("workDecide", workDecide);
			 
			/**
			 * String ccWageSmallCode = workDecide.getCcWageSmallCode(); List<WorkDecide>
			 * list = new ArrayList<WorkDecide>();
			 */
			/**
			 * form으로 넘어온 데이터들을 각각 분해 하여 vo에 setting
			 */
			NowWork nowWork = null;
			List<NowWork> list = new ArrayList<NowWork>();
			
			if(workDecideList == null || "".equals(workDecideList)) {
				System.out.println(list.size() + " <-list.size() workingNow WageController.java");
			}else{
				for(int i=0; i<workDecideList.size(); i++) {
					//String ccWageSmallCode = workDecide.getCcWageSmallCode().get(i);
					String bsCode = workDecide.getBsCode().get(i);
					String recepNum = workDecide.getReceptionCode().get(i);
					String wageSmallName = workDecide.getWageSmallName().get(i);
					String stManHour = workDecide.getManHour().get(i);
					String ccStandardWage = workDecide.getCcStandardWage().get(i);
					String stCount = workDecide.getCount().get(i);
					String workMan = workDecide.getWorkMan().get(i);
					double manHour = Double.parseDouble(stManHour);
					int onePrice = Integer.parseInt(ccStandardWage);
					int count = Integer.parseInt(stCount);
					System.out.println(bsCode + " <-bsCode");
					System.out.println(workMan + " <-workMan");
					//			System.out.println(ccWageSmallCode + " <-wageSmallCode");
					//			System.out.println(wageSmallName + " <-wageSmallName");
					//			System.out.println(manHour + " <-manHour");
					//			System.out.println(onePrice + " <-onePrice");
					//			System.out.println(count + " <-count");
					
					nowWork = new NowWork();
					//nowWork.setCcWageSmallCode(ccWageSmallCode);
					nowWork.setRecepNum(recepNum);
					nowWork.setWageSmallName(wageSmallName);
					nowWork.setManHour(manHour);
					nowWork.setOnePrice(onePrice);
					nowWork.setCount(count);
					nowWork.setWorkMan(workMan);
					nowWork.setBsCode(bsCode);
					
					list.add(nowWork);
				}
				
			}
			
			
			
	       
	
			/**
			 * setting된 vo객체를 활용하여 견적 구하기
			 */
			List<NowWork> totalList = new ArrayList<NowWork>();
			Map<String, Object> map = new HashMap<String, Object>();
			//NowWork nowWork = null;
			//String nowWorkCode = null;
			List<String> pkList = new ArrayList<String>();
			for(int i=0; i<list.size(); i++) {
				System.out.println("list 내의 데이터 추출 반복문 실행");
				
				// 랜덤 고유키 생성
	//	        UUID uuid = UUID.randomUUID();
	//	        System.out.println(uuid);
	//	 
		        // 하이픈 제외
		        String nowWorkCode = UUID.randomUUID().toString().replace("-", "");
		        System.out.println(nowWorkCode);
		        
				nowWork = list.get(i);
				System.out.println(nowWork + " <-nowWork workingNow WageController.java");
				
				// 랜덤 고유키 setting
				nowWork.setNowWorkCode(nowWorkCode);
				
				// 견적 액 = 표준 정비 시간 *단가 *수량
				int onePriceCount = nowWork.getOnePrice() * nowWork.getCount();
				int totalPrice = (int) (onePriceCount * nowWork.getManHour());
				System.out.println(totalPrice + " <-totalPrice 수량 * 단가 ");
				
				// 견적액 setting
				nowWork.setTotalPrice(totalPrice);
				System.out.println(nowWork + "견적액을 포함한 vo");
				
	//			map.put("nowWorkCode", nowWork.getNowWorkCode());
	//			map.put("wageSmallName", nowWork.getWageSmallName());
	//			map.put("manHour", nowWork.getManHour());
	//			map.put("onePrice", nowWork.getOnePrice());
	//			map.put("count", nowWork.getCount());
	//			map.put("totalPrice", nowWork.getTotalPrice());
				
				totalList.add(nowWork);
				System.out.println(totalList + " <-totalList 견적액을 포함한 list");
				
				// insert된 데이터 값만 select하기 위한 기준값(pk)
				pkList.add(nowWork.getNowWorkCode());
				System.out.println(pkList + "<-pkListpkListpkList");
				
				map.put("pkList", pkList);
				
			}
			
			//System.out.println("list workingNow WageController : " + list);
			
			//Map<String,Object> map = new HashMap<String, Object>();
			
			int result = wageService.insertWorkWage(totalList);
			
			if(result > 0) {
				model.addAttribute("workList", wageService.workList(map));
			}
		}
		return "/wage/workingList";
	}
	
	/**
	 * 접수번호로작업리스트 가져오기
	 * @return
	 */	
	@GetMapping("/work/workingNow")
	public String Working(Model model, HttpSession session) {
		System.out.println("Working  WageController 호출");
		String recNum = (String)session.getAttribute("RECNUM");
		System.out.println(recNum + " <-recNum Working  WageController.java");
		
		List<NowWork> list = wageService.getWorking(recNum);
		//System.out.println("list Working  WageController : " + list);
		
		model.addAttribute("workList", list);
		
		return "/wage/workingNow";
	}
	
	/**
	 * 직원작업현황
	 * @param model
	 * @return
	 */
	@GetMapping("/work/ViewCurrentState")
	public String employeeList(Model model, HttpSession session) {
		String bsCode = (String)session.getAttribute("SCODE");
		System.out.println("사업장코드==>"+ bsCode);
		model.addAttribute("employeeList", employeeService.employeeList(bsCode));
		model.addAttribute("dutyList", employeeService.DepartmentDutySelect(bsCode));
		System.out.println("========>"+model.addAttribute("employeeList", employeeService.employeeList(bsCode)));
		System.out.println("========"+model.addAttribute("dutyList", employeeService.DepartmentDutySelect(bsCode)));
		return "/wage/employeeWorkCurrentState";
	}
	
	/**
	 * 접수번호기준 작업 배
	 * @return
	 */
//	@PostMapping("/work/workCurrentState")
//	public @ResponseBody List<NowWork> WorkCurrentList(
//			@RequestParam(value = "recepNum", required = false) String recepNum) {
//		System.out.println("WorkCurrentList WageController호출");
//		System.out.println(recepNum + " <-recepNum 조회 하려는 접수 번호");
//		
//		List<NowWork> workCurrentList = wageService.WorkCurrentList(recepNum);
//		
//		
//		return workCurrentList;
//	}
	//@RequestParam(name = "empName", required = false)String empName
	@PostMapping(value = "/work/empAssign", produces = "application/json")
	public @ResponseBody void empAssign(@RequestParam(value = "recepNum", required = false)String recepNum, Model model) {
		System.out.println("empAssign WageController 호출");
		System.out.println(recepNum + " <-recepNum empAssign WageController.java");
		
		wageService.recEmpAssign(recepNum);
		
		//return "/wage/employeeWorkCurrentState";
	}
	
	@GetMapping("/work/wageEstimate")
	public String wageEstimate() {
		return "/wage/wageEstimateList";
	}
	

	
}
