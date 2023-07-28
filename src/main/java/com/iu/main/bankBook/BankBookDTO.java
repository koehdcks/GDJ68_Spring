package com.iu.main.bankBook;

import java.util.List;

public class BankBookDTO {
	private Long bookNum;
	private String bookName;
	private String bookContents;
	private Double bookRate;
	private Integer bookSale;
	private List<BankBookFileDTO> fileDTOs;
		
	
	
	public List<BankBookFileDTO> getFileDTOs() {
		return fileDTOs;
	}
	public void setFileDTOs(List<BankBookFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookContents() {
		return bookContents;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	
	
}
