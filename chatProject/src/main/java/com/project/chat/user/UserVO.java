package com.project.chat.user;

import lombok.Data;

@Data
public class UserVO {
	
	String id;
	String password;
	String thumbnailPath;
	String stateMessage;
	String chatRooms;

	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", thumbnailPath=" + thumbnailPath + ", stateMessage="
				+ stateMessage + "]";
	}
	
		

}
