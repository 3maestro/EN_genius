package com.cafe24.radev.vo;

public class BasicCheck {
	
	private String ckBigName;
	private String ckMidName;
	
	public String getCkBigName() {
		return ckBigName;
	}
	public void setCkBigName(String ckBigName) {
		this.ckBigName = ckBigName;
	}
	public String getCkMidName() {
		return ckMidName;
	}
	public void setCkMidName(String ckMidName) {
		this.ckMidName = ckMidName;
	}
	
	@Override
	public String toString() {
		return "BasicCheck [ckBigName=" + ckBigName + ", ckMidName=" + ckMidName + "]";
	}
}
