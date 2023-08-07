package com.iu.main.bookACCount;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Service
public class BookACCountService {
	
	@Autowired
	private BookACCountDAO bookACCountDAO;
	
	public List<BookACCountDTO> getList(Pager pager,MemberDTO memberDTO) throws Exception{
		pager.setPerPage(3L);
		pager.makeRowNum();
		
		pager.makePageNum(bookACCountDAO.getTotal());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member", memberDTO);
		map.put("pager", pager);
		return bookACCountDAO.getList(map);
	}
	
	public int setAdd(BookACCountDTO bookACCountDTO) throws Exception{
		Calendar ca = Calendar.getInstance();
		bookACCountDTO.setAccount(ca.getTimeInMillis());
		
		return  bookACCountDAO.setAdd(bookACCountDTO);
	}
}
