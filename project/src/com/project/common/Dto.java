package com.project.common;

public class Dto {

	private String empno;
	private String pwd;
	private String empnm;
	private String juminno;
	private String email;
	private String phone;
	private String emp_img;
	private String indt;
	private String outdt;
	private int manyn;
	private int deptno;
	private int ranknum;
	

	public String getEmp_img() {
		return emp_img;
	}
	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpnm() {
		return empnm;
	}
	public void setEmpnm(String empnm) {
		this.empnm = empnm;
	}
	public String getJuminno() {
		return juminno;
	}
	public void setJuminno(String juminno) {
		this.juminno = juminno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIndt() {
		return indt;
	}
	public void setIndt(String indt) {
		this.indt = indt;
	}
	public String getOutdt() {
		return outdt;
	}
	public void setOutdt(String outdt) {
		this.outdt = outdt;
	}
	public int getManyn() {
		return manyn;
	}
	public void setManyn(int manyn) {
		this.manyn = manyn;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getRanknum() {
		return ranknum;
	}
	public void setRanknum(int ranknum) {
		this.ranknum = ranknum;
	}
	@Override
	public String toString() {
		return "StaffDto [empno=" + empno + ", pwd=" + pwd + ", empnm=" + empnm + ", juminno=" + juminno
				+ ", email=" + email + ", phone=" + phone + ", indt=" + indt + ", outdt=" + outdt + ", manyn=" + manyn
				+ ", deptno=" + deptno + ", ranknum=" + ranknum + "]";
	}
}
