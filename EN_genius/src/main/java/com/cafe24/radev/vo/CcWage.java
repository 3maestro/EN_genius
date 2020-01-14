package com.cafe24.radev.vo;

public class CcWage {
	private String ccWageCode;
	private String capacityNum;
	private String loadage;
	private String minCc;
	private String maxCc;
	private String ccTerms;
	private String standardWage;
	
	public String getCcWageCode() {
		return ccWageCode;
	}
	public void setCcWageCode(String ccWageCode) {
		this.ccWageCode = ccWageCode;
	}
	public String getCapacityNum() {
		return capacityNum;
	}
	public void setCapacityNum(String capacityNum) {
		this.capacityNum = capacityNum;
	}
	public String getLoadage() {
		return loadage;
	}
	public void setLoadage(String loadage) {
		this.loadage = loadage;
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
	public String getCcTerms() {
		return ccTerms;
	}
	public void setCcTerms(String ccTerms) {
		this.ccTerms = ccTerms;
	}
	public String getStandardWage() {
		return standardWage;
	}
	public void setStandardWage(String standardWage) {
		this.standardWage = standardWage;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcWage [ccWageCode=");
		builder.append(ccWageCode);
		builder.append(", capacityNum=");
		builder.append(capacityNum);
		builder.append(", loadage=");
		builder.append(loadage);
		builder.append(", minCc=");
		builder.append(minCc);
		builder.append(", maxCc=");
		builder.append(maxCc);
		builder.append(", ccTerms=");
		builder.append(ccTerms);
		builder.append(", standardWage=");
		builder.append(standardWage);
		builder.append("]");
		return builder.toString();
	}
	
}
	
