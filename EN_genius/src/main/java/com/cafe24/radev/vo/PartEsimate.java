package com.cafe24.radev.vo;

public class PartEsimate {
	private String esCode;
	private String bsCode;
	private String grCode;
	private String docNo;
	private String partNumber;
	private String partMany;
	private String partPrice;
	private int partTex;
	private int partToPrice;
	private String esDec;
	private String writer;
	private String innitDate;
	
	
	
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getEsDec() {
		return esDec;
	}
	public void setEsDec(String esDec) {
		if(esDec.equals("")) {
			esDec = null;
		}
		this.esDec = esDec;
	}
	public String getEsCode() {
		return esCode;
	}
	public void setEsCode(String esCode) {
		this.esCode = esCode;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getGrCode() {
		return grCode;
	}
	public void setGrCode(String grCode) {
		this.grCode = grCode;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getPartMany() {
		return partMany;
	}
	public void setPartMany(String partMany) {
		this.partMany = partMany;
	}
	public String getPartPrice() {
		return partPrice;
	}
	public void setPartPrice(String partPrice) {
		this.partPrice = partPrice;
	}
	public int getPartTex() {
		return partTex;
	}
	public void setPartTex(int partTex) {
		this.partTex = partTex;
	}
	public int getPartToPrice() {
		return partToPrice;
	}
	public void setPartToPrice(int partToPrice) {
		this.partToPrice = partToPrice;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getInnitDate() {
		return innitDate;
	}
	public void setInnitDate(String innitDate) {
		this.innitDate = innitDate;
	}
	@Override
	public String toString() {
		return "PartEsimate [esCode=" + esCode + ", bsCode=" + bsCode + ", grCode=" + grCode + ", partNumber="
				+ partNumber + ", partMany=" + partMany + ", partPrice=" + partPrice + ", partTex=" + partTex
				+ ", partToPrice=" + partToPrice + ", esDec=" + esDec + ", writer=" + writer + ", innitDate="
				+ innitDate + "]";
	}
	
}
