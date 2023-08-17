package com.iu.main.errors;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice //예외처리 controller
public class ErrorController {
	
	//app 내에서 발생한 모든 Exception을 처리하는 Controller
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String frontError() throws Exception{
		return "errors/front_error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String error1() throws Exception{
		return "errors/front_error";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public void error2() throws Exception{
		
	}
	
	@ExceptionHandler(Exception.class)
	public String error3(Exception ex) {
		System.out.println(ex.getMessage());
		return "errors/front_error";
	}
}
