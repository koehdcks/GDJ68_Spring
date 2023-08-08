package com.iu.main.bankBook;

import java.sql.Date;

public class BankBookCommentDTO {
	private Long commentNum;
	private Long bookNum;
	private String id;
	private String commentContents;
	private Date commentDate;
	private Double commentRating;
	
	
	public Long getCommentNum() {
		return commentNum;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public String getId() {
		return id;
	}
	public String getCommentContents() {
		return commentContents;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public Double getCommentRating() {
		return commentRating;
	}
	public void setCommentNum(Long commentNum) {
		this.commentNum = commentNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public void setCommentRating(Double commentRating) {
		this.commentRating = commentRating;
	}
	
	
}
