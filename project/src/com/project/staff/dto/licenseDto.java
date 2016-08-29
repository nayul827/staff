package com.project.staff.dto;

public class licenseDto {
//	LICENSENUM	VARCHAR2(20)
//	LICENSENM	VARCHAR2(50)
//	GETDT	CHAR(8)
//	LICENSEOFFICE	VARCHAR2(30)
//	EMPNO	CHAR(10)
	
	private String licensenum;
	private String licensenm;
	private String getdt;
	private String licenseoffice;
	private String empno;
	public String getLicensenum() {
		return licensenum;
	}
	public void setLicensenum(String licensenum) {
		this.licensenum = licensenum;
	}
	public String getLicensenm() {
		return licensenm;
	}
	public void setLicensenm(String licensenm) {
		this.licensenm = licensenm;
	}
	public String getGetdt() {
		return getdt;
	}
	public void setGetdt(String getdt) {
		this.getdt = getdt;
	}
	public String getLicenseoffice() {
		return licenseoffice;
	}
	public void setLicenseoffice(String licenseoffice) {
		this.licenseoffice = licenseoffice;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	
}
