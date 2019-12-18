package com.cafe24.radev.vo;

public class VoCarInfo {

	private String rcCode; // 등록증상자동차정보코드(PK)
	private String rcWriter; // 작성자
	private String rcDate; // 작성일자
	
	public String getRcCode() {
		return rcCode;
	}
	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
	}
	public String getRcWriter() {
		return rcWriter;
	}
	public void setRcWriter(String rcWriter) {
		this.rcWriter = rcWriter;
	}
	public String getRcDate() {
		return rcDate;
	}
	public void setRcDate(String rcDate) {
		this.rcDate = rcDate;
	}
	
	@Override
	public String toString() {
		return "VoCarInfo [rcCode=" + rcCode + ", rcWriter=" + rcWriter + ", rcDate=" + rcDate + "]";
	}
	
	
}
