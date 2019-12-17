package com.cafe24.radev.cyj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.radev.cyj.vo.Customer;

@Mapper
public interface CustomerMapper {
	public List<Customer> getCustomerList();
	public void getCustomerInsert(Customer customer);
	public void getCustomerSelect(Customer customer);
	public void getCustomerUpdate(Customer customer);
	public String getCustomerInsertAjax(String name, String birth, String phone);
}
