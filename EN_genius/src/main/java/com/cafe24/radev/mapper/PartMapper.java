package com.cafe24.radev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.Group;
import com.cafe24.radev.vo.Part;
import com.cafe24.radev.vo.PartGuide;
@Mapper
public interface PartMapper {
	/**
	 * 공업사별 부품목록
	 * @return
	 */
	public List<Part> getPartList(String bsCode);
	
	/**
	 * 
	 * serchPartCall ajax
	 * @param partNumber
	 * @return
	 */
	public Part partSelectForOrder(String partNumber,String bsCode);
	
	/**
	 * 부품등록
	 * @param parts
	 */
	public void partInsertPro(Part parts);
	
	/**
	 * 부품수량업데이트
	 * @param partValue
	 * @return
	 */
	public void partUpdateforMany(Part part);
	
	
	/**
	 * 그룹코드조회
	 * @param select
	 * @return
	 */
	public String getGroup(String select);
	
	/**
	 * 그룹코드생성
	 * @return
	 */
	public Group makeGroupCode(Group group);
	
	/**
	 * 전체부품목록
	 * @return
	 */
	List<PartGuide> getData();
	
	/**
	 * 공업사별 부품목록코드가져오기
	 * @param bsCode
	 * @return
	 */
	String leadCode(String bsCode,String select);
	
}
