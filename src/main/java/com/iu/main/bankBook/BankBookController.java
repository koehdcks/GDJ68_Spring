package com.iu.main.bankBook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
											//requestParam으로 파라미터 기본값 설정
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Pager pager,Model  model) throws Exception {
		List<BankBookDTO>  ar = bankBookService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/detail");
		
		return mv;
	}
	
	//form
	@RequestMapping(value="add",method = RequestMethod.GET)
	public void setAdd() throws Exception{
		
	}
	
	//db insert
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(BankBookDTO bankBookDTO,MultipartFile[] photos,HttpSession session) throws Exception{
		int result = bankBookService.setAdd(bankBookDTO,photos,session);
		return "redirect: ./list";
	}
	
	//수정form
	@RequestMapping(value="update",method = RequestMethod.GET)
	public void setUpdate(BankBookDTO bankBookDTO,Model model) throws Exception{
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
	}
	
	//db update
	@RequestMapping(value="update",method = RequestMethod.POST)
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.setUpdate(bankBookDTO);
		return "redirect: ./detail?bookNum="+bankBookDTO.getBookNum();
		
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String setDelete(Long bookNum) throws Exception{
		int result = bankBookService.setDelete(bookNum);
		return "redirect: ./list";
	}
	//-------------------comment----------------------------
	@GetMapping(value = "comment")
	public void getComment(Pager pager,BankBookCommentDTO bankBookCommentDTO,Model model) throws Exception{
		pager.setPerPage(2L);
		List<BankBookCommentDTO> ar = bankBookService.getComment(pager,bankBookCommentDTO);
		model.addAttribute("commentList", ar);
	}
	
	@PostMapping(value = "commentAdd")
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO,HttpSession session,Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		bankBookCommentDTO.setId(memberDTO.getId());
		int result=bankBookService.setCommentAdd(bankBookCommentDTO);
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
}


