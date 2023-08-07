package com.iu.main.bookACCount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import com.iu.main.Mytest;
import com.iu.main.member.MemberDTO;

public class BookACCountDAOTest extends Mytest {

	@Autowired
	private BookACCountDAO bookACCountDAO;
	
//	@Test
//	public void getListTest() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("22222222");
//		List<BookACCountDTO> ar = bookACCountDAO.getList(memberDTO);
//		
//		assertNotEquals(0,ar.size());
//	}
	
	
	
	@Test
	public void setAddTest() throws Exception{
		BookACCountDTO bookACCountDTO = new BookACCountDTO();
		
		bookACCountDTO.setId("chan");
		bookACCountDTO.setBookNum(7L);
		bookACCountDTO.setAccount(2323252L);
		bookACCountDTO.setAccountPassword("0101");
		bookACCountDTO.setAccountBalance(0L);
		int result = bookACCountDAO.setAdd(bookACCountDTO);
		assertEquals(1,result);
		
	}
}
