package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {
		List<BankBookDTO>  ar = bankBookService.getList();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
	}
	
	//폼이동
	@RequestMapping(value="add",method = RequestMethod.GET)
	public void setAdd() throws Exception{
		
	}
	
	//db insert
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(BankBookDTO bankBookDTO) throws Exception{
		int result = bankBookService.setAdd(bankBookDTO);
		return "redirect: ./list";
	}
	
	@RequestMapping(value="update",method = RequestMethod.GET)
	public void getUpdate() throws Exception{
	}
}
