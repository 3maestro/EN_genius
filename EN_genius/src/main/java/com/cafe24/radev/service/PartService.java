package com.cafe24.radev.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.CategoryForCarMapper;
import com.cafe24.radev.mapper.PartMapper;
import com.cafe24.radev.mapper.UserMapper;
import com.cafe24.radev.vo.CarFactory;
import com.cafe24.radev.vo.FirstCategoryForCar;
import com.cafe24.radev.vo.Part;
import com.cafe24.radev.vo.PartEsimate;
import com.cafe24.radev.vo.PartGuide;
import com.cafe24.radev.vo.SecondCategoryForCar;

@Service
public class PartService {
	@Autowired private PartMapper partMapper;
	@Autowired private CategoryForCarMapper categoryMapper;
	@Autowired private UserMapper userMapper;
	
	//현제 날짜정보
	SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
	Calendar time = Calendar.getInstance();
	String nowDate = format.format(time.getTime());
	String bsCode /* = (String)session.getAttribute("SCODE") */;
	List<Part> list = null;
	String partWrite = null;
	
	/**
	 * 부품전체목록조회
	 * @return
	 */
	public List<PartGuide> getPartList(){
		
		return partMapper.getData();
	}
	
	/**
	 * 공업사별부품전체목록조회
	 * @return
	 */
	public List<Part> getUsePartList(HttpSession session){
		bsCode = (String)session.getAttribute("SCODE");
		list = new ArrayList<Part>();
		
		list=partMapper.getPartList(bsCode);
		if(list.size()==0) {
			list=null;
			return list;
		}
		return list;
	}
	
	/**
	 * 목록에서 리스트로 이동시 따라가는정보
	 * 로우하나 조회
	 * @param partNumber
	 * @return
	 */
	public Part partSelectForOrder(String partNumber , HttpSession session) {
		System.out.println("partSelectForOrder/Service");
		bsCode=(String)session.getAttribute("SCODE");
		return partMapper.partSelectForOrder(partNumber,bsCode);
	}
	
	/**
	 * 부품등록시 대분류선택을 위한 데이터조회 
	 * @return
	 */
	public List<FirstCategoryForCar> selectFristData(){
		System.out.println("대분류목록/service");
		
		
		return categoryMapper.getFirstCateList();
	}
	
	/**
	 * 부품등록시 중분류선택을 위한 데이터조회(Ajax)
	 * @return
	 */
	public List<String> selectSecondData(String fVal){
		System.out.println("중분류목록/service");
		List<SecondCategoryForCar> sCateList = new ArrayList<SecondCategoryForCar>();
		List<String> sCateNameList = new ArrayList<String>();
		sCateList = categoryMapper.getSecondCateList(fVal);
		for(int i=0; i<sCateList.size(); i++) {
			SecondCategoryForCar sCateVO = sCateList.get(i);
			String sCate = sCateVO.getSecondCateName();
			sCateNameList.add(sCate);
		}
		return sCateNameList;
	}
	
	/**
	 * 신규부품등록
	 * @param parts
	 */
	public void partInsertPro(Part parts, HttpSession session) {
		System.out.println("partInsertPro/Service");
		System.out.println(nowDate+"<<현재시간/service");
		bsCode = (String)session.getAttribute("SCODE");
		partWrite = (String)session.getAttribute("SID");
		//직원코드 세션
		if(partWrite == null) {
			partWrite = (String)session.getAttribute("ECODE");
		}
		//현제날짜
		String newCodeDate = nowDate.replace("-","").trim();
		newCodeDate = newCodeDate.substring(2);
		String select = "%"+newCodeDate+"%";
		String partCode = partMapper.getPartCode(bsCode,select);
		if(partCode == null) {
			//없으면 1번 생성
			partCode = "pa_"+bsCode+"_"+newCodeDate+"00001";
		}else {
			String codeDate = partCode.substring(9);
			int codeNum = Integer.parseInt(codeDate.substring(6));
			codeNum += 1;
			String index = String.format("%05d", codeNum);
			
			partCode="pa_"+bsCode+"_"+newCodeDate+(index);
			
		}
		System.out.println(partCode+"//완성");
		
		parts.setPartCode(partCode);
		parts.setPartWrite(partWrite);
		parts.setPartUpdateDate(nowDate);
		parts.setBsCode(bsCode);
		
		partMapper.partInsertPro(parts);
	}
	
