package com.iu.main.bankBook;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 해당 클래스의 객체 생성 
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
	
	//List
	public List<BankBookDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	//detail
	public BankBookDTO getDatail(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getDetail",bankBookDTO);
		
		
	}
	//add
	
	//update
	
	//delete
}
