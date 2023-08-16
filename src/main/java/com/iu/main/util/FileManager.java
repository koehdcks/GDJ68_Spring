package com.iu.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.main.file.FileDTO;

@Component
public class FileManager extends AbstractView{

	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FileManager");
		String b = (String)model.get("board");
		FileDTO fileDTO = (FileDTO)model.get("file");
		
		//1. 파일 경로 준비
		String path="/resources/upload/"+b;
		path=request.getSession().getServletContext().getRealPath(path);
		
		//2. File 객체 생성
		File file = new File(path, fileDTO.getFileName());
		
		//3. 파일의 크기 설정
		response.setContentLength((int)file.length());
		
		//4. 다운로드 이름 인코딩 
		String downName = fileDTO.getOriginalName();
		downName = URLEncoder.encode(downName, "UTF-8");
		
		//5. Header 정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//6. 전송
		FileInputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(is, os);
		
		//7. 자원 해제
		os.close();
		is.close();
	}
	
	//fileDelete
	public boolean fileDelete(FileDTO fileDTO,String path,HttpSession session) {
		//1. 어디폴더??
		path= session.getServletContext().getRealPath(path);
		File file = new File(path, fileDTO.getFileName());
		System.out.println(path);
		return file.delete();
	}
	
	//fileSave
	public String fileSave(String path,MultipartFile multipartFile,HttpSession session) throws Exception{
		//파일의 정보를 이용해서 HDD에 파일을 저장
				//1. 어디에 저장??
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
