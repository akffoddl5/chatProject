package com.project.chat.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public UserVO selectUser(UserVO userVO) {
		return sqlSessionTemplate.selectOne("userBatis.getUser",userVO);
	}
	
}
