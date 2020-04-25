package com.project.chat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
			mav.setViewName("redirect:index.go");
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
		userService.insertUser(user);
		mav.setViewName("/login");
		return mav;
	}
	
	//----------------------아이디 중복체크 컨트롤럴
	@RequestMapping(value = "/idCheck")
	public int idCheck(@RequestParam("userId") String user_id) {	
		return userService.userIdCheck(user_id);
	}
	
	// ---------------------------회원 정보 수정 
	@RequestMapping(value = "/updateUser.do")
	public ModelAndView updateUser(ModelAndView mav,UserVO user ,HttpServletRequest request) {
		System.out.println("------updateUser Info--------");
		System.out.println(user);
		userService.updateUser(user);
		UserVO userVO = userService.selectUser(user);
		HttpSession session = request.getSession();
		session.setAttribute("vo", userVO);
		mav.setViewName("redirect:myProfile.go");
		return mav;
	}

}
