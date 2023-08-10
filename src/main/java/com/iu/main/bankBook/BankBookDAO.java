package com.iu.main.bankBook;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.util.Pager;

@Repository // 해당 클래스의 객체 생성 
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
	
	//total
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal",pager);
	}
	
	//List
	public List<BankBookDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}
	
	//detail
	public BankBookDTO getDatail(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getDetail",bankBookDTO);
		
		
	}
	
	public int setFileAdd(BankBookFileDTO bankBookFileDTO) {
		return sqlSession.insert(NAMESPACE+"setFileAdd", bankBookFileDTO);
	}
	
	//add
	public int setAdd(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bankBookDTO);
	}
	
	//update
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}
	
	//delete
	public int setDelete(Long num) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", num );
	}
	//-------------------bankbookcomment
	public Long getCommentTotal(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCommentTotal",bankBookCommentDTO);
	}
	public List<BankBookCommentDTO> getComment(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getComment",map );
	}
}
