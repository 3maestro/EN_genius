package com.cafe24.radev.vo;

public class VoCarDetail {

	private String sid;
	private String scode;
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
	private String customerPhone; 
	private String customerName; 
	
	private String carProductionYear;	// 생산연식
	private String carRegistrationDate;	// 자동차등록일
	private String lastDistanceDriven;	// 마지막방문시주행거리
	private String lastVisitDate;	// 마지막방문날짜
	private String customerCarRegWriter;	// 작성자
	private String customerCarRegDate;	// 작성일자
	private String customerCarRegCode; //고객차량등록정보코드(PK)
	
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
	
	private String fuelCode; // 연료구분코드(PK)
	private String fuelType; // 연료종류
	private String fuelWriter; // 연료 작성자
	private String fuelDate; // 연료 작성일자
	private String feCode; // 연료별엔진구분코드(PK)
	private String engineType; // 엔진종류
	private String feWriter; // 엔진 작성자
	private String feDate; // 엔진 작성일자
	private String tmCode; // 미션구분코드(PK)
	private String tmType; // 미션종류
	private String tmWriter; // 작성자
	private String tmDate; // 작성일자
	private String dwCode; // 구동방식구분코드(PK)
	private String dwType; // 구동방식종류
	private String dwWriter; // 작성자
	private String dwDate; // 작성일자
	private String ptCode; // 파워트레인코드(PK)
	private String engineForm; // 엔진형식
	private String ptWriter; // 작성자
	private String ptDate; // 작성일자
	
