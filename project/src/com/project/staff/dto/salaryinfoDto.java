package com.project.staff.dto;

public class salaryinfoDto {
//	EMPNO	CHAR(10)		N	사원번호
//	INITDT	CHAR(8)		N	시작일
//	OUTDT	CHAR(8)	'99991231'
//	   	N	종료일
//	SALARY	NUMBER(9)	0
//		N	급여
	
	private String empno;
	private String initdt;
	private String outdt;
	private int salary;
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getInitdt() {
		return initdt;
	}
	public void setInitdt(String initdt) {
		this.initdt = initdt;
	}
	public String getOutdt() {
		return outdt;
	}
	public void setOutdt(String outdt) {
		this.outdt = outdt;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}	
