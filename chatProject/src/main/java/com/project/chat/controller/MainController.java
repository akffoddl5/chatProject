package com.project.chat.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.chat.chatting.ChatRoomDTO;
import com.project.chat.chatting.IChatService;
import com.project.chat.friend.IFriendService;
import com.project.chat.user.IUserService;
import com.project.chat.user.UserVO;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MainController {


	private final IUserService userService;

	private final IFriendService friendService;

	private final IChatService chatService;
	
	@RequestMapping(value="/")
	ModelAndView defaultIndex(ModelAndView mav) {
		System.out.println("defaultIndex");
		mav.setViewName("/myProfile");
		return mav;
	}
	
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
	
	@RequestMapping(value="/bannedFriends.go")
	ModelAndView goBannedFriends(ModelAndView mav,HttpSession session) {
		System.out.println("go index");
		UserVO userVO = (UserVO)session.getAttribute("vo");
		if(userVO != null) {
			List<UserVO> bannedFriendList = friendService.getMyBannedFriends(userVO);
			mav.addObject("bannedFriendList",bannedFriendList);
			mav.addObject("bannedFriendNum",bannedFriendList.size());
			System.out.println("bannedFriend Num :" + bannedFriendList.size());
		}
		
		
		mav.setViewName("/bannedFriends");
		return mav;
	}
	
	@RequestMapping(value ="chattings.go")
	ModelAndView goChattings(ModelAndView mav, HttpServletRequest request){
		UserVO userVO = (UserVO)request.getSession().getAttribute("vo");
		List<ChatRoomDTO> list = null;
		if(userVO!=null) {
			list = chatService.getMyChatRooms(userVO);
			mav.addObject("myChatRooms",list);
			
			System.out.println("梨꾪똿諛� �닔 : "+list.size());
		}
		
		
		
		mav.setViewName("/chattings");
		return mav;
	}
	
	@RequestMapping(value ="makeNewFriends.go")
	ModelAndView goMakeNewFriends(ModelAndView mav,HttpSession session) {
		UserVO userVO = (UserVO)session.getAttribute("vo");
		System.out.println("접속중인 계정 정보 [추천 제외 계정] : " + userVO.getId());
		HashSet<String> hs = new HashSet<>();
		List<ChatRoomDTO> chatRoom = chatService.getMyChatRooms(userVO);
		for (ChatRoomDTO chatRoomDTO : chatRoom) {
			String[] partipants = chatRoomDTO.getParticipants().split(":");
			for(String par:partipants) {
				hs.add(par);
			}
	}
		hs.remove(userVO.getId());
		List<UserVO> friends = friendService.getAllMyFriends(userVO);
		List<UserVO> reFriends = new ArrayList<>();
		System.out.println(friends);
		for(UserVO friendId :friends) {
			hs.remove(friendId.getId());
		}
		System.out.println("추천 친구 닉네임 : " + hs);
		for(String ms:hs) {
			System.out.println("AA" + ms);
			UserVO reFriend = userService.getUser(ms);
			System.out.println(reFriend);
			reFriends.add(reFriend);
		}
		System.out.println("추천친구 VO" + reFriends);
		mav.addObject("reFriendsList",reFriends);
		mav.setViewName("/makeNewFriends");
		return mav;
	}
	
	@RequestMapping(value = "modalPrac.go")
	ModelAndView goModalPrac(ModelAndView mav) {
		mav.setViewName("/modalPrac");
		return mav;
	}
	
	@RequestMapping(value = "addReFriend.do")
	ModelAndView addReFriend(@RequestParam("friendId") String friend_id , ModelAndView mav , HttpSession session) {
		System.out.println(friend_id);
		UserVO userVO = (UserVO) session.getAttribute("vo");
		friendService.addFriend(userVO.getId(), friend_id);
		mav.setViewName("redirect:/index.go");
		return mav;
	}
	
	@RequestMapping(value ="friendBlock.do")
	ModelAndView friendBlock(@RequestParam("friendId") String friend_Id,ModelAndView mav,HttpSession session){
		UserVO user = (UserVO)session.getAttribute("vo");
		System.out.println("ASDFASDF");
		friendService.blockFriend(user.getId(),friend_Id);
		mav.setViewName("redirect:bannedFriends.go");
		return mav;
	}
	
}
	

