package com.cafe24.radev.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.radev.mapper.StoreMapper;
import com.cafe24.radev.vo.Store;

@Service
public class StoreService {
	@Autowired private StoreMapper storeMapper;
	
	//현제 날짜정보
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();
		String nowDate = format.format(time.getTime());
	
	/**
	 * 거래처 리스트 호출
	 * @return
	 */
	public List<Store> getStoreList(HttpSession session){
		System.out.println("거래처목록/service");
		String bsCode = (String)session.getAttribute("SCODE");
		
		return storeMapper.getStoreList(bsCode);
	}
	
	/**
	 * 거래처코드로 한줄조회
	 * @param storeCode
	 * @return
	 */
	public Store getStoreRow(String storeCode) {
		System.out.println("거래처 한줄조회");
		
		Store store = storeMapper.getStoreRow(storeCode);
		
		return store;
	}
	
	/**
	 * 거래처등록
	 * @param store
	 * @param session
	 * @return
	 */
	public String storeInsertPro(Store store, HttpSession session) {
		System.out.println("거래처등록/service");
		String bsCode = (String)session.getAttribute("SCODE");
		store.setBsCode(bsCode);
		System.out.println(bsCode);
		
		String selectCode = "%"+bsCode+"%";
		System.out.println(bsCode+"검색값");
		
		String getCode = storeMapper.getStoreCode(selectCode);
		System.out.println(getCode);
		String storeCode = null;
		if(getCode == null) {
			storeCode = "store_"+bsCode+"_1";
		}else {
			int num = Integer.parseInt(getCode.substring(12));
			System.out.println(num);
			num += 1;
			String index = String.format("%04d", num);
			storeCode = getCode.substring(0, 12) + index;
		}
		
		System.out.println(storeCode);
		
		store.setStoreCode(storeCode);
		
		store.setStoreWtite((String)session.getAttribute("SID"));
		store.setStoreDate(nowDate);
		
		storeMapper.storeInsertPro(store);
		return null;
	}
}
