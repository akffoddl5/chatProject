package com.project.chat.friend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.chat.user.UserVO;

@Repository
public class FriendDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	List<UserVO> getMyFriends(UserVO userVO){
		return sqlSessionTemplate.selectList("friendBatis.getMyFriends",userVO);
		
	}
	
	List<UserVO> getAllMyFriends(UserVO userVO){
		return sqlSessionTemplate.selectList("friendBatis.getAllMyFriends",userVO);
		
	}

	
	List<UserVO> getMyBannedFriends(UserVO userVO){
		return sqlSessionTemplate.selectList("friendBatis.getMyBannedFriends",userVO);
	}
	
	void addFriend(String myId , String plusId) {
		Map<String,String> mp = new HashMap<>();
		mp.put("myId",myId);
		mp.put("plusId", plusId);
		sqlSessionTemplate.update("friendBatis.addFriend",mp);
	}
	
	void blockFriend(String myId, String plusId) {
		Map<String,String> bp = new HashMap<>();
		bp.put("myId",myId);
		bp.put("plusId",plusId);
		sqlSessionTemplate.insert("friendBatis.blockFriend",bp);

	}
}
