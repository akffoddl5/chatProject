package com.project.chat.chatting;

import lombok.Data;

import java.util.Date;

@Data
public class ChatContentDTO {
	
	int num;
	int roomNum;
	String id;
	String content;
	String thumnailPath;
	Date regDate;
	
}
