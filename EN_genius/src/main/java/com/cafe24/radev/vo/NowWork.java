package com.cafe24.radev.vo;

public class NowWork {

	private String ccWageSmallCode;
	private String wageSmallName;
	private String manHour;
	private String ccCode;
	private int count;
	
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
	public String getCcCode() {
		return ccCode;
	}
	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "NowWork [ccWageSmallCode=" + ccWageSmallCode + ", wageSmallName=" + wageSmallName + ", manHour="
				+ manHour + ", ccCode=" + ccCode + ", count=" + count + "]";
	}
	
}
