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
	private String bsCode;	// 공업사사업장코드(FK)
	private String customerCode;	// 고객정보등록코드(FK), 고객명
	private String carProductionYear;	// 생산연식
	private String carRegistrationDate;	// 자동차등록일
	private String lastDistanceDriven;	// 마지막방문시주행거리
	private String lastVisitDate;	// 마지막방문날짜
	private String customerCarInfoWriter;	// 작성자
	private String customerCarInfoDate;	// 작성일자
	private String customerCarInfoCode; //고객차량등록정보코드(PK)
	
	private String optionGradeCode; // 차량옵션등급분류코드(PK)
	private String optionGradeName; // 차량옵션등급명
	private String ogWriter; // 차량옵션등급 작성자
	private String ogDate; // 차량옵션등급 작성일자
	private String choiceOptionCode; // 차량선택옵션목록코드(PK)
	private String choiceOptionName; // 차량선택옵션목록명
	private String coWriter; // 차량선택옵션목록 작성자
	private String coDate; // 차량선택옵션목록 작성일자
	private String lastOptionCode; // 차량선택옵션최종코드(PK)
	private String loWriter; // 최종 옵션 작성자
	private String loDate; // 최종 옵션 작성일자
	private String group_Code; //그룹화 코드
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
	public String getCarModelName() {
		return carModelName;
	}
	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
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
	public String getCustomerCarNumber() {
		return customerCarNumber;
	}
	public void setCustomerCarNumber(String customerCarNumber) {
		this.customerCarNumber = customerCarNumber;
	}
	public String getRcCode() {
		return rcCode;
	}
	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
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
	public String getCustomerCarInfoCode() {
		return customerCarInfoCode;
	}
	public void setCustomerCarInfoCode(String customerCarInfoCode) {
		this.customerCarInfoCode = customerCarInfoCode;
	}
	public String getOptionGradeCode() {
		return optionGradeCode;
	}
	public void setOptionGradeCode(String optionGradeCode) {
		this.optionGradeCode = optionGradeCode;
	}
	public String getOptionGradeName() {
		return optionGradeName;
	}
	public void setOptionGradeName(String optionGradeName) {
		this.optionGradeName = optionGradeName;
	}
	public String getOgWriter() {
		return ogWriter;
	}
	public void setOgWriter(String ogWriter) {
		this.ogWriter = ogWriter;
	}
	public String getOgDate() {
		return ogDate;
	}
	public void setOgDate(String ogDate) {
		this.ogDate = ogDate;
	}
	public String getChoiceOptionCode() {
		return choiceOptionCode;
	}
	public void setChoiceOptionCode(String choiceOptionCode) {
		this.choiceOptionCode = choiceOptionCode;
	}
	public String getChoiceOptionName() {
		return choiceOptionName;
	}
	public void setChoiceOptionName(String choiceOptionName) {
		this.choiceOptionName = choiceOptionName;
	}
	public String getCoWriter() {
		return coWriter;
	}
	public void setCoWriter(String coWriter) {
		this.coWriter = coWriter;
	}
	public String getCoDate() {
		return coDate;
	}
	public void setCoDate(String coDate) {
		this.coDate = coDate;
	}
	public String getLastOptionCode() {
		return lastOptionCode;
	}
	public void setLastOptionCode(String lastOptionCode) {
		this.lastOptionCode = lastOptionCode;
	}
	public String getLoWriter() {
		return loWriter;
	}
	public void setLoWriter(String loWriter) {
		this.loWriter = loWriter;
	}
	public String getLoDate() {
		return loDate;
	}
	public void setLoDate(String loDate) {
		this.loDate = loDate;
	}
	public String getGroup_Code() {
		return group_Code;
	}
	public void setGroup_Code(String group_Code) {
		this.group_Code = group_Code;
	}
	@Override
	public String toString() {
		return "VoCarDetail [originCode=" + originCode + ", originMain=" + originMain + ", vendorCode=" + vendorCode
				+ ", vendorName=" + vendorName + ", carClassCode=" + carClassCode + ", carClassMain=" + carClassMain
				+ ", carModelCode=" + carModelCode + ", carModelName=" + carModelName + ", cmWriter=" + cmWriter
				+ ", cmDate=" + cmDate + ", yearCarCode=" + yearCarCode + ", carModelDetail=" + carModelDetail
				+ ", sellStartYear=" + sellStartYear + ", sellEndYear=" + sellEndYear + ", ycWriter=" + ycWriter
				+ ", ycDate=" + ycDate + ", customerCarNumber=" + customerCarNumber + ", rcCode=" + rcCode + ", bsCode="
				+ bsCode + ", customerCode=" + customerCode + ", carProductionYear=" + carProductionYear
				+ ", carRegistrationDate=" + carRegistrationDate + ", lastDistanceDriven=" + lastDistanceDriven
				+ ", lastVisitDate=" + lastVisitDate + ", customerCarInfoWriter=" + customerCarInfoWriter
				+ ", customerCarInfoDate=" + customerCarInfoDate + ", customerCarInfoCode=" + customerCarInfoCode
				+ ", optionGradeCode=" + optionGradeCode + ", optionGradeName=" + optionGradeName + ", ogWriter="
				+ ogWriter + ", ogDate=" + ogDate + ", choiceOptionCode=" + choiceOptionCode + ", choiceOptionName="
				+ choiceOptionName + ", coWriter=" + coWriter + ", coDate=" + coDate + ", lastOptionCode="
				+ lastOptionCode + ", loWriter=" + loWriter + ", loDate=" + loDate + ", group_Code=" + group_Code + "]";
	}

	
}
