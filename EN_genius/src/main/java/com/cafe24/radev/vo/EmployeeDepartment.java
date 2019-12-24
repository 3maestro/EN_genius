package com.cafe24.radev.vo;

public class EmployeeDepartment {

	private String edCode;
	private String bsCode;
	private String dpName;
	private String useCheck;
	public String getEdCode() {
		return edCode;
	}
	public void setEdCode(String edCode) {
		this.edCode = edCode;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getDpName() {
		return dpName;
	}
	public void setDpName(String dpName) {
		this.dpName = dpName;
	}
	public String getUseCheck() {
		return useCheck;
	}
	public void setUseCheck(String useCheck) {
		this.useCheck = useCheck;
	}
	@Override
	public String toString() {
		return "EmployeeDepartment [edCode=" + edCode + ", bsCode=" + bsCode + ", dpName=" + dpName + ", useCheck="
				+ useCheck + "]";
	}
	
}
