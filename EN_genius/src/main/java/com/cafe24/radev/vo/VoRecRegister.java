package com.cafe24.radev.vo;

public class VoRecRegister {

	
	private String receptionCode; //접수 코드
	private String bsCode; //공업사 코드 
	private String customerCarInfoCode; //차량정보등록코드
	private String ccCode; //차량정보등록코드
	private String repairClassCode; //수리 구분 코드
	private String repairClassName;
	private String displaceMent; //접수자
	private String receptionDate; //접수 일자
	private String receptionProgress;
	private String empEdCode;
	private String empName;
	
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
	public String getCcCode() {
		return ccCode;
	}
	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}
	public String getRepairClassCode() {
		return repairClassCode;
	}
	public void setRepairClassCode(String repairClassCode) {
		this.repairClassCode = repairClassCode;
	}
	
	public String getRepairClassName() {
		return repairClassName;
	}
	public void setRepairClassName(String repairClassName) {
		this.repairClassName = repairClassName;
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
	
	public String getReceptionProgress() {
		return receptionProgress;
	}
	public void setReceptionProgress(String receptionProgress) {
		this.receptionProgress = receptionProgress;
	}
	public String getEmpEdCode() {
		return empEdCode;
	}
	public void setEmpEdCode(String empEdCode) {
		this.empEdCode = empEdCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "VoRecRegister [receptionCode=" + receptionCode + ", bsCode=" + bsCode + ", customerCarInfoCode="
				+ customerCarInfoCode + ", ccCode=" + ccCode + ", repairClassCode=" + repairClassCode
				+ ", repairClassName=" + repairClassName + ", displaceMent=" + displaceMent + ", receptionDate="
				+ receptionDate + ", receptionProgress=" + receptionProgress + ", empEdCode=" + empEdCode + ", empName="
				+ empName + "]";
	}
}
