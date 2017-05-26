package com.jx372.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jx372.mysite.service.UserService;
import com.jx372.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService  userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join()
	{
		return "/user/joinform";	
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo)
	{
		userService.join(userVo);
		
		return "redirect:/user/joinsuccess";	
	}
	@RequestMapping(value="/joinsuccess")
	public String joinsuccess()
	{
		return "redirect:/user/joinsuccess";	
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login()
	{
		return "/user/login";	
	}
/*	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login()
	{
		return "/user/login";	
	}
*/	
	
	
	
}
