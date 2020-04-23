package com.project.chat.controller;

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
		System.out.println("�α��� ������ �̵�");
		mav.setViewName("/login");
		return mav;
	}
	@RequestMapping(value="/login.do")
	public ModelAndView loginDo(UserVO user,ModelAndView mav , HttpSession session) {
		UserVO userVO = userService.selectUser(user);
		if(userVO.getId() == null) {
			System.out.println("���� ���� �ʴ� ���̵�");
		}else if(user.getPassword().equals(userVO.getPassword())) {
			System.out.println("�α��� ����");
			mav.setViewName("/index");
			return mav;
		}else {
			System.out.println("��й�ȣ ����");
		}
		mav.setViewName("/login");
		return mav;
	}

}
