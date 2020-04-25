package com.project.chat.friend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.chat.user.UserVO;

@Service
public class FriendServiceImpl implements IFriendService {
	
	@Autowired
	private FriendDAO friendDAO;
	
	@Override
	public List<UserVO> getMyFriends(UserVO userVO) {
		return friendDAO.getMyFriends(userVO);
	}

	@Override
	public List<UserVO> getMyBannedFriends(UserVO userVO) {
		return friendDAO.getMyBannedFriends(userVO);
	}
	
	

}
