package com.cafe24.radev.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.CategoryForCarMapper;
import com.cafe24.radev.mapper.PartMapper;
import com.cafe24.radev.vo.FirstCategoryForCar;
import com.cafe24.radev.vo.Part;
import com.cafe24.radev.vo.PartGuide;
import com.cafe24.radev.vo.SecondCategoryForCar;

@Service
public class PartService {
	@Autowired private PartMapper partMapper;
	@Autowired private CategoryForCarMapper categoryMapper;
	//현제 날짜정보
	SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
	Calendar time = Calendar.getInstance();
	String nowDate = format.format(time.getTime());
	HttpSession session;
	String bsCode /* = (String)session.getAttribute("SCODE") */;
	List<Part> list = null;

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
		String partWrite = (String)session.getAttribute("SID");
		bsCode = (String)session.getAttribute("SCODE");
		
		//현제날짜
		String newCodeDate = nowDate.replace("-","").trim();
		newCodeDate = newCodeDate.substring(2);
		String select = "%"+newCodeDate+"%";
		String partCode = partMapper.leadCode(bsCode,select);
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
	public void partUpdateforMany(Part part, HttpSession session) {
		
		String partWrite = (String)session.getAttribute("SID");
		bsCode = (String)session.getAttribute("SCODE");
		System.out.println(partWrite+"<<sessionID/service");
		System.out.println(nowDate+"<<현재시간/service");
		
		part.setBsCode(bsCode);
		part.setPartWrite(partWrite);
		part.setPartUpdateDate(nowDate);
		
		partMapper.partUpdateforMany(part);
	}
	
	/**
	 * 그룹코드생성,
	 * 체크값정보 호출
	 * 
	 * @param partCheck
	 * @param groupCode
	 */
	public List<Part> getPartGroupList(String partCheck,String groupCode, HttpSession session) {
		System.out.println(partCheck +"getPartGroup/service");
		System.out.println(groupCode +"getPartGroup/service");
		list = new ArrayList<Part>();
		String checkValue = null;
		bsCode = (String) session.getAttribute("SCODE");
		String[] partChecks =  partCheck.split(",");
		for(int i=0 ;i<partChecks.length; i++) {
			System.out.println(i+":"+partChecks[i]);
			checkValue = partChecks[i];
			list.add(partMapper.partSelectForOrder(checkValue, bsCode));
		}
			System.out.println(list.toString()+"<담긴값");
		return list;
	}
	
	/**
	 * 코드 검색후 자동생성
	 * @return 생성시킬 코드값
	 */
	public String getGroup() {
		System.out.println("getGroup/service");
		//날짜 코드화
		String partUpdateDate = nowDate.replace("-", "").trim();
		partUpdateDate = partUpdateDate.substring(2);
		//검색코드
		String select = "%part_"+partUpdateDate+"%";
		System.out.println(select+"<<<<검색조건");
		String GroupCode = "";
		String partCode = partMapper.getGroup(select);
		System.out.println(partCode+"<1");
		if(partCode == null) {
			//없으면 1번 생성
			GroupCode += "group_part_"+partUpdateDate+"_001";
		}else {
			//값있으면 조회후+1 생성
			String[] code = partCode.split("_");
			for(int i=0 ;i<code.length; i++) {
				System.out.println(i+":"+code[i]);
			}
			//끝번호자동증가
			int codeIndex = Integer.parseInt(code[3]);
			codeIndex += 1;
			String index = String.format("%03d", codeIndex);
			System.out.println(codeIndex+"증가번호");
			System.out.println(partCode+"<2");
			//나눠났던 코드 합치기
			GroupCode = code[0];
			GroupCode += "_"+code[1];
			GroupCode += "_"+(code[2] = partUpdateDate);
			GroupCode += "_"+index;
			System.out.println(GroupCode+"그룹코드 완성");
		}
		System.out.println(GroupCode);
		
		return GroupCode;
	}
	
		/**
		 * 카트로이동시킬 부품정보/ajax
		 * @param checks
		 * @return
		 */
	public List<Part> addCart(List<String> checks, HttpSession session) {
		System.out.println(checks);
		System.out.println(checks.size());
		bsCode = (String) session.getAttribute("SCODE");
		list = new ArrayList<Part>();
		String checkValue = null;
		for(int i=0;i<checks.size();i++) {
			checkValue = checks.get(i);
		list.add(partMapper.partSelectForOrder(checkValue, bsCode)); 
		}
		return list;
	}
	
	public void partSelect(String partNumber) {
		partMapper.getData();
	}
	/*
	 * Group group = new Group(); group.setGroupCode(GroupCode);
	 * group.setGroupName("부품"); group.setGroupWrite("");
	 * group.setGroupDate(nowDate); group.setBsCode("");
	 * 
	 * 
	 * return partMapper.makeGroupCode(group);
	 */
	
}