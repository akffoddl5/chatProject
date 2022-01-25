package com.project.chat.chatting;

import lombok.Data;

import java.util.Date;

@Data
public class ChatRoomDTO {
	
	int num;
	String participants;
	Date regDate;
	Date recentDate;
	String recentContent;
	
	
}
