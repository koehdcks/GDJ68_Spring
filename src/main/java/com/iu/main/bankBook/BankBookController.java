package com.iu.main.bankBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList() throws Exception {
		System.out.println("list");
		bankBookService.service();
		return "bankbook/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail() throws Exception{
		System.out.println("detail");
		return "bankbook/detail";
	}
	@RequestMapping(value="add",method = RequestMethod.GET)
	public String getAdd() throws Exception{
		return "bankbook/add";
	}
	
	@RequestMapping(value="update",method = RequestMethod.GET)
	public String getUpdate() throws Exception{
		return "bankbook/update";
	}
}
