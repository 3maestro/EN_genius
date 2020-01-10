package com.cafe24.radev.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.Part;
import com.cafe24.radev.vo.PartEsimate;
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
	public void partUpdateforMany(Map<String, Object> partMap);
	
	
	/**
	 * 그룹코드조회
	 * @param select
	 * @return
	 */
	public String getGroup(String select);
	
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
	String getPartCode(String bsCode,String select);
	
	/**
	 * 판매코드 최댓값
	 * @param bsCode
	 * @param select
	 * @return
	 */
	String getEsCode(String bsCode,String select);
	
	/**
	 * 판매등록
	 * @param partEs
	 */
	void addEstimate(PartEsimate partEs);
	
	/**
	 * 그룹코드생성
	 * @param gCode
	 */
	void addgroupCode(String gCode,String gName,String writer,String bsCode);
	
}
