package com.cafe24.radev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.RecMapper;
import com.cafe24.radev.vo.VoRecRegister;

@Service
public class RecService {
	
	@Autowired private RecMapper recMapper;
	
	public List<VoRecRegister> getRecList() {
		return recMapper.getRecList();
	}
	
	public int getRecInsert(VoRecRegister vcreg) {
		
		return recMapper.getRecInsert(vcreg);
		
	}
}
