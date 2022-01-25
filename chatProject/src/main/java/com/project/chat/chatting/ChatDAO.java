package com.project.chat.chatting;

import com.project.chat.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ChatDAO {

    private final SqlSessionTemplate sqlSessionTemplate;

    List<ChatRoomDTO> getMyChatRooms(UserVO userVO) {
        String chatRooms = userVO.getChatRooms();
        String[] chatRoomsArray = chatRooms.split(":");

        Map<String, Object> mp = new HashMap<>();
        mp.put("chatRoomNumList", chatRoomsArray);
        return sqlSessionTemplate.selectList("getMyChatRooms", mp);
    }

    int getSoloChatRoomNum(String case1, String case2) {
        Map<String, String> mp = new HashMap<>();
        mp.put("case1", case1);
        mp.put("case2", case2);
        String num_s = sqlSessionTemplate.selectOne("getSoloChatRoomNum", mp); // list 나올수 있지만 배제
        if (num_s != null) return Integer.parseInt(num_s);
        else return -1;

    }

    void insertChat(ChatContentDTO chatContentDTO) {
        sqlSessionTemplate.insert("insertChat", chatContentDTO);
    }


}
