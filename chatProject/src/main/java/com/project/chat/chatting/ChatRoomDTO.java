package com.project.chat.chatting;

import java.util.Date;

public class ChatRoomDTO {
	
	int num;
	String participants;
	Date regDate;
	Date recentDate;
	String recentContent;
	
	public String getRecentContent() {
		return recentContent;
	}
	public void setRecentContent(String recentContent) {
		this.recentContent = recentContent;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getParticipants() {
		return participants;
	}
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getRecentDate() {
		return recentDate;
	}
	public void setRecentDate(Date recentDate) {
		this.recentDate = recentDate;
	}
	
	
	
}
