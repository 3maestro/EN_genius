package com.cafe24.radev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.StoreMapper;
import com.cafe24.radev.vo.Store;

@Service
public class StoreService {
	@Autowired private StoreMapper storemapper;
	/**
	 * 
	 * @return
	 */
	public List<Store> getStoreList(){
		
		return storemapper.getStoreList();
	}
}
