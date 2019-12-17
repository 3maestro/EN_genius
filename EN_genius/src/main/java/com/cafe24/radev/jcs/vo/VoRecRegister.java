package com.cafe24.radev.jcs.vo;

public class VoRecRegister {

	
	private String receptionCode; //접수 코드
	private String bsCode; //공업사 코드 
	private String customerCarInfoCode; //차량정보등록코드
	private String repairClassCode; //수리 구분 코드
	private String displaceMent; //접수자
	private String receptionDate; //접수 일자
	
	public String getReceptionCode() {
		return receptionCode;
	}
	public void setReceptionCode(String receptionCode) {
		this.receptionCode = receptionCode;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getCustomerCarInfoCode() {
		return customerCarInfoCode;
	}
	public void setCustomerCarInfoCode(String customerCarInfoCode) {
		this.customerCarInfoCode = customerCarInfoCode;
	}
	public String getRepairClassCode() {
		return repairClassCode;
	}
	public void setRepairClassCode(String repairClassCode) {
		this.repairClassCode = repairClassCode;
	}
	public String getDisplaceMent() {
		return displaceMent;
	}
	public void setDisplaceMent(String displaceMent) {
		this.displaceMent = displaceMent;
	}
	public String getReceptionDate() {
		return receptionDate;
	}
	public void setReceptionDate(String receptionDate) {
		this.receptionDate = receptionDate;
	}
	
	@Override
	public String toString() {
		return "voRecRegister [receptionCode=" + receptionCode + ", bsCode=" + bsCode + ", customerCarInfoCode="
				+ customerCarInfoCode + ", repairClassCode=" + repairClassCode + ", displaceMent=" + displaceMent
				+ ", receptionDate=" + receptionDate + "]";
	}
	
	
	
	
}
