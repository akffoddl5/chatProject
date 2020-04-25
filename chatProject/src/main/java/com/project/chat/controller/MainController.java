package com.project.chat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.chat.friend.IFriendService;
import com.project.chat.user.UserVO;

@Controller
public class MainController {
	
	@Autowired
	private IFriendService friendService;
	
	@RequestMapping(value="/myProfile.go")
	ModelAndView goMyProfile(ModelAndView mav) {
		System.out.println("go myProfile");
		mav.setViewName("/myProfile");
		return mav;
	}
	
	@RequestMapping(value="/index.go")
	ModelAndView goIndex(ModelAndView mav,HttpSession session) {
		System.out.println("go index");
		UserVO userVO = (UserVO)session.getAttribute("vo");
		if(userVO != null) {
			List<UserVO> friendList = friendService.getMyFriends(userVO);
			mav.addObject("friendList",friendList);
			mav.addObject("friendNum",friendList.size());
			System.out.println("friend Num :" + friendList.size());
		}
		
		
		mav.setViewName("/index");
		return mav;
	}
	
	
}
