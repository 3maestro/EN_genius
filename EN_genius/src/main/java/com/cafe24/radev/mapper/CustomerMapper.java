package com.cafe24.radev.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.vo.Customer;

@Mapper
public interface CustomerMapper {
	public List<Customer> getCustomerSelect(Map<String,String> search);
	public String getCustomerPage(Map<String,String> search);
	public void getCustomerInsert(Customer customer);
	public Customer getCustomerSelectOne(String customerCode);
	public void getCustomerUpdate(Customer customer);
	public String getCustomerInsertAjax(String name, String birth, String phone, String scode);
}
