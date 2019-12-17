package com.cafe24.radev.pyw.vo;

public class ImageFile {

	private String imageCode;
	private String bsCode;
	private String realFileName;
	private long fileSize;
	private String imaWriter;
	private String imaDate;
	public String getImageCode() {
		return imageCode;
	}
	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getImaWriter() {
		return imaWriter;
	}
	public void setImaWriter(String imaWriter) {
		this.imaWriter = imaWriter;
	}
	public String getImaDate() {
		return imaDate;
	}
	public void setImaDate(String imaDate) {
		this.imaDate = imaDate;
	}
	@Override
	public String toString() {
		return "ImageFile [imageCode=" + imageCode + ", bsCode=" + bsCode + ", realFileName=" + realFileName
				+ ", fileSize=" + fileSize + ", imaWriter=" + imaWriter + ", imaDate=" + imaDate + "]";
	}
	
}
