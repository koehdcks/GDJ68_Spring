package com.iu.main.bookACCount;

import oracle.sql.DATE;

public class BookACCountDTO {
	private Long accountNum;
	private String id;
	private Long bookNum;
	private Long account;
	private Integer accountPassword;
	private Long accountBalance;
	private DATE accountDate;
	
	
	public Long getAccountNum() {
		return accountNum;
	}
	public String getId() {
		return id;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public Long getAccount() {
		return account;
	}
	public Integer getAccountPassword() {
		return accountPassword;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public DATE getAccountDate() {
		return accountDate;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public void setAccount(Long account) {
		this.account = account;
	}
	public void setAccountPassword(Integer accountPassword) {
		this.accountPassword = accountPassword;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public void setAccountDate(DATE accountDate) {
		this.accountDate = accountDate;
	}
	
	
	
}
