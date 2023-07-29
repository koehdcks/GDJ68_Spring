package com.iu.main.notice;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	
	public List<NoticeDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		Long total = noticeDAO.getTotal(pager);
		pager.makePageNum(total);
		
		return noticeDAO.getList(pager);
	}
	
	public int setAdd(NoticeDTO noticeDTO,MultipartFile[] files,HttpSession session) throws Exception{
		int result = noticeDAO.setAdd(noticeDTO);
		
		if(files.length!=0) {
			for(int i=0;i<files.length;i++) {
				String fileName=fileManager.fileSave("notice", files[i], session);
				NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
				noticeFileDTO.setOriginalName(files[i].getOriginalFilename());
				noticeFileDTO.setFileName(fileName);
				noticeFileDTO.setNoticeNum(noticeDTO.getNoticeNum());
				result = noticeDAO.setFileAdd(noticeFileDTO);
			}
		}
		
		return result;
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.setDelete(noticeDTO);
	}
}
