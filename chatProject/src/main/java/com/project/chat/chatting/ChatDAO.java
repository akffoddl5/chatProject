package com.project.chat.chatting;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.chat.user.UserVO;

@Repository
public class ChatDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	List<ChatRoomDTO> getMyChatRooms(UserVO userVO){
		String chatRooms = userVO.getChatRooms();
		String[] chatRoomsArray = chatRooms.split(":");
		
		Map<String,Object> mp = new HashMap<>(); 
		mp.put("chatRoomNumList", chatRoomsArray);
		return sqlSessionTemplate.selectList("getMyChatRooms",mp);
		
	}
	
	
}
