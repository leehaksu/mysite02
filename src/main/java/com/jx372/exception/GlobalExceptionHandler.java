package com.jx372.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
		
	@ExceptionHandler( UserDaoException.class )
		public ModelAndView handleDaoException( Exception e ) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		//1. 로깅
		
		//2. 안내페이지 가기
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", errors.toString());
		mav.setViewName("error/exception");
				return mav;
		}

}
