package com.project.chat.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.chat.chatting.IChatService;

@Controller
public class ChatController {
	
	@Autowired
	IChatService chatService;
	
	@RequestMapping(value="/soloChatStart.do")
	ModelAndView soloChatServiceStart(ModelAndView mav , HttpServletRequest request) {
		System.out.println("soloChatStart exe");
		String myId = request.getParameter("myId");
		String partnerId = request.getParameter("partnerId");
		System.out.println(myId + " " + partnerId);
		String case1 = myId+":"+partnerId;
		String case2 = partnerId+":"+myId;
		
		int roomNum = chatService.getSoloChatRoomNum(case1, case2);
		
		System.out.println("개인방 번호 : "+roomNum);
		mav.addObject("data",roomNum);
		mav.setViewName("/ajaxForPrint");
		return mav;
	}

}
