package com.cafe24.radev.vo;

public class VoCarFuel {

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
	
	@Override
	public String toString() {
		return "VoCarFuel [fuelCode=" + fuelCode + ", fuelType=" + fuelType + ", fuelWriter=" + fuelWriter
				+ ", fuelDate=" + fuelDate + ", feCode=" + feCode + ", engineType=" + engineType + ", feWriter="
				+ feWriter + ", feDate=" + feDate + ", tmCode=" + tmCode + ", tmType=" + tmType + ", tmWriter="
				+ tmWriter + ", tmDate=" + tmDate + ", dwCode=" + dwCode + ", dwType=" + dwType + ", dwWriter="
				+ dwWriter + ", dwDate=" + dwDate + ", ptCode=" + ptCode + ", engineForm=" + engineForm + ", ptWriter="
				+ ptWriter + ", ptDate=" + ptDate + "]";
	}
	
	
}
