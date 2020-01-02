package com.cafe24.radev.vo;

public class WorkDecide {

	private String ccWageSmallCode;
	private String wageSmallName;
	private String manHour;
	
	public String getCcWageSmallCode() {
		return ccWageSmallCode;
	}
	public void setCcWageSmallCode(String ccWageSmallCode) {
		this.ccWageSmallCode = ccWageSmallCode;
	}
	public String getWageSmallName() {
		return wageSmallName;
	}
	public void setWageSmallName(String wageSmallName) {
		this.wageSmallName = wageSmallName;
	}
	public String getManHour() {
		return manHour;
	}
	public void setManHour(String manHour) {
		this.manHour = manHour;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkDecide [ccWageSmallCode=");
		builder.append(ccWageSmallCode);
		builder.append(", wageSmallName=");
		builder.append(wageSmallName);
		builder.append(", manHour=");
		builder.append(manHour);
		builder.append("]");
		return builder.toString();
	}
	
}
