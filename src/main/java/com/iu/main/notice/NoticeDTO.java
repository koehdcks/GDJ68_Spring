package com.iu.main.notice;

import java.sql.Date;

public class NoticeDTO {
	private Integer noticeNum;
	private String noticeName;
	private String noticeTitle;
	private String noticeContents;
	private Date noticeDate;
	private Integer noticeHit;
	
	
	public Integer getNoticeNum() {
		return noticeNum;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public Integer getNoticeHit() {
		return noticeHit;
	}
	public void setNoticeNum(Integer noticeNum) {
		this.noticeNum = noticeNum;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public void setNoticeHit(Integer noticeHit) {
		this.noticeHit = noticeHit;
	}
	
	
	

	
}