	/**
	 * 부품수량업데이트
	 */
	public void partUpdateforMany(Part part, HttpSession session ,String com) {
		
		partWrite = (String)session.getAttribute("SID"); 
		if(partWrite == null) {
			partWrite = (String)session.getAttribute("ECODE");
		}
		bsCode = (String)session.getAttribute("SCODE");
		System.out.println(partWrite+"<<sessionID/service");
		System.out.println(nowDate+"<<현재시간/service");
		
		part.setBsCode(bsCode);
		part.setPartWrite(partWrite);
		part.setPartUpdateDate(nowDate);
		
		
		Map<String,Object>partMap = new HashMap<String,Object>();
		partMap.put("part",part);
		if(com.equals("minus")) {
			partMap.put("com", com );
		}
		partMapper.partUpdateforMany(partMap);
	}
	
	/**
	 * 다중값
	 * 
	 * @param partCheck
	 */
	public List<Part> getPartGroupList(String partCheck,HttpSession session,String many) {
		System.out.println(partCheck +"getPartGroup/service");
		
		list = new ArrayList<Part>();
		String checkValue = null;
		String rowMany = null;
		bsCode = (String) session.getAttribute("SCODE");
		String[] partChecks =  partCheck.split(",");
		String[] manys=null;
		if(many!=null) {
			manys =  many.split(",");
		}
		
		for(int i=0 ;i<partChecks.length; i++) {
			//System.out.println(i+":"+partChecks[i]);
			checkValue = partChecks[i];
			Part part = partMapper.partSelectForOrder(checkValue, bsCode);
			if(manys!= null) {
				//현재수량
				if(manys.length > 0) {
					rowMany = manys[i];
					//System.out.println(rowMany+": "+i);
					part.setPartMany(rowMany);
				}
			}
			list.add(part);
		}

		return list;
	}
	
	/**
	 * 신규부품시 
	 * @param part
	 * @param session
	 * @param many
	 * @return
	 */
	public List<Part> getPartGroupList(Part part,HttpSession session,String many){
		System.out.println(part.getPartName()+"<<<<<new");
		list = new ArrayList<Part>();
		list.add(part);
		return list;
	}
	/**
	 * 코드 검색후 자동생성
	 * @return 생성시킬 코드값
	 */
	public String getGroup(int a, HttpSession session) {
		System.out.println("getGroup/service");
		//날짜 코드화
		String partUpdateDate = nowDate.replace("-", "").trim();
		partUpdateDate = partUpdateDate.substring(2);
		//검색코드
		String select = null;
		bsCode = (String) session.getAttribute("SCODE");
		if(a==0) {
			//0일때 구매	
			select = "%partBuy_";
		}else if(a==1) {
			//1일때 판매
			select = "%partSell_";
		}
		select += bsCode+"_"+partUpdateDate+"%";
		//System.out.println(select+"<<<<검색조건");
		String GroupCode = "";
		String partCode = partMapper.getGroup(select);
		//System.out.println(partCode+"<1");
		if(partCode == null) {
			//없으면 1번 생성
			GroupCode += "groupPart";
			//0일때 구매
			if(a==0) {
				System.out.println("구매");
				GroupCode += "Buy_";
			}else if(a==1) {
			//1일때 판매
				System.out.println("판매");
				GroupCode += "Sell_";
			}
			GroupCode += bsCode+"_"+partUpdateDate;
			GroupCode += "_001";
		}else {
			//값있으면 조회후+1 생성
			String[] code = partCode.split("_");
			for(int i=0 ;i<code.length; i++) {
				//System.out.println(i+":"+code[i]);
			}
			//끝번호자동증가
			int codeIndex = Integer.parseInt(code[3]);
			codeIndex += 1;
			String index = String.format("%03d", codeIndex);
			//System.out.println(codeIndex+"증가번호");
			//System.out.println(partCode+"<2");
			//나눠났던 코드 합치기
			GroupCode = code[0];
			GroupCode += "_"+code[1];
			GroupCode += "_"+(code[2] = partUpdateDate);
			GroupCode += "_"+index;
			System.out.println(GroupCode+"그룹코드 완성");
		}
		//System.out.println(GroupCode);
		
		return GroupCode;
	}
	/**
	 * 카트로이동시킬 부품정보/ajax
	 * @param checks
	 * @return
	 */
	public List<Part> addCart(List<String> checks, HttpSession session) {
		//System.out.println(checks);
		//System.out.println(checks.size());
		bsCode = (String) session.getAttribute("SCODE");
		list = new ArrayList<Part>();
		String checkValue = null;
		for(int i=0;i<checks.size();i++) {
			checkValue = checks.get(i);
		list.add(partMapper.partSelectForOrder(checkValue, bsCode)); 
		}
		return list;
	}
	
