package com.iu.main.bookACCount;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookACCountDAO {
	
	@Autowired
	private SqlSession session;
	
	private final String NAMESPACE="com.iu.main.bookACCount.BookACCountDAO.";
}
