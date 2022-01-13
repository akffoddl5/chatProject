package com.project.chat.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void insertUser(UserVO user) {
		userDAO.insertUser(user);
		
	}

	@Override
	public void updateUser(UserVO user) {
		userDAO.updateUser(user);
		
	}

	@Override
	public void deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO selectUser(UserVO user) {
		return userDAO.selectUser(user);
		
	}
	
	@Override
	public UserVO getUser(String id) {
		return userDAO.getUser(id);

	}

	@Override
	public void banCancle(String myId, String banId) {
		userDAO.banCancle(myId, banId);
		
	}
	public int userIdCheck(String user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String test() {
		return userDAO.test();
	}

	



	
	
	

}