	private String colorBigCode; // 외장색상대분류코드(PK)
	private String colorBigName; // 외장색상대분류명
	private String cbWriter; // 외장색 대분류 작성자
	private String cbDate; // 외장색 대분류 작성일자
	private String colorMidCode; // 외장색중분류코드(PK)
	private String colorMidName; // 외장색중분류명
	private String cmdWriter; // 외장색 중분류 작성자
	private String cmdDate; // 외장색 중분류 작성일자
	
	
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
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
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
	public String getCustomerCarRegWriter() {
		return customerCarRegWriter;
	}
	public void setCustomerCarRegWriter(String customerCarRegWriter) {
		this.customerCarRegWriter = customerCarRegWriter;
	}
	public String getCustomerCarRegDate() {
		return customerCarRegDate;
	}
	public void setCustomerCarRegDate(String customerCarRegDate) {
		this.customerCarRegDate = customerCarRegDate;
	}
	public String getCustomerCarRegCode() {
		return customerCarRegCode;
	}
	public void setCustomerCarRegCode(String customerCarRegCode) {
		this.customerCarRegCode = customerCarRegCode;
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
	public String getFuelCode() {
		return fuelCode;
	}
	public void setFuelCode(String fuelCode) {
		this.fuelCode = fuelCode;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getFuelWriter() {
		return fuelWriter;
	}
	public void setFuelWriter(String fuelWriter) {
		this.fuelWriter = fuelWriter;
	}
	public String getFuelDate() {
		return fuelDate;
	}
	public void setFuelDate(String fuelDate) {
		this.fuelDate = fuelDate;
	}
	public String getFeCode() {
		return feCode;
	}
	public void setFeCode(String feCode) {
		this.feCode = feCode;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public String getFeWriter() {
		return feWriter;
	}
	public void setFeWriter(String feWriter) {
		this.feWriter = feWriter;
	}
	public String getFeDate() {
		return feDate;
	}
	public void setFeDate(String feDate) {
		this.feDate = feDate;
	}
	public String getTmCode() {
		return tmCode;
	}
	public void setTmCode(String tmCode) {
		this.tmCode = tmCode;
	}
	public String getTmType() {
		return tmType;
	}
	public void setTmType(String tmType) {
		this.tmType = tmType;
	}
	public String getTmWriter() {
		return tmWriter;
	}
	public void setTmWriter(String tmWriter) {
		this.tmWriter = tmWriter;
	}
	public String getTmDate() {
		return tmDate;
	}
	public void setTmDate(String tmDate) {
		this.tmDate = tmDate;
	}
	public String getDwCode() {
		return dwCode;
	}
	public void setDwCode(String dwCode) {
		this.dwCode = dwCode;
	}
	public String getDwType() {
		return dwType;
	}
	public void setDwType(String dwType) {
		this.dwType = dwType;
	}
	public String getDwWriter() {
		return dwWriter;
	}
	public void setDwWriter(String dwWriter) {
		this.dwWriter = dwWriter;
	}
	public String getDwDate() {
		return dwDate;
	}
	public void setDwDate(String dwDate) {
		this.dwDate = dwDate;
	}
	public String getPtCode() {
		return ptCode;
	}
	public void setPtCode(String ptCode) {
		this.ptCode = ptCode;
	}
	public String getEngineForm() {
		return engineForm;
	}
	public void setEngineForm(String engineForm) {
		this.engineForm = engineForm;
	}
	public String getPtWriter() {
		return ptWriter;
	}
	public void setPtWriter(String ptWriter) {
		this.ptWriter = ptWriter;
	}
	public String getPtDate() {
		return ptDate;
	}
	public void setPtDate(String ptDate) {
		this.ptDate = ptDate;
	}
	public String getColorBigCode() {
		return colorBigCode;
	}
	public void setColorBigCode(String colorBigCode) {
		this.colorBigCode = colorBigCode;
	}
	public String getColorBigName() {
		return colorBigName;
	}
	public void setColorBigName(String colorBigName) {
		this.colorBigName = colorBigName;
	}
	public String getCbWriter() {
		return cbWriter;
	}
	public void setCbWriter(String cbWriter) {
		this.cbWriter = cbWriter;
	}
	public String getCbDate() {
		return cbDate;
	}
	public void setCbDate(String cbDate) {
		this.cbDate = cbDate;
	}
	public String getColorMidCode() {
		return colorMidCode;
	}
	public void setColorMidCode(String colorMidCode) {
		this.colorMidCode = colorMidCode;
	}
	public String getColorMidName() {
		return colorMidName;
	}
	public void setColorMidName(String colorMidName) {
		this.colorMidName = colorMidName;
	}
	public String getCmdWriter() {
		return cmdWriter;
	}
	public void setCmdWriter(String cmdWriter) {
		this.cmdWriter = cmdWriter;
	}
	public String getCmdDate() {
		return cmdDate;
	}
	public void setCmdDate(String cmdDate) {
		this.cmdDate = cmdDate;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "VoCarDetail [sid=" + sid + ", scode=" + scode + ", originCode=" + originCode + ", originMain="
				+ originMain + ", vendorCode=" + vendorCode + ", vendorName=" + vendorName + ", carClassCode="
				+ carClassCode + ", carClassMain=" + carClassMain + ", carModelCode=" + carModelCode + ", carModelName="
				+ carModelName + ", cmWriter=" + cmWriter + ", cmDate=" + cmDate + ", yearCarCode=" + yearCarCode
				+ ", carModelDetail=" + carModelDetail + ", sellStartYear=" + sellStartYear + ", sellEndYear="
				+ sellEndYear + ", ycWriter=" + ycWriter + ", ycDate=" + ycDate + ", customerCarNumber="
				+ customerCarNumber + ", rcCode=" + rcCode + ", bsCode=" + bsCode + ", customerCode=" + customerCode
				+ ", customerPhone=" + customerPhone + ", customerName=" + customerName + ", carProductionYear="
				+ carProductionYear + ", carRegistrationDate=" + carRegistrationDate + ", lastDistanceDriven="
				+ lastDistanceDriven + ", lastVisitDate=" + lastVisitDate + ", customerCarRegWriter="
				+ customerCarRegWriter + ", customerCarRegDate=" + customerCarRegDate + ", customerCarRegCode="
				+ customerCarRegCode + ", optionGradeCode=" + optionGradeCode + ", optionGradeName=" + optionGradeName
				+ ", ogWriter=" + ogWriter + ", ogDate=" + ogDate + ", choiceOptionCode=" + choiceOptionCode
				+ ", choiceOptionName=" + choiceOptionName + ", coWriter=" + coWriter + ", coDate=" + coDate
				+ ", lastOptionCode=" + lastOptionCode + ", loWriter=" + loWriter + ", loDate=" + loDate + ", fuelCode="
				+ fuelCode + ", fuelType=" + fuelType + ", fuelWriter=" + fuelWriter + ", fuelDate=" + fuelDate
				+ ", feCode=" + feCode + ", engineType=" + engineType + ", feWriter=" + feWriter + ", feDate=" + feDate
				+ ", tmCode=" + tmCode + ", tmType=" + tmType + ", tmWriter=" + tmWriter + ", tmDate=" + tmDate
				+ ", dwCode=" + dwCode + ", dwType=" + dwType + ", dwWriter=" + dwWriter + ", dwDate=" + dwDate
				+ ", ptCode=" + ptCode + ", engineForm=" + engineForm + ", ptWriter=" + ptWriter + ", ptDate=" + ptDate
				+ ", colorBigCode=" + colorBigCode + ", colorBigName=" + colorBigName + ", cbWriter=" + cbWriter
				+ ", cbDate=" + cbDate + ", colorMidCode=" + colorMidCode + ", colorMidName=" + colorMidName
				+ ", cmdWriter=" + cmdWriter + ", cmdDate=" + cmdDate + "]";
	}
	
}
