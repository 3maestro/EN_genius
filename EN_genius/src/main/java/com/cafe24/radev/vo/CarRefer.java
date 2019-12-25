package com.cafe24.radev.vo;

public class CarRefer {
	private String cusCarInfoCode; 			//해당 고객 차대 번호
	private String bsCode;					//해당 고객이 등록 된 사업장코드
	private String customerCode;			//해당 고객 코드
	private String ccWageCode;				//해당 고객 차량의 배기량 코드(공임에 필요)
	private String rcCode;					//해당 고객 차종 코드
	private String customerName;			//해당 고객이름
	private String customerPhone;			//해당 고객번호
	private String lastDistanceDriven;		//해당 최근 방문 거리
	private String lastVisitDate;			//해당 최근 방문 일자
	private String customerCarNum;			//해당 고객 차량 번호
	private String originMain;				//해당 고객 차량 구분
	private String vendorName;				//해당 고객 차량 제조사
	private String carModelName;			//해당 고객 차량 모델 이름
	private String carModelDetail;			//해당 고객 차량 모델 상세 이름
	private String minCc;					//해당 고객 차량 배기량 범위 최소
	private String maxCc;					//해당 고객 차량 배기량 범위 최대
	private String standardWage;			//해당 고객 차량의 배기량에 따른 표준 공임
	private String carProductYear;			//해당 고객 차량의 생산 년도
	private String carRegiDate;				//해당 고객 차량의 등록 년도
	private String customerCarInfoWriter;	//해당 고객 챠량을 사업장에 등록한 사업장
	private String customerCarInfoDate;		//해당 고객 차량을 사업장에 등록한 날짜
	
	public String getCusCarInfoCode() {
		return cusCarInfoCode;
	}
	public void setCusCarInfoCode(String cusCarInfoCode) {
		this.cusCarInfoCode = cusCarInfoCode;
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
	public String getCcWageCode() {
		return ccWageCode;
	}
	public void setCcWageCode(String ccWageCode) {
		this.ccWageCode = ccWageCode;
	}
	public String getRcCode() {
		return rcCode;
	}
	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
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
	public String getCustomerCarNum() {
		return customerCarNum;
	}
	public void setCustomerCarNum(String customerCarNum) {
		this.customerCarNum = customerCarNum;
	}
	public String getOriginMain() {
		return originMain;
	}
	public void setOriginMain(String originMain) {
		this.originMain = originMain;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getCarModelName() {
		return carModelName;
	}
	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}
	public String getCarModelDetail() {
		return carModelDetail;
	}
	public void setCarModelDetail(String carModelDetail) {
		this.carModelDetail = carModelDetail;
	}
	public String getMinCc() {
		return minCc;
	}
	public void setMinCc(String minCc) {
		this.minCc = minCc;
	}
	public String getMaxCc() {
		return maxCc;
	}
	public void setMaxCc(String maxCc) {
		this.maxCc = maxCc;
	}
	public String getStandardWage() {
		return standardWage;
	}
	public void setStandardWage(String standardWage) {
		this.standardWage = standardWage;
	}
	public String getCarProductYear() {
		return carProductYear;
	}
	public void setCarProductYear(String carProductYear) {
		this.carProductYear = carProductYear;
	}
	public String getCarRegiDate() {
		return carRegiDate;
	}
	public void setCarRegiDate(String carRegiDate) {
		this.carRegiDate = carRegiDate;
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
		return "CarRefer [cusCarInfoCode=" + cusCarInfoCode + ", bsCode=" + bsCode + ", customerCode=" + customerCode
				+ ", ccWageCode=" + ccWageCode + ", rcCode=" + rcCode + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + ", lastDistanceDriven=" + lastDistanceDriven + ", lastVisitDate="
				+ lastVisitDate + ", customerCarNum=" + customerCarNum + ", originMain=" + originMain + ", vendorName="
				+ vendorName + ", carModelName=" + carModelName + ", carModelDetail=" + carModelDetail + ", minCc="
				+ minCc + ", maxCc=" + maxCc + ", standardWage=" + standardWage + ", carProductYear=" + carProductYear
				+ ", carRegiDate=" + carRegiDate + ", customerCarInfoWriter=" + customerCarInfoWriter
				+ ", customerCarInfoDate=" + customerCarInfoDate + "]";
	}
	
}
