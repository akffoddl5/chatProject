package com.project.chat.friend;

import java.util.List;

import com.project.chat.user.UserVO;

public interface IFriendService {
	public List<UserVO> getMyFriends(UserVO userVO);
	public List<UserVO> getAllMyFriends(UserVO userVO);
	public List<UserVO> getMyBannedFriends(UserVO userVO);
	public void addFriend(String myId, String plusId);
	public void blockFriend(String myId,String plusId);
}
