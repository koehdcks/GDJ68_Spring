package com.iu.main.board.notice;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		Long total = noticeDAO.getTotal(pager);
		pager.makePageNum(total);
		
		return noticeDAO.getList(pager);
	}
	
	public int setAdd(BoardDTO boardDTO,MultipartFile[] files,HttpSession session) throws Exception{
		int result = noticeDAO.setAdd(boardDTO);
		
		if(files.length!=0) {
			for(int i=0;i<files.length;i++) {
				String fileName=fileManager.fileSave("notice", files[i], session);
				NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
				noticeFileDTO.setOriginalName(files[i].getOriginalFilename());
				noticeFileDTO.setFileName(fileName);
				noticeFileDTO.setNoticeNum(boardDTO.getNum());
				result = noticeDAO.setFileAdd(noticeFileDTO);
			}
		}
		
		return result;
	}
	
	public NoticeDTO getDetail(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getDetail(boardDTO);
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}
	
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}
}