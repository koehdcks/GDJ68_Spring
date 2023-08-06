package com.iu.main.bookACCount;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

public class BookACCountDAOTest {

	@Autowired
	private BookACCountDAO bookACCountDAO;
	
	@Test
	public void addTest() throws Exception{
		BookACCountDTO bookACCountDTO = new BookACCountDTO();
		
		bookACCountDTO.setId("chan");
		bookACCountDTO.setBookNum(7L);
		bookACCountDTO.setAccount(1234567890L);
		bookACCountDTO.setAccountPassword(1234);
		bookACCountDTO.setAccountBalance(300000000L);
		bookACCountDAO.setAdd(bookACCountDTO);
	}
}
