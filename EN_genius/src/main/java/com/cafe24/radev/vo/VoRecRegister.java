package com.cafe24.radev.vo;

public class VoRecRegister {

	private String sid; //세션 아이디
	private String scode; //공업사 세션
	private String receptionCode; //접수 코드
	private String bsCode; //공업사 코드 
	private String customerCarInfoCode; //차량정보등록코드
	private String repairClassCode; //수리 구분 코드
	private String repairClassName; //수리 구분 이름
	private String reception_memo; // 접수 내용
	private String displaceMent; //접수자
	private String receptionDate; //접수 일자
	private String receptionProgress; //접수 상태
	private String empName; //직원 정보
	private String customerName; //고객 이름
	private String customerPhone; //고객 번호
	private String carModelDetail; //차량 상세
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
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
	public String getRepairClassName() {
		return repairClassName;
	}
	public void setRepairClassName(String repairClassName) {
		this.repairClassName = repairClassName;
	}
	public String getReception_memo() {
		return reception_memo;
	}
	public void setReception_memo(String reception_memo) {
		this.reception_memo = reception_memo;
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
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCarModelDetail() {
		return carModelDetail;
	}
	public void setCarModelDetail(String carModelDetail) {
		this.carModelDetail = carModelDetail;
	}
	@Override
	public String toString() {
		return "VoRecRegister [sid=" + sid + ", scode=" + scode + ", receptionCode=" + receptionCode + ", bsCode="
				+ bsCode + ", customerCarInfoCode=" + customerCarInfoCode + ", repairClassCode=" + repairClassCode
				+ ", repairClassName=" + repairClassName + ", reception_memo=" + reception_memo + ", displaceMent="
				+ displaceMent + ", receptionDate=" + receptionDate + ", receptionProgress=" + receptionProgress
				+ ", empName=" + empName + ", customerName=" + customerName + ", customerPhone=" + customerPhone
				+ ", carModelDetail=" + carModelDetail + "]";
	}
	
	
	
}
