package com.iu.main.bankBook;

public class BankBookDTO {
	private Long bookNum;
	private String bookName;
	private String bookContents;
	private Double bookRate;
	private Integer bookSale;
	private String[] sports;
	
	public String[] getSports() {
		return sports;
	}
	public void setSports(String[] sports) {
		this.sports = sports;
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
