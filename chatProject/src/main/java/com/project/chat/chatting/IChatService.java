package com.project.chat.chatting;

import java.util.List;

import com.project.chat.user.UserVO;

public interface IChatService {
	public List<ChatRoomDTO> getMyChatRooms(UserVO userVO);
}
