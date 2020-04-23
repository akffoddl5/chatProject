package com.project.chat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void insertUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO selectUser(UserVO user) {
		return userDAO.selectUser(user);
		
	}
	

}
