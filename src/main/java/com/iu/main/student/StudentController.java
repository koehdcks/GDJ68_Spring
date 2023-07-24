package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		studentDTO.setStuTotal(studentDTO.getStuKor()+studentDTO.getStuEng()+studentDTO.getStuMath());
		studentDTO.setStuAvg(studentDTO.getStuTotal()/3.0);
		int result = studentService.setAdd(studentDTO);
		mv.addObject("dto", studentDTO);
		return "redirect: ./list";
	}
	
	@RequestMapping(value = "update", method =RequestMethod.GET)
	public void setUpdate(StudentDTO studentDTO,Model model) throws Exception{
		studentDTO = studentService.getDetail(studentDTO);
		model.addAttribute("dto",studentDTO);
	}
	
	@RequestMapping(value = "update", method =RequestMethod.POST)
	public String setUpdate(StudentDTO studentDTO) throws Exception{
		studentDTO.setStuTotal(studentDTO.getStuKor()+studentDTO.getStuEng()+studentDTO.getStuMath());
		studentDTO.setStuAvg(studentDTO.getStuTotal()/3.0);
		int result = studentService.setUpdate(studentDTO);
		return "redirect: ./detail?stuNum=" +studentDTO.getStuNum();
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String setDelete(StudentDTO studentDTO) throws Exception{
		int result = studentService.setDelete(studentDTO);
		return "redirect: ./list";
	}
	
}
