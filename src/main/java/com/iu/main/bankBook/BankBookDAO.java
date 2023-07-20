package com.iu.main.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 해당 클래스의 객체 생성 
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
	
	//List
	
	//detail
	public BankBookDTO getDatail(BankBookDTO bankBookDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getDetail",bankBookDTO);
		
		
	}
	//add
	
	//update
	
	//delete
}
