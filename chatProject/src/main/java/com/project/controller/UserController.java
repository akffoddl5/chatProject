package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("UserController")
@RequestMapping("")
public class UserController {
	
	@RequestMapping(value="login.go")
	public String Logingo(Model model){
		return "login";
	}
	@RequestMapping(value="login.do")
	public String Logindo(Model model) {
		return null;
	}

}
