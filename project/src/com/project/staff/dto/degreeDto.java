package com.project.staff.dto;

public class degreeDto {
//	DEGREENUM	NUMBER(6)
//	FINALDEGREE	VARCHAR2(15)
//	COLLEGENM	VARCHAR2(50)
//	MAJOR	VARCHAR2(50)
//	ENTRANDT	CHAR(8)
//	GRADUDT	CHAR(8)
//	EMPNO	CHAR(10)
	
	private int degreenum;
	private String finaldegree;
	private String collegenm;
	private String major;
	private String entrandt;
	private String gradudt;
	private String empno;
	public int getDegreenum() {
		return degreenum;
	}
	public void setDegreenum(int degreenum) {
		this.degreenum = degreenum;
	}
	public String getFinaldegree() {
		return finaldegree;
	}
	public void setFinaldegree(String finaldegree) {
		this.finaldegree = finaldegree;
	}
	public String getCollegenm() {
		return collegenm;
	}
	public void setCollegenm(String collegenm) {
		this.collegenm = collegenm;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEntrandt() {
		return entrandt;
	}
	public void setEntrandt(String entrandt) {
		this.entrandt = entrandt;
	}
	public String getGradudt() {
		return gradudt;
	}
	public void setGradudt(String gradudt) {
		this.gradudt = gradudt;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	
}
