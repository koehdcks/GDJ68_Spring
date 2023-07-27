package com.iu.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.main.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String getList(Pager pager,String kind,Model model) throws Exception{
		List<NoticeDTO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
		
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "board/add";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO,Model model) throws Exception{
		int result = noticeService.setAdd(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "detail",method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO,Model model) throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/detail";
	}
	
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public String setUpdate(NoticeDTO noticeDTO,Model model) throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/update";
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:./detail?noticeNum="+noticeDTO.getNoticeNum();
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String setDelete(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.setDelete(noticeDTO);
		return "redirect:./list";
	}
	
}
