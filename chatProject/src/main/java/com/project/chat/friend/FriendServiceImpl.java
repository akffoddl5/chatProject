package com.project.chat.friend;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.chat.user.UserVO;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements IFriendService {

	private final FriendDAO friendDAO;

	@Override
	public List<UserVO> getMyFriends(UserVO userVO) {
		return friendDAO.getMyFriends(userVO);
	}

	@Override
	public List<UserVO> getAllMyFriends(UserVO userVO) {
		return friendDAO.getAllMyFriends(userVO);

	}
	
	@Override
	public List<UserVO> getMyBannedFriends(UserVO userVO) {
		return friendDAO.getMyBannedFriends(userVO);
	}


	@Override
	public void addFriend(String myId, String plusId) {
		friendDAO.addFriend(myId, plusId);
	}

	@Override
	public void blockFriend(String myId, String plusId) {
		friendDAO.blockFriend(myId, plusId);
		
	}

	
}