	/**
	 * 기준데이터
	 * @param partNumber
	 */
	public void partSelect(String partNumber) {
		partMapper.getData();
	}
	
	/**
	 * 공업사리스트에서 세션값에 맞는 정보
	 * @param session
	 * @return
	 */
	public CarFactory factoryInfo(HttpSession session){
		System.out.println("정보 서비스");
		List<CarFactory> bsList = new ArrayList<CarFactory>();
		bsList = userMapper.carFactoryList();
		bsCode = (String)session.getAttribute("SCODE");
		CarFactory factoryInfo = new CarFactory();
		
		int index=0;
		for(int i=0; i<bsList.size(); i++) {
			factoryInfo = bsList.get(i);
			if(factoryInfo.getBsCode().equals(bsCode)) {
				//System.out.println(i+"몇번째에 담김");
				index = i;
				break;
			}
			factoryInfo = bsList.get(index);
		}
		
		factoryInfo.setBsRegistration(nowDate);
		//System.out.println(factoryInfo);
		return factoryInfo;
	}
	
	/**
	 * 문서번호추출
	 * @param a
	 * @param session
	 * @return
	 */
	public String getDocNo(int a, HttpSession session) {
		String docNo = null;
		
		//groupPartBuy_200102_001
		docNo = getGroup(a, session);
		String index = docNo.substring((docNo.lastIndexOf("_")+1));
		if(a==0) {
			//구매 order 20200102 001
			docNo = "order";
		}else if(a==1) {
			//견적 
			docNo = "estimate";
		}
		docNo += nowDate.replace("-","");
		docNo += index;
		//System.out.println(docNo);
		
		//System.out.println(docNo+" : <문서코드값");
		return docNo;
	}
	
	
	/**
	 * 판매등록
	 * @param partEs
	 * @param session
	 * @param gCode
	 */
	
	public void estimatePro(PartEsimate partEs,HttpSession session,String gCode) { 
		System.out.println("판매등록"); 
		//System.out.println(gCode);
		bsCode = (String)session.getAttribute("SCODE"); 
		partWrite = (String)session.getAttribute("SID"); 
		if(partWrite == null) {
			partWrite = (String)session.getAttribute("ECODE");
		}
		//판매코드 최댓값
		String esCode="esti_";
		esCode += bsCode+"_";
		esCode += nowDate.replace("-","").substring(2); 
		String select = "%"+esCode+"%";
		String index = partMapper.getEsCode(bsCode, select); 
		if(index!=null) {
			index = index.substring(17); 
			int i = (Integer.parseInt(index)+1); 
			index = String.format("%03d", i);
		}else {
			index = "001";
		} 
		esCode += index;
		int price;
		int many;
		int itex;
		int tprice;
		partEs.setBsCode(bsCode);
		partEs.setGrCode(gCode);
		partEs.setInnitDate(nowDate); 
		partEs.setWriter(partWrite);
		price = Integer.parseInt(partEs.getPartPrice()); 
		many =Integer.parseInt(partEs.getPartMany());
		//부가세 
		itex = (int)Math.round((price*many)*0.1); 
		//공급가
		tprice = (price*many)+itex;
		partEs.setPartTex(itex); 
		partEs.setPartToPrice(tprice);
		partEs.setEsCode(esCode);
				
		partMapper.addEstimate(partEs);
	}
	
	/**
	 * 그룹코드 생성
	 * @param gCode
	 * @param session
	 */
	public void addGrCode(String gCode,HttpSession session) {
		System.out.println("::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::::::::::::::::");
		//groupPartSell_200110_001
		partWrite = (String)session.getAttribute("SID"); 
		if(partWrite == null) {
			partWrite = (String)session.getAttribute("ECODE");
		}
		bsCode = (String)session.getAttribute("SCODE"); 
		String gName = "부품구매그룹";
		System.out.println(gCode.substring(gCode.indexOf("S"),gCode.indexOf("S")+4)+"<><>");
		String sell = gCode.substring(gCode.indexOf("S"),gCode.indexOf("S")+4);
		if(sell.equals("Sell")) {
			gName = "부품판매그룹";
		}
		partMapper.addgroupCode(gCode,gName,partWrite,bsCode);
	}
}