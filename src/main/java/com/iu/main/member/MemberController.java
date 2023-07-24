package com.iu.main.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		return "redirect:/"; 
	}
	
}
