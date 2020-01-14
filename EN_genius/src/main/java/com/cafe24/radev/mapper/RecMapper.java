package com.cafe24.radev.mapper;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.VoRecRegister;

@Mapper
public interface RecMapper {

	public VoRecRegister getListAdd(String carinfo);
	
	/**
	 * 접수 리스트 맵퍼
	 * @return
	 */
	public List<VoRecRegister> getRecList(String bsCode);
	
	public List<VoRecRegister> getRecListCC();
	
	/**
	 * 접수 등록 맵퍼
	 * @return
	 */
	public int getRecInsert(VoRecRegister vcreg);
	public VoRecRegister getRecSearch(String bsCode, String recNum);
	
}
