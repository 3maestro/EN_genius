package com.cafe24.radev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.Store;

/**
 * 거래처 맵퍼
 * @author EuTteum
 *
 */
@Mapper
public interface StoreMapper {
	
	/**
	 * 거래처목록가져오기
	 * @return
	 */
	List<Store> getStoreList(String bsCode);
	
	/**
	 * 거래처등록
	 * @param store
	 */
	void storeInsertPro(Store store);
	
	/**
	 * 코드최댓값
	 * @param bsCode
	 * @return
	 */
	String getStoreCode(String bsCode);
	
	/**
	 * 거래처 한줄조회
	 * @param storeCode
	 * @return
	 */
	Store getStoreRow(String storeCode);
}
