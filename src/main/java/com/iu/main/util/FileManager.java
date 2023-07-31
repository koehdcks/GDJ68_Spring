package com.iu.main.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	//fileSave
	public String fileSave(String path,MultipartFile multipartFile,HttpSession session) throws Exception{
		//파일의 정보를 이용해서 HDD에 파일을 저장
				//1. 어디에 저장??
				path="/resources/upload/"+path+"/";
				//2. 실제 경로 알아오기
				//jsp : application
				//java : ServletContext
				String realPath = session.getServletContext().getRealPath(path);
				System.out.println(realPath);
				File file = new File(realPath); 
				//경로에 맞는 폴더가 없으면 만들어라 
				if(!file.exists()) {
					file.mkdirs();
				}
				// 3. 어떤이름으로 저장??
				//1)시간을 이용
//				Calendar ca = Calendar.getInstance();
//				long result = ca.getTimeInMillis();	
//				file = new File(file,result+"_"+multipartFile.getOriginalFilename());
				
				//2)API 사용
				String uId = UUID.randomUUID().toString();
				uId = uId+"_"+multipartFile.getOriginalFilename();
				file = new File(file,uId);
				
				//4.파일을 저장
//				//A. Spring에서 제공하는 API FileCopyUtils의 copy메서드
//				FileCopyUtils.copy(multipartFile.getBytes(), file); //멀티파트파일을 realPath경로에 오리지널 파일네임으로 저장
				
				//B. MultipartFile의 transfetTo메서드
				multipartFile.transferTo(file);
				return uId;
	}

	
	
	
}