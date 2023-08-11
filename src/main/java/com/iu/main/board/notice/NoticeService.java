package com.iu.main.board.notice;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.file.FileDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	
	public boolean setContentsImgDelete(String path,HttpSession session) throws Exception {
		//path: /resources/upload/notice/파일명
		//path안의 경로와 파일명 분리
		FileDTO fileDTO = new FileDTO();
		fileDTO.setFileName(path.substring(path.lastIndexOf("/")+1));
//		path = path.substring(0,path.lastIndexOf("/")+1);
		path="/resources/upload/notice/";
		return fileManager.fileDelete(fileDTO, path, session);
	}	
	
	public String setContentsImg(MultipartFile file,HttpSession session) throws Exception{
		String path = "/resources/upload/notice/";
		String fileName = fileManager.fileSave(path, file, session);
		return path+fileName;
		
	}
	
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
	
	public int setUpdate(BoardDTO boardDTO,MultipartFile[] files,HttpSession session) throws Exception{
		int result = noticeDAO.setUpdate(boardDTO);
		
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
	
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}
	
	public int setFileDelete(NoticeFileDTO noticeFileDTO,HttpSession session) throws Exception{
		//폴더 파일 삭제
		noticeFileDTO = noticeDAO.getFileDetail(noticeFileDTO);
		boolean flag = fileManager.fileDelete(noticeFileDTO, "/resources/upload/notice/",session);
		
		if(flag) {
			//db 삭제
			return noticeDAO.setFileDelete(noticeFileDTO);
		}
		return 0;
	}
}
