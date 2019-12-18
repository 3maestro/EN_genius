package com.cafe24.radev.vo;

public class DepartmentDuty {

	private String ddCode;
	private String bsCode;
	private String dutyName;
	private String useCheck;
	public String getDdCode() {
		return ddCode;
	}
	public void setDdCode(String ddCode) {
		this.ddCode = ddCode;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
	public String getUseCheck() {
		return useCheck;
	}
	public void setUseCheck(String useCheck) {
		this.useCheck = useCheck;
	}
	@Override
	public String toString() {
		return "Department [ddCode=" + ddCode + ", bsCode=" + bsCode + ", dutyName=" + dutyName + ", useCheck="
				+ useCheck + "]";
	}
	
}
