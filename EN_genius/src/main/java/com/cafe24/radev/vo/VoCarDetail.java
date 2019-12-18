package com.cafe24.radev.vo;

public class VoCarDetail {

	private String originCode; // 국산/수입구분코드(PK)
	private String originMain; // 국산/수입여부
	private String vendorCode; // vendor_code(PK)
	private String vendorName; // 제조사이름
	private String carClassCode; // 차량종류구분코드(PK)
	private String carClassMain; // 차량종류명
	private String carModelCode; // 차량모델구분코드(PK)
	private String carModelName; // 모델명
	private String cmWriter; // 차량 모델 구분 작성자
	private String cmDate; // 차량 모델 구분 작성일자
	private String yearCarCode; // 연도별차량모델코드
	private String carModelDetail; // 차량상세모델명
	private String sellStartYear; // 판매시작년도
	private String sellEndYear; // 판매종료년도
	private String ycWriter; // 연도별 차량 모델 작성자
	private String ycDate; // 연도별 차량 모델 작성일자
	private String customerCarNumber; // 차량 넘버
	private String rcCode;	// 등록증상자동차정보코드(FK), 차량명
	private String carProductionYear; //자동차 등록일
	
	
	public String getCarProductionYear() {
		return carProductionYear;
	}
	public void setCarProductionYear(String carProductionYear) {
		this.carProductionYear = carProductionYear;
	}
	public String getRcCode() {
		return rcCode;
	}
	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
	}
	public String getCustomerCarNumber() {
		return customerCarNumber;
	}
	public void setCustomerCarNumber(String customerCarNumber) {
		this.customerCarNumber = customerCarNumber;
	}
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	public String getOriginMain() {
		return originMain;
	}
	public void setOriginMain(String originMain) {
		this.originMain = originMain;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getCarClassCode() {
		return carClassCode;
	}
	public void setCarClassCode(String carClassCode) {
		this.carClassCode = carClassCode;
	}
	public String getCarClassMain() {
		return carClassMain;
	}
	public void setCarClassMain(String carClassMain) {
		this.carClassMain = carClassMain;
	}
	public String getCarModelCode() {
		return carModelCode;
	}
	public void setCarModelCode(String carModelCode) {
		this.carModelCode = carModelCode;
	}
	public String getCmWriter() {
		return cmWriter;
	}
	public void setCmWriter(String cmWriter) {
		this.cmWriter = cmWriter;
	}
	public String getCmDate() {
		return cmDate;
	}
	public void setCmDate(String cmDate) {
		this.cmDate = cmDate;
	}
	public String getCarModelName() {
		return carModelName;
	}
	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}
	public String getYearCarCode() {
		return yearCarCode;
	}
	public void setYearCarCode(String yearCarCode) {
		this.yearCarCode = yearCarCode;
	}
	public String getCarModelDetail() {
		return carModelDetail;
	}
	public void setCarModelDetail(String carModelDetail) {
		this.carModelDetail = carModelDetail;
	}
	public String getSellStartYear() {
		return sellStartYear;
	}
	public void setSellStartYear(String sellStartYear) {
		this.sellStartYear = sellStartYear;
	}
	public String getSellEndYear() {
		return sellEndYear;
	}
	public void setSellEndYear(String sellEndYear) {
		this.sellEndYear = sellEndYear;
	}
	public String getYcWriter() {
		return ycWriter;
	}
	public void setYcWriter(String ycWriter) {
		this.ycWriter = ycWriter;
	}
	public String getYcDate() {
		return ycDate;
	}
	public void setYcDate(String ycDate) {
		this.ycDate = ycDate;
	}
	@Override
	public String toString() {
		return "VoCarDetail [originCode=" + originCode + ", originMain=" + originMain + ", vendorCode=" + vendorCode
				+ ", vendorName=" + vendorName + ", carClassCode=" + carClassCode + ", carClassMain=" + carClassMain
				+ ", carModelCode=" + carModelCode + ", carModelName=" + carModelName + ", cmWriter=" + cmWriter
				+ ", cmDate=" + cmDate + ", yearCarCode=" + yearCarCode + ", carModelDetail=" + carModelDetail
				+ ", sellStartYear=" + sellStartYear + ", sellEndYear=" + sellEndYear + ", ycWriter=" + ycWriter
				+ ", ycDate=" + ycDate + ", customerCarNumber=" + customerCarNumber + ", rcCode=" + rcCode
				+ ", carProductionYear=" + carProductionYear + "]";
	}
	
	
}
