package com.cafe24.radev.vo;

public class WageManHour {
	private String ccWageSmallCode;
	private String ccWageCode;
	private String wageBigName;
	private String wageMidName;
	private String wageSmallName;
	private String manHour;
	
	public String getCcWageSmallCode() {
		return ccWageSmallCode;
	}
	public void setCcWageSmallCode(String ccWageSmallCode) {
		this.ccWageSmallCode = ccWageSmallCode;
	}
	public String getCcWageCode() {
		return ccWageCode;
	}
	public void setCcWageCode(String ccWageCode) {
		this.ccWageCode = ccWageCode;
	}
	public String getWageBigName() {
		return wageBigName;
	}
	public void setWageBigName(String wageBigName) {
		this.wageBigName = wageBigName;
	}
	public String getWageMidName() {
		return wageMidName;
	}
	public void setWageMidName(String wageMidName) {
		this.wageMidName = wageMidName;
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
		builder.append("WageManHour [ccWageSmallCode=");
		builder.append(ccWageSmallCode);
		builder.append(", ccWageCode=");
		builder.append(ccWageCode);
		builder.append(", wageBigName=");
		builder.append(wageBigName);
		builder.append(", wageMidName=");
		builder.append(wageMidName);
		builder.append(", wageSmallName=");
		builder.append(wageSmallName);
		builder.append(", manHour=");
		builder.append(manHour);
		builder.append("]");
		return builder.toString();
	}

}
