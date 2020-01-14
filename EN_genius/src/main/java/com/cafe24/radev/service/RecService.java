package com.cafe24.radev.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.radev.mapper.CarMapper;
import com.cafe24.radev.mapper.RecMapper;
import com.cafe24.radev.vo.VoRecRegister;

@Service
public class RecService {
	
	@Autowired private RecMapper recMapper;
	
	public VoRecRegister getListAdd(String carinfo) {
		
		return recMapper.getListAdd(carinfo);
		
	}
	
	public List<VoRecRegister> getRecList(HttpSession session) {
		String bsCode=(String)session.getAttribute("SCODE"); 
		VoRecRegister recVo = null;
		String recCode;
		//정비사업소별 리스트값
		List<VoRecRegister> list = new ArrayList<VoRecRegister>();
		list = recMapper.getRecList(bsCode);
		System.out.println("서비스" + list);
		for(int i=0; i<list.size();i++) {
			//recVo에 wip번호만 담기
			recVo = list.get(i);
			recCode = recVo.getReceptionCode();
			recCode = recCode.substring(recCode.lastIndexOf("_")+1);
			recVo.setReceptionCode(recCode);
		}
		return list;
	}
	
	public VoRecRegister getRecSearch(String bsCode, String recNum ) {
		//String bsCode=(String)session.getAttribute("SCODE"); 
		
		//정비사업소별 리스트값
//		List<VoRecRegister> list = new ArrayList<VoRecRegister>();
//		list = ;
//		System.out.println("서비스" + list);
		
		return recMapper.getRecSearch(bsCode, recNum);
	}
	
	public List<VoRecRegister> getRecListCC() {
		return recMapper.getRecListCC();
	}
	
	public int getRecInsert(VoRecRegister vcreg) {
		return recMapper.getRecInsert(vcreg);
		
	}
}
