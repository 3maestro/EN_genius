package com.cafe24.radev.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.radev.service.UserService;
import com.cafe24.radev.vo.CarFactory;
import com.cafe24.radev.vo.Employee;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	/**
	 * 회원가입 클릭시 사업장등록 폼으로 이동
	 * @return
	 */
	@GetMapping("/carfactory/CarFactoryInsert")
	public String addCarFactory() {
		return "/carfactory/carFactoryInsert";
	}
	
	/**
	 * 회원가입 폼에서 받아 온 값으로 사업장 등록 처리과정	
	 * @param carFactory
	 * @param bs_docu
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/carfactory/CarFactoryInsert") 
	public String addCarFactory(CarFactory carFactory
								,@RequestParam("bs_docu") MultipartFile bs_docu
								,Model model
								){
			System.out.println("carFactory ==> " + carFactory.toString());
			System.out.println("파일====>" + bs_docu);
			if(bs_docu.equals(null)) {
				String re = "파일이 첨부되지 않아 등록처리에 실패하였습니다."; 
				model.addAttribute("lo", re);
			}else {				
				int r = userService.addCarFactory(carFactory);
				System.out.println(r + "r 결과 값");
				userService.addDocumentFile(bs_docu);
			}
		return "redirect:/login/login";
	}
	/**
	 * 사업장 리스트
	 * @return
	 */
	@GetMapping("/carfactory/CarFactorySelect")
	public String carFactoryList(Model model) {
		userService.carFactoryList();
		model.addAttribute("carfactorylist", userService.carFactoryList());
		return "/carfactory/carFactoryList";
	}
	/**
	 * 사업장 검색
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/carfactory/carFactorySearch", produces = "application/json")
	public @ResponseBody List<CarFactory> carFactorySearch(@RequestParam(value="sk") String sk,
									@RequestParam(value="sv") String sv,
									Model model) {
		System.out.println("====>"+sk);
		System.out.println("====>"+sv);
		List<CarFactory> carFactoryList = userService.carFactorySearch(sk,sv);
		return carFactoryList;
	}

	@GetMapping("/carfactory/approvalSelect") 
	public String approvalList(@RequestParam(value="approval")String approval, Model model){ 
		System.out.println("--------------------->"+approval);
		model.addAttribute("carfactorylist", userService.approvalList(approval));
		return "/carfactory/carFactoryList"; 
	}
	 
	/**
	 * 사업장 리스트 내 팝업으로 서류 이미지 띄우기
	 * @param bsCode
	 * @return
	 */
	@PostMapping("/carfactory/selectImage")
	public @ResponseBody String selectImage(@RequestParam(value = "bsCode") String bsCode) {
		System.out.println("코드값" + bsCode);
		System.out.println("====>" + userService.selectImage(bsCode));		
		return userService.selectImage(bsCode);
	}
	/**
	 * 사업장 리스트에서 체크한 값들 승인처리
	 * @param bsCode
	 * @return
	 */

	  @PostMapping("/carfactory/approvalCheck") 
	  public @ResponseBody String approvalCheck(@RequestParam(value="checkArray") List<String> checkArray, HttpSession session) { 		  
		  System.out.println(checkArray);
		  String bsWriter = (String)session.getAttribute("SCODE");
		  Map<String, Object> map = new HashMap<String, Object>();
		  map.put("bsWriter", bsWriter);
		  map.put("list", checkArray);		  
		  userService.approvalCheck(map); 
		  return "";
	  }
	  
	  /**
	   * 사업장 리스트에서 체크한 값들 승인거절
	   * @param checkArray
	   * @return
	   */
	  @PostMapping("/carfactory/approvalRefusal") 
	  public @ResponseBody String approvalRefusal(@RequestParam(value="checkArray") List<String> checkArray) { 		  
		  System.out.println(checkArray);
		  userService.approvalRefusal(checkArray); 
		  return "";
	  }
	 
	 
	 
/********************************************************************************************************로그인*/	
	  /**
	   * 로그인폼 화면 이동
	   * @return
	   */
	  @GetMapping("/login/loginForm")		
	  public String loingForm() {
		  return "/login/login";
	  }

	 /**
	 * 관리자 로그인처리
	 * @param carFactory
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping("/login/Adminlogin")
	public String adminLogin(CarFactory carFactory, HttpSession session, Model model) {
		System.out.println(carFactory.toString());		
		Map<String,Object> map = userService.adminLogin(carFactory);
		String re = (String)map.get("re");
		CarFactory c = (CarFactory)map.get("login");	
	
		if("login".equals(re)) {
			if("관리자".equals(c.getBsWriter())) {
				session.setAttribute("SLEVEL", c.getBsLevel());
				session.setAttribute("SID", c.getBossId());
				session.setAttribute("SCODE", c.getBsCode());
			}else if("bs001".equals(c.getBsWriter())){
				model.addAttribute("lo", "관리자 로그인 창입니다");
				return "/login/login";
			}
		}else {
			model.addAttribute("lo", re);
			//session.setAttribute("lo", re);
			return "/login/login";
		}		
		return "redirect:/main/recSearchMain";
	}

	/**
	 * 사장님 로그인처리
	 * @param carFactory
	 * @param session
	 * @return
	 */
	@PostMapping("/login/Bosslogin")
	public String bossLogin(CarFactory carFactory, HttpSession session, Model model) { 
		System.out.println(carFactory.toString());				
				
		Map<String,Object> map = userService.adminLogin(carFactory);
		System.out.println(userService.adminLogin(carFactory).toString()+"<<1번확인");
		String re = (String)map.get("re");
		CarFactory c = (CarFactory)map.get("login");	
		
		if("login".equals(re)) {
			if("bs001".equals(c.getBsWriter())) {
				session.setAttribute("SID", c.getBossId());
				session.setAttribute("SCODE", c.getBsCode());
				session.setAttribute("SNAME", c.getBossName());
				session.setAttribute("SWRITER", c.getBsWriter());
			}else if("관리자".equals(c.getBsWriter())){
				model.addAttribute("lo", "사장님 로그인 창입니다");
				return "/login/login";
			}
		}else {
			model.addAttribute("lo", re);
			return "/login/login";
		}		
		return "redirect:/main/recSearchMain";
	} 

	/**
	 * 직원 로그인처리
	 * @param employee
	 * @param session
	 * @return
	 */
	@PostMapping("/login/Employeelogin")
	public String employeeLogin(Employee employee, HttpSession session, Model model) { 
		System.out.println(employee.toString()+"<-----test");				
		
		Map<String,Object> map = userService.employeeLogin(employee);
		System.out.println(userService.employeeLogin(employee).toString()+"<<1번확인");		
		String re = (String)map.get("re");
		Employee e = (Employee)map.get("login");
		
		if(re != "login") {
			model.addAttribute("lo", re);
			return "/login/login";
		}else{
			session.setAttribute("SCODE", e.getBsCode());
			session.setAttribute("ECODE", e.getEmployeeCode());
			session.setAttribute("SNAME", e.getEmployeeName());
		}
		return "redirect:/main/recSearchMain";
	}
 
	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
	@GetMapping("/login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/loginForm";
	}
	/**
	 * ajax로 id중복체크
	 * @param bossId
	 * @return
	 */
	@PostMapping(value = "/idCheckCall", produces = "application/json")
	public @ResponseBody String idCheckCall(
			@RequestParam(value = "bossId", defaultValue = "0", required = false)String bossId
			){
		System.out.println(bossId+"<<<<<<<<-paramr/ajax호출/컨트롤러");
		
		
		return null;
	}
}
