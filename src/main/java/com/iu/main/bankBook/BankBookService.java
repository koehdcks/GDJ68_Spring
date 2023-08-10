package com.iu.main.bankBook;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	@Autowired
	private FileManager fileManager;
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDatail(bankBookDTO);
	}
	
	public List<BankBookDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		Long total = bankBookDAO.getTotal(pager);
		pager.makePageNum(total);
		return bankBookDAO.getList(pager);
	}
	
	public int setAdd(BankBookDTO bankBookDTO,MultipartFile[] files,HttpSession session) throws Exception{

		int result = bankBookDAO.setAdd(bankBookDTO);
		if(files.length!=0) {
			for(int i=0;i<files.length;i++) {
				String fileName = fileManager.fileSave("bankBook", files[i], session);
				BankBookFileDTO bankBookFileDTO = new BankBookFileDTO();
				bankBookFileDTO.setOriginalName(files[i].getOriginalFilename());
				bankBookFileDTO.setFileName(fileName);
				bankBookFileDTO.setBookNum(bankBookDTO.getBookNum());
				result = bankBookDAO.setFileAdd(bankBookFileDTO);
			}
		}		
			
		return result;
	}
	
	public int setDelete(Long num) throws Exception{
		return bankBookDAO.setDelete(num);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	//-------------comment
	public List<BankBookCommentDTO> getComment(Pager pager,BankBookCommentDTO bankBookCommentDTO) throws Exception{
		Map<String, Object> map = new HashMap<String,Object>();
		pager.makeRowNum();
		pager.makePageNum(bankBookDAO.getCommentTotal(bankBookCommentDTO));
		map.put("pager", pager);
		map.put("comment", bankBookCommentDTO);
		
		return bankBookDAO.getComment(map);
	}
}
