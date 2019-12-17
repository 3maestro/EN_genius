package com.cafe24.radev.pet.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.pet.mapper.CategoryForCarMapper;
import com.cafe24.radev.pet.mapper.PartMapper;
import com.cafe24.radev.pet.vo.FirstCategoryForCar;
import com.cafe24.radev.pet.vo.Part;
import com.cafe24.radev.pet.vo.SecondCategoryForCar;

@Service
public class PartService {
	@Autowired private PartMapper partMapper;
	@Autowired private CategoryForCarMapper categoryMapper;
	//현제 날짜정보
	SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
	Calendar time = Calendar.getInstance();
	String nowDate = format.format(time.getTime());
	
	/**
	 * 부품전체목록조회
	 * @return
	 */
	public List<Part> getPartList(){
		
		return partMapper.getPartList();
	}
	/**
	 * 목록에서 리스트로 이동시 따라가는정보
	 * 로우하나 조회
	 * @param partNumber
	 * @return
	 */
	public Part partSelectForOrder(String partNumber) {
		System.out.println("partSelectForOrder/Service");
		
		return partMapper.partSelectForOrder(partNumber);
	}
	/**
	 * 부품등록시 대분류선택을 위한 데이터조회 
	 * @return
	 */
	public List<FirstCategoryForCar> selectFristDate(){
		System.out.println("대분류목록/service");
		
		return categoryMapper.getFirstCateList();
	}
	/**
	 * 부품등록시 중분류선택을 위한 데이터조회(Ajax)
	 * @return
	 */
	public List<String> selectSecondDate(String fVal){
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
	public void partInsertPro(Part parts) {
		//수정자아이디
		String partWrite = "id002";
		//수정공업사코드
		String factory = "cp002";
		System.out.println("partInsertPro/Service");
		System.out.println(nowDate+"<<현재시간/service");
		
		parts.setPartWrite(partWrite);
		parts.setPartUpdateDate(nowDate);
		parts.setFactory(factory);
		
		partMapper.partInsertPro(parts);
	}
	/**
	 * 부품수량업데이트
	 */
	public void partUpdateforMany(Part part) {
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();
		//수정자아이디
		String partWrite = "id002";
		String partUpdateDate = format.format(time.getTime());
		
		System.out.println(partUpdateDate+"<<현재시간/service");
		
		part.setPartWrite(partWrite);
		part.setPartUpdateDate(partUpdateDate);
		
		
		partMapper.partUpdateforMany(part);
	}
	
	/**
	 * 그룹코드생성,
	 * 체크값정보 호출
	 * 
	 * @param partCheck
	 * @param groupCode
	 */
//	public Map<String,Object> getPartGroup(String partCheck,String groupCode) {
	public List<Part> getPartGroup(String partCheck,String groupCode) {
		System.out.println(partCheck +"getPartGroup/service");
		System.out.println(groupCode +"getPartGroup/service");
		List<Part> checkList = new ArrayList<Part>();
		Map<String,Object> checksMap = new HashMap<String,Object>();
		String checkValue = null;
		
		String[] partChecks =  partCheck.split(",");
		for(int i=0 ;i<partChecks.length; i++) {
			System.out.println(i+":"+partChecks[i]);
			checkValue = partChecks[i];
			//checksMap.put(checkValue,partMapper.partSelectForOrder(checkValue));
			//System.out.println(i+":"+partMapper.partSelectForOrder(checkValue).toString());
			checkList.add(partMapper.partSelectForOrder(checkValue));
		}
		//System.out.println(checksMap.toString()+"<담긴값");
			System.out.println(checkList.toString()+"<담긴값");
		//return checksMap;
		return checkList;
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
			GroupCode += "group_part_"+partUpdateDate+"_1";
			
		}else {
			//값있으면 조회후+1 생성
			String[] code = partCode.split("_");
			
			for(int i=0 ;i<code.length; i++) {
				System.out.println(i+":"+code[i]);
			}
			//끝번호자동증가
			int codeIndex = Integer.parseInt(code[3]);
			codeIndex += 1;
			System.out.println(codeIndex+"증가번호");
			System.out.println(partCode+"<2");
			
			//나눠났던 코드 합치기
			GroupCode = code[0];
			GroupCode += "_"+code[1];
			GroupCode += "_"+(code[2] = partUpdateDate);
			GroupCode += "_"+codeIndex;
			System.out.println(GroupCode+"그룹코드 완성");
		}
		System.out.println(GroupCode);
		
		return GroupCode;
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