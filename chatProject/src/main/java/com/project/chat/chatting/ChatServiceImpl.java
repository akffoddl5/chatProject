package com.project.chat.chatting;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.chat.user.UserVO;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements IChatService {
	
	private final ChatDAO chatDAO;
	
	public List<ChatRoomDTO> getMyChatRooms(UserVO userVO){
		return chatDAO.getMyChatRooms(userVO);
	}

	@Override
	public int getSoloChatRoomNum(String case1, String case2) {
		return chatDAO.getSoloChatRoomNum(case1, case2);
	}

	@Override
	public void insertChat(ChatContentDTO chatContentDTO) {
		chatDAO.insertChat(chatContentDTO);
	}
	
	
}
