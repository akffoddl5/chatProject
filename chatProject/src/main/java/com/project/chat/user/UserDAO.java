package com.project.chat.user;
import java.util.HashMap;
import java.util.Map;

/**
 * create table chatUser(
 id varchar2(500) primary key,
 password varchar2(500) not null,
 thumbnailPath varchar2(500) default 'default.jpeg'
);

create table friends(
 num number(8) primary key,
 myself varchar2(500),
 friend varchar2(500),
 regdate date default sysdate
);

select * from tab;

select * from chatuser;

alter table chatuser add (stateMessage varchar2(1000) default '');

select * from friends;

insert into chatuser (id,password) values('blue','blue');

create table bannedFriends(
 num number(8) primary key,
 myself varchar2(500),
 friend varchar2(500),
 regdate date default sysdate
);

create sequence bannedFriends_seq;

commit;
 * 
 * 
 */
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
	
	public void insertUser(UserVO userVO) {
		 sqlSessionTemplate.insert("userBatis.insertUser",userVO);
	}
	
	public void banCancle(String myId , String banId) {
		Map<String , String> mp = new HashMap<>();
		mp.put("myId",myId);
		mp.put("banId",banId);
		sqlSessionTemplate.update("userBatis.banCancle",mp);
	}
	
}
