package com.cafe24.radev.pet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.pet.vo.Group;
import com.cafe24.radev.pet.vo.Part;
@Mapper
public interface PartMapper {
	/**
	 * 부품전체목록
	 * @return
	 */
	public List<Part> getPartList();
	/**
	 * 
	 * serchPartCall ajax
	 * @param partNumber
	 * @return
	 */
	public Part partSelectForOrder(String partNumber);
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
	 * 
	 * @return
	 */
	public String getCheckGroup();
	
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
	
	//public Map<String,List<String>> getPartGroupList(String checkValue);
	
}
