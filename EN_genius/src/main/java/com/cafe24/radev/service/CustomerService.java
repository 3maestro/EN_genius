package com.cafe24.radev.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.radev.mapper.CustomerMapper;
import com.cafe24.radev.vo.Customer;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	/********
	 * 고객 목록을 조회 하는 메소드
	 * @return 리스트 타입
	 */
	public List<Customer> getCustomerSelect(Map<String,String> search){
		List<Customer> list = customerMapper.getCustomerSelect(search);
		for(int i=0;i<list.size();i++) {
			Customer customer = new Customer();
			customer = list.get(i);
			customer.setCustomerCode(customer.getCustomerCode().replace(customer.getBsCode()+"_", ""));
			customer.setCustomerBirth(customer.getCustomerBirth().replace("-", "").substring(2));
		}
		return list;
	}
	
	/********
	 * 고객정보를 수정하기 위해서 정보를 조회하는 메소드
	 * @return 없음
	 */
	public Customer getCustomerSelectOne(String customerCode) {
		Customer customer = customerMapper.getCustomerSelectOne(customerCode);
		return customer;
	}
	
	/********
	 * 고객을 신규 등록하는 메소드
	 * @return 없음
	 */
	public void getCustomerInsert(Customer customer) {
		int t = customerMapper.getCustomerList().size()+1;
		String bsCode = "bs001";
		String eiCode = "emp002";
		String customerCode = bsCode+"_customer"+String.format("%03d", t);
		System.out.println(customerCode);
		customer.setCustomerCode(customerCode);
		customer.setBsCode(bsCode);
		customer.setEiCode(eiCode);
		customer.setCustomerMemo("-");
		System.out.println(customer);
		customerMapper.getCustomerInsert(customer);
	}
	
	/*****
	 * 고객 등록유무를 조회하는 메소드
	 * @return 고객코드
	 */
	public String getCustomerInsertAjax(String name, String birth, String phone) {
		System.out.println(name);
		System.out.println(birth);
		System.out.println(phone);
		
		String code = customerMapper.getCustomerInsertAjax(name,birth,phone);
		
		String bsCode = "bs001";
		
		if(code == null || "".equals(code)) {
			code = "미가입";
		}else {
			code=code.replace(bsCode+"_", "");
		}
		System.out.println(code);
		return code;
	}
	
	public void getCustomerUpdate(Customer customer) {
		customer.getCustomerCode();
		customerMapper.getCustomerUpdate(customer);
		
	}
}
