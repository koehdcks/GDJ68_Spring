package com.iu.main.member;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
	public int setJoin(MemberDTO memberDTO,MultipartFile multipartFile,HttpSession session) throws Exception{
		//파일의 정보를 이용해서 HDD에 파일을 저장
		//1. 어디에 저장??
		String path="/resources/upload/member/";
		//2. 실제 경로 알아오기
		//jsp : application
		//java : ServletContext
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath); 
		//3. 경로에 맞는 폴더가 없으면 만들어라 
		if(!file.exists()) {
			file.mkdirs();
		}
		
		Calendar ca = Calendar.getInstance();
		long result = ca.getTimeInMillis();
		
		file = new File(file,result+"_"+multipartFile.getOriginalFilename());
		//4.파일을 저장
//		//A. Spring에서 제공하는 API FileCopyUtils의 copy메서드
//		FileCopyUtils.copy(multipartFile.getBytes(), file); //멀티파트파일을 realPath경로에 오리지널 파일네임으로 저장
		
		//B. MultipartFile의 transfetTo메서드
		multipartFile.transferTo(file);
		
		//		return memberDAO.setJoin(memberDTO);
		return 0;
	}
}
