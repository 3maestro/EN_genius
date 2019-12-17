package com.cafe24.radev.jcs.vo;

public class VoCarRegister {

	private String customerCarInfoCode;	// 고객차량정보등록코드(PK)
	private String bsCode;	// 공업사사업장코드(FK)
	private String customerCode;	// 고객정보등록코드(FK), 고객명
	private String customerName;	// 고객정보등록코드(FK), 고객명
	private String customerPhone;	// 고객정보등록코드(FK), 고객명
	private String customerCarNumber;	// 차량번호
	private String vendorCode;	// 벤더사(FK)
	private String rcCode;	// 등록증상자동차정보코드(FK), 차량명
	private String carProductionYear;	// 생산연식
	private String carRegistrationDate;	// 자동차등록일
	private String lastDistanceDriven;	// 마지막방문시주행거리
	private String lastVisitDate;	// 마지막방문날짜
	private String customerCarInfoWriter;	// 작성자
	private String customerCarInfoDate;	// 작성일자
	
	public String getCustomerCarInfoCode() {
		return customerCarInfoCode;
	}
	public void setCustomerCarInfoCode(String customerCarInfoCode) {
		this.customerCarInfoCode = customerCarInfoCode;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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
	public String getCustomerCarNumber() {
		return customerCarNumber;
	}
	public void setCustomerCarNumber(String customerCarNumber) {
		this.customerCarNumber = customerCarNumber;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getRcCode() {
		return rcCode;
	}
	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
	}
	public String getCarProductionYear() {
		return carProductionYear;
	}
	public void setCarProductionYear(String carProductionYear) {
		this.carProductionYear = carProductionYear;
	}
	public String getCarRegistrationDate() {
		return carRegistrationDate;
	}
	public void setCarRegistrationDate(String carRegistrationDate) {
		this.carRegistrationDate = carRegistrationDate;
	}
	public String getLastDistanceDriven() {
		return lastDistanceDriven;
	}
	public void setLastDistanceDriven(String lastDistanceDriven) {
		this.lastDistanceDriven = lastDistanceDriven;
	}
	public String getLastVisitDate() {
		return lastVisitDate;
	}
	public void setLastVisitDate(String lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}
	public String getCustomerCarInfoWriter() {
		return customerCarInfoWriter;
	}
	public void setCustomerCarInfoWriter(String customerCarInfoWriter) {
		this.customerCarInfoWriter = customerCarInfoWriter;
	}
	public String getCustomerCarInfoDate() {
		return customerCarInfoDate;
	}
	public void setCustomerCarInfoDate(String customerCarInfoDate) {
		this.customerCarInfoDate = customerCarInfoDate;
	}
	
	@Override
	public String toString() {
		return "VoCarRegister [customerCarInfoCode=" + customerCarInfoCode + ", bsCode=" + bsCode + ", customerCode="
				+ customerCode + ", customerName=" + customerName + ", customerPhone=" + customerPhone
				+ ", customerCarNumber=" + customerCarNumber + ", vendorCode=" + vendorCode + ", rcCode=" + rcCode
				+ ", carProductionYear=" + carProductionYear + ", carRegistrationDate=" + carRegistrationDate
				+ ", lastDistanceDriven=" + lastDistanceDriven + ", lastVisitDate=" + lastVisitDate
				+ ", customerCarInfoWriter=" + customerCarInfoWriter + ", customerCarInfoDate=" + customerCarInfoDate
				+ "]";
	}
}