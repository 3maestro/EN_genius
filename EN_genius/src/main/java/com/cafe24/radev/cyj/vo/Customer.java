package com.cafe24.radev.cyj.vo;

public class Customer {
	private String customerCode;
	private String bsCode;
	private String eiCode;
	private String customerSign;
	private String customerName;
	private String customerBirth;
	private String customerGender;
	private String customerPost;
	private String customerAddr;
	private String customerPhone;
	private String customerMemo;
	
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	
	public String getEiCode() {
		return eiCode;
	}
	public void setEiCode(String eiCode) {
		this.eiCode = eiCode;
	}
	
	public String getCustomerSign() {
		return customerSign;
	}
	public void setCustomerSign(String customerSign) {
		this.customerSign = customerSign;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerBirth() {
		return customerBirth;
	}
	public void setCustomerBirth(String customerBirth) {
		this.customerBirth = customerBirth;
	}
	
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	
	public String getCustomerPost() {
		return customerPost;
	}
	public void setCustomerPost(String customerPost) {
		this.customerPost = customerPost;
	}
	
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public String getCustomerMemo() {
		return customerMemo;
	}
	public void setCustomerMemo(String customerMemo) {
		this.customerMemo = customerMemo;
	}
	
	@Override
	public String toString() {
		return "Customer [customerCode=" + customerCode + ", bsCode=" + bsCode + ", eiCode=" + eiCode
				+ ", customerSign=" + customerSign + ", customerName=" + customerName + ", customerBirth="
				+ customerBirth + ", customerGender=" + customerGender + ", customerPost=" + customerPost
				+ ", customerAddr=" + customerAddr + ", customerPhone=" + customerPhone + ", customerMemo="
				+ customerMemo + "]";
	}
}
