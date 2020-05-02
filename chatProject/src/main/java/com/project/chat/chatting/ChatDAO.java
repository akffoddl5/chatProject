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
	
	int getSoloChatRoomNum(String case1 , String case2) {
		Map<String, String> mp = new HashMap<>();
		mp.put("case1", case1);
		mp.put("case2", case2);
		String num_s = sqlSessionTemplate.selectOne("getSoloChatRoomNum",mp); // list 나올수 있지만 배제
		if(num_s != null) return Integer.parseInt(num_s);
		else return -1;
		
	}
	
	
}
