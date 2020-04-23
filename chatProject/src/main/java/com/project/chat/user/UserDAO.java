package com.project.chat.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public UserVO selectUser(UserVO userVO) {
		return sqlSessionTemplate.selectOne("UserBatis.getUser",userVO);
	}
	
}
