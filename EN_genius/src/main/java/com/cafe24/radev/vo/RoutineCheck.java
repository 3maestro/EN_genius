package com.cafe24.radev.vo;

public class RoutineCheck {
	
	private String riCode;
	private String bsCode;
	private String riItem;
	private String distanceCycle;
	private int periodCycle;
	private String riWriter;
	private String riDate;
	private boolean checkOX;
	
	public String getRiCode() {
		return riCode;
	}
	public void setRiCode(String riCode) {
		this.riCode = riCode;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getRiItem() {
		return riItem;
	}
	public void setRiItem(String riItem) {
		this.riItem = riItem;
	}
	public String getDistanceCycle() {
		return distanceCycle;
	}
	public void setDistanceCycle(String distanceCycle) {
		this.distanceCycle = distanceCycle;
	}
	public int getPeriodCycle() {
		return periodCycle;
	}
	public void setPeriodCycle(int periodCycle) {
		this.periodCycle = periodCycle;
	}
	public String getRiWriter() {
		return riWriter;
	}
	public void setRiWriter(String riWriter) {
		this.riWriter = riWriter;
	}
	public String getRiDate() {
		return riDate;
	}
	public void setRiDate(String riDate) {
		this.riDate = riDate;
	}
	public boolean isCheckOX() {
		return checkOX;
	}
	public void setCheckOX(boolean checkOX) {
		this.checkOX = checkOX;
	}
	
	@Override
	public String toString() {
		return "RoutineCheck [riCode=" + riCode + ", bsCode=" + bsCode + ", riItem=" + riItem + ", distanceCycle="
				+ distanceCycle + ", periodCycle=" + periodCycle + ", riWriter=" + riWriter + ", riDate=" + riDate
				+ ", checkOX=" + checkOX + "]";
	}
	
	
	
}
