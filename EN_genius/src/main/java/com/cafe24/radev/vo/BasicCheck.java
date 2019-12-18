package com.cafe24.radev.vo;

public class BasicCheck {
	
	private String ckBigName;
	private String ckMidName;
	private String ckSmallContent;
	
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
	public String getCkSmallContent() {
		return ckSmallContent;
	}
	public void setCkSmallContent(String ckSmallContent) {
		this.ckSmallContent = ckSmallContent;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BasicCheck [ckBigName=");
		builder.append(ckBigName);
		builder.append(", ckMidName=");
		builder.append(ckMidName);
		builder.append(", ckSmallContent=");
		builder.append(ckSmallContent);
		builder.append("]");
		return builder.toString();
	}

}
