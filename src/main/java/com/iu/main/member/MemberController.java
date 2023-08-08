package com.iu.main.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public void getLogin() throws Exception{
		
	}
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String getLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		memberDTO = memberService.getLogin(memberDTO);
		
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
		}
		return "redirect:../"; 
	}
	
	//로그아웃
	@RequestMapping(value="logout",method = RequestMethod.GET)
	public String getLogout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../"; 
	}
	@RequestMapping(value="mypage",method = RequestMethod.GET )
	public void getMypage() throws Exception{
		
	}
	//update
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public void setMemberUpdate()throws Exception{
		
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String setMemberUpdate(MemberDTO memberDTO,HttpSession session)throws Exception{
		MemberDTO sessionMember =(MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionMember.getId());
		int result = memberService.setMemberUpdate(memberDTO);
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect: ./mypage";
	}
	@RequestMapping(value = "join",method = RequestMethod.GET)
	public void setJoin() throws Exception{
		
	}
	@RequestMapping(value = "join",method = RequestMethod.POST)
	public String setJoin(MemberDTO memberDTO,MultipartFile pic,HttpSession session) throws Exception{
		int resut = memberService.setJoin(memberDTO,pic,session);
		
		return "redirect:../";
	}
	
	@GetMapping("idCheck")
	public String getIdCheck(MemberDTO memberDTO,Model model) throws Exception {
		memberDTO = memberService.getIdCheck(memberDTO);
		
		int result=0;  //중복
		if(memberDTO == null) {
			result=1; //중복 아님
		}
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
}
