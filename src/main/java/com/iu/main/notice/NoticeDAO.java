package com.iu.main.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.main.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", noticeDTO);
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}
	
	
	
}
