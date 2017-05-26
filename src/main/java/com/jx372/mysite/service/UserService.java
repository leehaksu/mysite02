package com.jx372.mysite.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jx372.exception.UserDaoException;
import com.jx372.mysite.repository.UserDao;
import com.jx372.mysite.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void join(UserVo uservo)
	{
		//1.DB 사용정보 저장
		userDao.insert(uservo);
		
		//2. 인증 메일 보내기
		
	}
	
	public String login(HttpSession session,Model model,
			@RequestParam(value="email", required=true, defaultValue="") String email, 
			@RequestParam(value="password", required=true, defaultValue="") String password)
	{//email이랑 password 수정해야 함
		
		UserVo uservo = userDao.get(email, password);
		if(uservo == null)
		{
			model.addAttribute("result", "fail");
			
			return "/user/login";
		}
		//로그인 인증
		session.setAttribute("authUser", uservo);
		return "redirect:/";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("/modify")
	public String modify(HttpSession session)
	{
		//인증여부 처크(접근제한)
		UserVo authuser = (UserVo)session.getAttribute("authUser");
		if(authuser==null)
		{
			return " redirect:/user/login";
		}
		
		return "user/modify";

	}
	@ExceptionHandler(UserDaoException.class)
	public String handleUserDaoException()
	{
		
		//1. 로깅
		//2. 사괴 페이지로 안내
		return "error/exception";
	}

}
