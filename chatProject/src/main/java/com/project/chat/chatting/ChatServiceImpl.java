package com.project.chat.chatting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.chat.user.UserVO;

@Service
public class ChatServiceImpl implements IChatService {
	
	@Autowired
	private ChatDAO chatDAO;
	
	public List<ChatRoomDTO> getMyChatRooms(UserVO userVO){
		return chatDAO.getMyChatRooms(userVO);
	}

	@Override
	public int getSoloChatRoomNum(String case1, String case2) {
		return chatDAO.getSoloChatRoomNum(case1, case2);
	}
	
	
}
