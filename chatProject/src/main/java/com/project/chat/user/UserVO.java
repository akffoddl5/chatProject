package com.project.chat.user;

public class UserVO {
	
	String id;
	String password;
	String thumbnailPath;
	String stateMessage;
	String chatRooms;
	public String getChatRooms() {
		return chatRooms;
	}
	public void setChatRooms(String chatRooms) {
		this.chatRooms = chatRooms;
	}
	public String getStateMessage() {
		return stateMessage;
	}
	public void setStateMessage(String stateMessage) {
		this.stateMessage = stateMessage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", thumbnailPath=" + thumbnailPath + ", stateMessage="
				+ stateMessage + "]";
	}
	
		

}
