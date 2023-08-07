package com.iu.main.bookACCount;

import java.sql.Date;

public class BookACCountDTO {
	private Long accountNum;
	private String id;
	private Long bookNum;
	private Long account;
	private String accountPassword;
	private Long accountBalance;
	private Date accountDate;
	
	
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
	public String getAccountPassword() {
		return accountPassword;
	}
	public Long getAccountBalance() {
		if(this.accountBalance==null) {
			this.accountBalance=0L;
		}
		return accountBalance;
	}
	public Date getAccountDate() {
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
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	
	
	
	

	
	
	
}
