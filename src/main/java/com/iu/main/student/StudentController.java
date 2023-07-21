package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student/*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getList(ModelAndView mv) throws Exception{
		List<StudentDTO> ls =studentService.getList();
		mv.addObject("list", ls);
		mv.setViewName("student/list");
		
		return mv;
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getDetail(StudentDTO studentDTO,ModelAndView mv) throws Exception{
		studentDTO = studentService.getDetail(studentDTO);
		mv.addObject("dto", studentDTO);
		mv.setViewName("student/detail");
		return mv;
		
	}
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "student/add";
	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(StudentDTO studentDTO,ModelAndView mv) throws Exception{
		int result = studentService.setAdd(studentDTO);
		mv.addObject("dto", studentDTO);
		return "redirect: ./list";
	}
}
