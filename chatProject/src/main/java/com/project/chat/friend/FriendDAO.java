package com.project.chat.friend;

import java.util.List;

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
	
	List<UserVO> getMyBannedFriends(UserVO userVO){
		return sqlSessionTemplate.selectList("friendBatis.getMyBannedFriends",userVO);
	}
	
}
