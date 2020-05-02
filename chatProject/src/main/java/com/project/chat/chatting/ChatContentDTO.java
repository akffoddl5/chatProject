package com.project.chat.chatting;

import java.util.Date;

public class ChatContentDTO {
	
	int num;
	int roomNum;
	String id;
	String content;
	String thumnailPath;
	Date regDate;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getThumnailPath() {
		return thumnailPath;
	}
	public void setThumnailPath(String thumnailPath) {
		this.thumnailPath = thumnailPath;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
