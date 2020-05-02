package com.project.chat.user;

public interface IUserService {
	
	void insertUser(UserVO user);
	void updateUser(UserVO user);
	void deleteUser(UserVO user);
	UserVO selectUser(UserVO user);
	UserVO getUser(String id);
	void banCancle(String myId , String banId);
	int userIdCheck(String user_id); //���̵� �ߺ� üũ
	
}
