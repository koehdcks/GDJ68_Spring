package com.iu.main.bookACCount;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.member.MemberDTO;

@Repository
public class BookACCountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.bookACCount.BookACCountDAO.";
	
	public long getTotal() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal");
	}
	
	public List<BookACCountDTO> getList(Map<String, Object> map) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}
	
	
	public int setAdd(BookACCountDTO bookACCountDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bookACCountDTO);
	}
	
	public BookACCountDTO getDetail(BookACCountDTO bookACCountDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", bookACCountDTO);
	}
	
	public int setUpdate(BookACCountDTO bookACCountDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bookACCountDTO);
	}
	public int setDelete(BookACCountDTO bookACCountDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", bookACCountDTO);
	}
	
}
