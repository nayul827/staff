package com.project.project.dto;

public class ProjectDto {
//	 cpronum	 NUMBER(6)
//     ,	 cregidate	 CHAR(8)
//     ,	 cinitdate	 CHAR(8)
//     ,	 coutdate	 CHAR(8)
//     ,	 cproname	 VARCHAR2(30)
//     ,	 ccontent	 VARCHAR2(2500)
	private int cpronum;
	private String cregidate;
	private String cinitdate;
	private String coutdate;
	private String cproname;
	private String ccontet;
	public int getCpronum() {
		return cpronum;
	}
	public void setCpronum(int cpronum) {
		this.cpronum = cpronum;
	}
	public String getCregidate() {
		return cregidate;
	}
	public void setCregidate(String cregidate) {
		this.cregidate = cregidate;
	}
	public String getCinitdate() {
		return cinitdate;
	}
	public void setCinitdate(String cinitdate) {
		this.cinitdate = cinitdate;
	}
	public String getCoutdate() {
		return coutdate;
	}
	public void setCoutdate(String coutdate) {
		this.coutdate = coutdate;
	}
	public String getCproname() {
		return cproname;
	}
	public void setCproname(String cproname) {
		this.cproname = cproname;
	}
	public String getCcontet() {
		return ccontet;
	}
	public void setCcontet(String ccontet) {
		this.ccontet = ccontet;
	}
	
	
}
