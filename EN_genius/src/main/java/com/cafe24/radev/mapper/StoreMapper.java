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
	List<Store> getStoreList();
}
