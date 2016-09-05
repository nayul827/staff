package com.project.project.dto;

import java.sql.Timestamp;

public class ProjectDto {
//	CPRONUM	NUMBER(6)
//	CREGIDT	CHAR(8)
//	CINITDT	CHAR(8)
//	COUTDT	CHAR(8)
//	CPRONM	VARCHAR2(30)
//	CCONTENT	VARCHAR2(2500)
	
	private int cpronum;
	private String pwd;
	private Timestamp cregidt;
	private String cinitdt;
	private String coutdt;
	private String cpronm;
	private String ccontent;
	
	public int getCpronum() {
		return cpronum;
	}
	public void setCpronum(int cpronum) {
		this.cpronum = cpronum;
	}
	public String getCinitdt() {
		return cinitdt;
	}
	public void setCinitdt(String cinitdt) {
		this.cinitdt = cinitdt;
	}
	public String getCoutdt() {
		return coutdt;
	}
	public void setCoutdt(String coutdt) {
		this.coutdt = coutdt;
	}
	public String getCpronm() {
		return cpronm;
	}
	public void setCpronm(String cpronm) {
		this.cpronm = cpronm;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	
//	
//	
//	PPRONUM	NUMBER(5)
//	PREGIDT	CHAR(8)
//	PINITDT	CHAR(8)
//	POUTDT	CHAR(8)
//	PPRONM	VARCHAR2(20)
//	PCONTENT	VARCHAR2(2500)
//	EMPNO	CHAR(10)
//	WORKNUM	NUMBER(2)
//	CAREERNUM	NUMBER(3)
	
	private int ppronum;
	private Timestamp pregidt;
	private String pinitdt;
	private String poutdt;
	private String ppronm;
	private String pcontent;
	private String empno;
	private int worknum;
	private int careernum;

	public int getPpronum() {
		return ppronum;
	}
	public void setPpronum(int ppronum) {
		this.ppronum = ppronum;
	}
	public String getPinitdt() {
		return pinitdt;
	}
	public void setPinitdt(String pinitdt) {
		this.pinitdt = pinitdt;
	}
	public String getPoutdt() {
		return poutdt;
	}
	public void setPoutdt(String poutdt) {
		this.poutdt = poutdt;
	}
	public String getPpronm() {
		return ppronm;
	}
	public void setPpronm(String ppronm) {
		this.ppronm = ppronm;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public int getWorknum() {
		return worknum;
	}
	public void setWorknum(int worknum) {
		this.worknum = worknum;
	}
	public int getCareernum() {
		return careernum;
	}
	public void setCareernum(int careernum) {
		this.careernum = careernum;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Timestamp getPregidt() {
		return pregidt;
	}
	public void setPregidt(Timestamp pregidt) {
		this.pregidt = pregidt;
	}
	public Timestamp getCregidt() {
		return cregidt;
	}
	public void setCregidt(Timestamp cregidt) {
		this.cregidt = cregidt;
	}
	
}
