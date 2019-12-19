package com.cafe24.radev.vo;
/**
 * 	직원 vo
 * @author 박연우
 *
 */
public class Employee {

	private String employeeCode;		//직원정보코드
	private String bsCode;				//사업장코드
	private String edCode;				//부서코드
	private String ddCode;				//직책코드
	private String employeePass;		//직원비밀번호
	private String employeeName;		//직원이름
	private String employeeBirth;		//직원생일
	private String employeeGender;		//성별
	private String employeeAddr;		//주소
	private String addrDetail;			//상세주소
	private String employeePhone;		//핸드폰번호
	private String joinDate;			//입사일
	private String resignationDate;		//퇴사일
	private String cCode;
	private DepartmentDuty departmentDuty;	
	private EmployeeDepartment employeeDepartment;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getBsCode() {
		return bsCode;
	}
	public void setBsCode(String bsCode) {
		this.bsCode = bsCode;
	}
	public String getEdCode() {
		return edCode;
	}
	public void setEdCode(String edCode) {
		this.edCode = edCode;
	}
	public String getDdCode() {
		return ddCode;
	}
	public void setDdCode(String ddCode) {
		this.ddCode = ddCode;
	}
	public String getEmployeePass() {
		return employeePass;
	}
	public void setEmployeePass(String employeePass) {
		this.employeePass = employeePass;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeBirth() {
		return employeeBirth;
	}
	public void setEmployeeBirth(String employeeBirth) {
		this.employeeBirth = employeeBirth;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public String getEmployeeAddr() {
		return employeeAddr;
	}
	public void setEmployeeAddr(String employeeAddr) {
		this.employeeAddr = employeeAddr;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getResignationDate() {
		return resignationDate;
	}
	public void setResignationDate(String resignationDate) {
		this.resignationDate = resignationDate;
	}
	public DepartmentDuty getDepartmentDuty() {
		return departmentDuty;
	}
	public void setDepartmentDuty(DepartmentDuty departmentDuty) {
		this.departmentDuty = departmentDuty;
	}
	public EmployeeDepartment getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(EmployeeDepartment employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	@Override
	public String toString() {
		return "Employee [employeeCode=" + employeeCode + ", bsCode=" + bsCode + ", edCode=" + edCode + ", ddCode="
				+ ddCode + ", employeePass=" + employeePass + ", employeeName=" + employeeName + ", employeeBirth="
				+ employeeBirth + ", employeeGender=" + employeeGender + ", employeeAddr=" + employeeAddr
				+ ", addrDetail=" + addrDetail + ", employeePhone=" + employeePhone + ", joinDate=" + joinDate
				+ ", resignationDate=" + resignationDate + ", cCode=" + cCode + ", departmentDuty=" + departmentDuty
				+ ", employeeDepartment=" + employeeDepartment + "]";
	}

	
	
}