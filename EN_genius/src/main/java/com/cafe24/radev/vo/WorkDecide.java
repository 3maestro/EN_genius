package com.cafe24.radev.vo;

import java.util.Arrays;
import java.util.List;

public class WorkDecide {

	private List<String> ccWageSmallCode;
	private List<String> wageSmallName;
	private List<String> manHour;
	private List<String> ccStandardWage;
	private List<String> count;
	
	public List<String> getCcWageSmallCode() {
		return ccWageSmallCode;
	}
	public void setCcWageSmallCode(List<String> ccWageSmallCode) {
		this.ccWageSmallCode = ccWageSmallCode;
	}
	public List<String> getWageSmallName() {
		return wageSmallName;
	}
	public void setWageSmallName(List<String> wageSmallName) {
		this.wageSmallName = wageSmallName;
	}
	public List<String> getManHour() {
		return manHour;
	}
	public void setManHour(List<String> manHour) {
		this.manHour = manHour;
	}
	public List<String> getCcStandardWage() {
		return ccStandardWage;
	}
	public void setCcStandardWage(List<String> ccStandardWage) {
		this.ccStandardWage = ccStandardWage;
	}
	public List<String> getCount() {
		return count;
	}
	public void setCount(List<String> count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "WorkDecide [ccWageSmallCode=" + ccWageSmallCode + ", wageSmallName=" + wageSmallName + ", manHour="
				+ manHour + ", ccStandardWage=" + ccStandardWage + ", count=" + count + "]";
	}

}
