package com.iu.main.bookACCount;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bookACCount/*")
public class BookACCountController {
	@Autowired
	private BookACCountService bookACCountService;
	
	
//	public void getList(Pager pager,HttpSession session,) throws Exception {
//		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		List<BookACCountDTO> ar = bookACCountService.getList(memberDTO);
//		
//	}
	
	@GetMapping(value = "add")  // requestmapping method = get 합친것
	public void setAdd(BookACCountDTO bookACCountDTO,Model model) throws Exception{
		model.addAttribute("dto", bookACCountDTO);
	}
	@PostMapping(value = "add")  // requestmapping method = post 합친것
	public String setAdd(BookACCountDTO bookACCountDTO,HttpSession session,Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		bookACCountDTO.setId(memberDTO.getId());
		int result = bookACCountService.setAdd(bookACCountDTO);
		
//		String message="상품가입이 실패";
//		if(result>0) {
//			message="상품가입이 완료";
//		}
//		model.addAttribute("message", message);
//		model.addAttribute("url","../");
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	@GetMapping("list")
	public ModelAndView getList(Pager pager,HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<BookACCountDTO> ar = bookACCountService.getList(pager,memberDTO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("bookACCount/list");
		
		return mv;
		
	}
	
	
}
