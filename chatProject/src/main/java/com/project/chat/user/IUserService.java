package com.project.chat.user;

public interface IUserService {
	
	void insertUser(UserVO user);
	void updateUser(UserVO user);
	void deleteUser(UserVO user);
	UserVO selectUser(UserVO user);
	int userIdCheck(String user_id); //아이디 중복 체크
	
}
