package com.project.notice.dto;

import java.sql.Timestamp;

public class NoticeDto {
//
//	NOTICENUM	NUMBER(10)
//	PASS	VARCHAR2(30)
//	TITLE	VARCHAR2(50)
//	WRITER	VARCHAR2(50)
//	CONTENT	VARCHAR2(2500)
//	WRITEDATE	DATE
//	HITS	NUMBER(3)
//	EMPNO	NUMBER(5)
	
	private int noticenum;
	private String pass;
	private String title;
	private String writer;
	private String content;
	private Timestamp writedate;
	private int hits;
	private String empno;
	
	public int getNoticenum() {
		return noticenum;
	}
	public void setNoticenum(int noticenum) {
		this.noticenum = noticenum;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	
}
