package com.iu.main.board.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;
import com.iu.main.board.BoardDTO;

public class QnaDAOTest extends Mytest {
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void setAddTest() throws Exception{
		QnaDTO boardDTO= new QnaDTO();
		boardDTO.setName("chan");
		boardDTO.setSubject("testtt");
		boardDTO.setContents("test contents");
		
		int result= qnaDAO.setAdd(boardDTO);
		assertEquals(1, result);
	}

}
