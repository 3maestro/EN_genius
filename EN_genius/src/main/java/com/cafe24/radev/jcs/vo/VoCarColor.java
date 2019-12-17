package com.cafe24.radev.jcs.vo;

public class VoCarColor {

	private String colorBigCode; // 외장색상대분류코드(PK)
	private String colorBigName; // 외장색상대분류명
	private String cbWriter; // 외장색 대분류 작성자
	private String cbDate; // 외장색 대분류 작성일자
	private String colorMidCode; // 외장색중분류코드(PK)
	private String colorMidName; // 외장색중분류명
	private String cmdWriter; // 외장색 중분류 작성자
	private String cmdDate; // 외장색 중분류 작성일자
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
	
	@Override
	public String toString() {
		return "VoCarColor [colorBigCode=" + colorBigCode + ", colorBigName=" + colorBigName + ", cbWriter=" + cbWriter
				+ ", cbDate=" + cbDate + ", colorMidCode=" + colorMidCode + ", colorMidName=" + colorMidName
				+ ", cmdWriter=" + cmdWriter + ", cmdDate=" + cmdDate + "]";
	}
	
	
	
}
