package com.cafe24.radev.jcs.vo;

public class VoCarOption {

	private String optionGradeCode; // 차량옵션등급분류코드(PK)
	private String optionGradeName; // 차량옵션등급명
	private String ogWriter; // 차량옵션등급 작성자
	private String ogDate; // 차량옵션등급 작성일자
	private String choiceOptionCode; // 차량선택옵션목록코드(PK)
	private String choiceOptionName; // 차량선택옵션목록명
	private String coWriter; // 차량선택옵션목록 작성자
	private String coDate; // 차량선택옵션목록 작성일자
	private String lastOptionCode; // 차량선택옵션최종코드(PK)
	private String loWriter; // 최종 옵션 작성자
	private String loDate; // 최종 옵션 작성일자
	private String group_Code; //그룹화 코드
	public String getOptionGradeCode() {
		return optionGradeCode;
	}
	public void setOptionGradeCode(String optionGradeCode) {
		this.optionGradeCode = optionGradeCode;
	}
	public String getOptionGradeName() {
		return optionGradeName;
	}
	public void setOptionGradeName(String optionGradeName) {
		this.optionGradeName = optionGradeName;
	}
	public String getOgWriter() {
		return ogWriter;
	}
	public void setOgWriter(String ogWriter) {
		this.ogWriter = ogWriter;
	}
	public String getOgDate() {
		return ogDate;
	}
	public void setOgDate(String ogDate) {
		this.ogDate = ogDate;
	}
	public String getChoiceOptionCode() {
		return choiceOptionCode;
	}
	public void setChoiceOptionCode(String choiceOptionCode) {
		this.choiceOptionCode = choiceOptionCode;
	}
	public String getChoiceOptionName() {
		return choiceOptionName;
	}
	public void setChoiceOptionName(String choiceOptionName) {
		this.choiceOptionName = choiceOptionName;
	}
	public String getCoWriter() {
		return coWriter;
	}
	public void setCoWriter(String coWriter) {
		this.coWriter = coWriter;
	}
	public String getCoDate() {
		return coDate;
	}
	public void setCoDate(String coDate) {
		this.coDate = coDate;
	}
	public String getLastOptionCode() {
		return lastOptionCode;
	}
	public void setLastOptionCode(String lastOptionCode) {
		this.lastOptionCode = lastOptionCode;
	}
	public String getLoWriter() {
		return loWriter;
	}
	public void setLoWriter(String loWriter) {
		this.loWriter = loWriter;
	}
	public String getLoDate() {
		return loDate;
	}
	public void setLoDate(String loDate) {
		this.loDate = loDate;
	}
	public String getGroup_Code() {
		return group_Code;
	}
	public void setGroup_Code(String group_Code) {
		this.group_Code = group_Code;
	}
	@Override
	public String toString() {
		return "VoCarOption [optionGradeCode=" + optionGradeCode + ", optionGradeName=" + optionGradeName
				+ ", ogWriter=" + ogWriter + ", ogDate=" + ogDate + ", choiceOptionCode=" + choiceOptionCode
				+ ", choiceOptionName=" + choiceOptionName + ", coWriter=" + coWriter + ", coDate=" + coDate
				+ ", lastOptionCode=" + lastOptionCode + ", loWriter=" + loWriter + ", loDate=" + loDate
				+ ", group_Code=" + group_Code + "]";
	}
	
	
	
}
