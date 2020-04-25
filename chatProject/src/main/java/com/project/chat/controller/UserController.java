package com.project.chat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.chat.user.IUserService;
import com.project.chat.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/login.go")
	public ModelAndView loginGo(ModelAndView mav){
		System.out.println("login.go");

		mav.setViewName("/login");
		return mav;
	}
	@RequestMapping(value="/login.do")

	public ModelAndView loginDo(UserVO user,ModelAndView mav , HttpServletRequest request) {
		System.out.println("=======user input ======");
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		UserVO userVO = userService.selectUser(user);
		mav.setViewName("/login");
		if(userVO.getId() == null) {
			System.out.println("no id");
		}else if(user.getPassword().equals(userVO.getPassword())) {
			System.out.println("login success");
			HttpSession session = request.getSession();
			session.setAttribute("vo", userVO);
			mav.setViewName("/index");
			return mav;
		}else {
			System.out.println("password error");
		}
		

		return mav;
	}
	// ---------------- 회원가입 
	@RequestMapping(value="/join.go")
	public ModelAndView joinGo(ModelAndView mav){
		System.out.println("join.go");
		mav.setViewName("/join");
		return mav;
	}
	
	@RequestMapping(value = "/join.do")
	public ModelAndView joinDo(ModelAndView mav,UserVO user) {
		System.out.println("------Join USer Info--------");
		System.out.println(user);
		System.out.println("join.do");
		mav.setViewName("/login");
		return mav;
	}

}
