package com.iu.main.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping(value="join",method = RequestMethod.GET)
	public String getJoin() throws Exception{
		return "member/join";
	}
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String getLogin() throws Exception{
		return "member/login";
	}
	@RequestMapping(value="mypage",method = RequestMethod.GET)
	public String getMyPage() throws Exception{
		return "member/mypage";
	}
}
