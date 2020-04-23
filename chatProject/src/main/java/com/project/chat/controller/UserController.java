package com.project.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping(value="/login.go")
	public ModelAndView loginGo(ModelAndView mav){
		mav.addObject("id","red");
		mav.setViewName("/index");
		return mav;
	}
	@RequestMapping(value="/login.do")
	public ModelAndView loginDo(ModelAndView mav) {
		mav.setViewName("/login");
		return mav;
	}

}
