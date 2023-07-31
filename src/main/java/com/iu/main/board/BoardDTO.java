package com.iu.main.board;

import java.sql.Date;

public class BoardDTO {
	private Long num;
	private String subject;
	private String name;
	private String contents;
	private Date createDate;
	private Long hit;
	
	
	public Long getNum() {
		return num;
	}
	public String getSubject() {
		return subject;
	}
	public String getName() {
		return name;
	}
	public String getContents() {
		return contents;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Long getHit() {
		return hit;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	
	
}
