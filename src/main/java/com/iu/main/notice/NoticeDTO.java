package com.iu.main.notice;

import java.sql.Date;
import java.util.List;

public class NoticeDTO {
	private Integer noticeNum;
	private String id;
	private String noticeTitle;
	private String noticeContents;
	private Date noticeDate;
	private Integer noticeHit;
	private List<NoticeFileDTO> fileDTOs;
	
	
	
	
	

	public List<NoticeFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<NoticeFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNoticeNum() {
		return noticeNum;
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
