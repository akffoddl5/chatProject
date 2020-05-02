package com.project.chat.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.chat.chatting.ChatContentDTO;
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
		if(roomNum == -1) {
			// 아직 방 없을경우 방 만들어야댐
		}
		System.out.println("개인방 번호 : "+roomNum);
		mav.addObject("data",roomNum);
		mav.setViewName("/ajaxForPrint");
		return mav;
	}
	
	@RequestMapping(value =  "/insertChat.do")
	ModelAndView insertChat(ModelAndView mav, HttpServletRequest request) {
		String myId = request.getParameter("myId");
		String content = request.getParameter("content");
		String roomNum = request.getParameter("roomNum");
		String thumbnail = request.getParameter("thumnailPath");
		
		ChatContentDTO chatContentDTO = new ChatContentDTO();
		chatContentDTO.setId(myId);
		chatContentDTO.setContent(content);
		chatContentDTO.setRoomNum(Integer.parseInt(roomNum));
		chatContentDTO.setThumnailPath(thumbnail);
		chatService.insertChat(chatContentDTO);
		
		mav.setViewName("/ajaxForPrint");
		return mav;
	}

}
