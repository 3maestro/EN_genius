package com.cafe24.radev.vo;

import java.util.Arrays;
import java.util.List;

public class WorkDecide {

	//private List<String> ccWageSmallCode;
	private List<String> bsCode;
	private List<String> receptionCode;
	private List<String> wageSmallName;
	private List<String> manHour;
	private List<String> ccStandardWage;
	private List<String> count;
	private List<String> workMan;
	
//	public List<String> getCcWageSmallCode() {
//	return ccWageSmallCode;
//}
//public void setCcWageSmallCode(List<String> ccWageSmallCode) {
//	this.ccWageSmallCode = ccWageSmallCode;
//}
	
	public List<String> getBsCode() {
		return bsCode;
	}
	public void setBsCode(List<String> bsCode) {
		this.bsCode = bsCode;
	}
	public List<String> getReceptionCode() {
		return receptionCode;
	}
	public void setReceptionCode(List<String> receptionCode) {
		this.receptionCode = receptionCode;
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
	public List<String> getWorkMan() {
		return workMan;
	}
	public void setWorkMan(List<String> workMan) {
		this.workMan = workMan;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkDecide [bsCode=");
		builder.append(bsCode);
		builder.append(", receptionCode=");
		builder.append(receptionCode);
		builder.append(", wageSmallName=");
		builder.append(wageSmallName);
		builder.append(", manHour=");
		builder.append(manHour);
		builder.append(", ccStandardWage=");
		builder.append(ccStandardWage);
		builder.append(", count=");
		builder.append(count);
		builder.append(", workMan=");
		builder.append(workMan);
		builder.append("]");
		return builder.toString();
	}

}
