package com.cafe24.radev.vo;

public class NowWork {

//	private String ccWageSmallCode; 
//	private String ccCode;		
	private String nowWorkCode;		//현재 진행 각각의 작업 코드
	private String wageSmallName;	//현재 진행 각각의 작업 이름
	private double manHour;			//현재 진행 작업 각각의 표준 작업 시간
	private int onePrice;			//해당 차량에 적합한 배기량별 단가
	private int count;				//현재 진행 작업 각각의 수량
	private int totalPrice;			//현재 진행 작업 각각의 견적 = 단가 * 수량 
	
	public String getNowWorkCode() {
		return nowWorkCode;
	}
	public void setNowWorkCode(String nowWorkCode) {
		this.nowWorkCode = nowWorkCode;
	}
	public String getWageSmallName() {
		return wageSmallName;
	}
	public void setWageSmallName(String wageSmallName) {
		this.wageSmallName = wageSmallName;
	}
	public double getManHour() {
		return manHour;
	}
	public void setManHour(double manHour) {
		this.manHour = manHour;
	}
//	public String getCcCode() {
//		return ccCode;
//	}
//	public void setCcCode(String ccCode) {
//		this.ccCode = ccCode;
//	}
	public int getOnePrice() {
		return onePrice;
	}
	public void setOnePrice(int onePrice) {
		this.onePrice = onePrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return "NowWork [nowWorkCode=" + nowWorkCode + ", wageSmallName=" + wageSmallName + ", manHour=" + manHour
				+ ", onePrice=" + onePrice + ", count=" + count + ", totalPrice=" + totalPrice + "]";
	}

}
