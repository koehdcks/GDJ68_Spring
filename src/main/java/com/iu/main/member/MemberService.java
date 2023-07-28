package com.iu.main.member;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
	public int setJoin(MemberDTO memberDTO,MultipartFile multipartFile,HttpSession session) throws Exception{
		int result = memberDAO.setJoin(memberDTO);
		
		
		
		if(!multipartFile.isEmpty()) {
		String fileName = fileManager.fileSave( "member",multipartFile, session);
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setOriginalName(multipartFile.getOriginalFilename());
		memberFileDTO.setFileName(fileName);
		result = memberDAO.setFileJoin(memberFileDTO);
		}
		
		
		return result;
	}
}
