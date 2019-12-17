package com.cafe24.radev.pet.vo;
/**
 * 그룹 VO
 * @author 박으뜸
 *
 */
public class Group {
	private String groupCode;
	private String groupName;
	private String groupWrite;
	private String groupDate;
	private String bsCode;
	
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupWrite() {
		return groupWrite;
	}
	public void setGroupWrite(String groupWrite) {
		this.groupWrite = groupWrite;
	}
	public String getGroupDate() {
		return groupDate;
	}
	public void setGroupDate(String groupDate) {
		this.groupDate = groupDate;
	}
	
}
