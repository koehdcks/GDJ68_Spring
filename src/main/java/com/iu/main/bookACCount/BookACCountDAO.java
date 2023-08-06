package com.iu.main.bookACCount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookACCountDAO {
	
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE="com.iu.main.bookACCount.BookACCountDAO.";
	
	public List<BookACCountDTO> getList(BookACCountDTO bookACCountDTO) throws Exception {
		
		return session.selectList(NAMESPACE+"getList", bookACCountDTO);
	}
	
	
	public int setAdd(BookACCountDTO bookACCountDTO) throws Exception{
		return session.insert(NAMESPACE+"setAdd", bookACCountDTO);
	}
	
	public BookACCountDTO getDetail(BookACCountDTO bookACCountDTO) throws Exception{
		return session.selectOne(NAMESPACE+"getDetail", bookACCountDTO);
	}
	
	public int setUpdate(BookACCountDTO bookACCountDTO) throws Exception{
		return session.update(NAMESPACE+"setUpdate", bookACCountDTO);
	}
	public int setDelete(BookACCountDTO bookACCountDTO) throws Exception{
		return session.delete(NAMESPACE+"setDelete", bookACCountDTO);
	}
	
}
