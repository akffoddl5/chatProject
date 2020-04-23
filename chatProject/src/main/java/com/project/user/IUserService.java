package com.project.user;

public interface IUserService {
	
	void insertUser(UserVO user);
	void updateUser(UserVO user);
	void deleteUser(UserVO user);
	void selectUser(UserVO user);
}
