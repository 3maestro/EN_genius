package com.cafe24.radev.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.RecMapper;
import com.cafe24.radev.vo.VoRecRegister;

@Service
public class RecService {
	
	@Autowired private RecMapper recMapper;
	
	public List<VoRecRegister> getRecList(HttpSession session) {
		String bsCode=(String)session.getAttribute("SCODE"); 
		VoRecRegister recVo = null;
		String recCode;
		//정비사업소별 리스트값
		List<VoRecRegister> list = new ArrayList<VoRecRegister>();
		list = recMapper.getRecList(bsCode);
		for(int i=0; i<list.size();i++) {
			//recVo에 wip번호만 담기
			recVo = list.get(i);
			recCode = recVo.getReceptionCode();
			recCode = recCode.substring(recCode.lastIndexOf("_")+1);
			recVo.setReceptionCode(recCode);
		}
		
		return list;
	}
	
	public int getRecInsert(VoRecRegister vcreg) {
		return recMapper.getRecInsert(vcreg);
		
	}
}
