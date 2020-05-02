package com.project.chat.chatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.project.chat.user.UserVO;

public class WebSocket extends TextWebSocketHandler implements InitializingBean {
	public static Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>(); 
	public static Map<WebSocketSession , List<String>> sessionInfoList = new HashMap<>();
	public static Map<Integer, Set<WebSocketSession>> roomList = new HashMap<>(); // 해당세션에 대한 세션들
	
    public WebSocket(){
        super();
    }
    // 사용자가 나갈경우 불러오는 메소드 웹소켓세션객체에서 리무브한다
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        
        sessionSet.remove(session);
        System.out.println("connection close");
    }
// 사용자가 웹소켓에 연결되면 불러온다 add 한다
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
    	System.out.println("연결 add");
        super.afterConnectionEstablished(session);
        System.out.println("=========연결 세션 정보 ==========");
        
//        System.out.println(session.getId());
//        System.out.println(session.getHandshakeHeaders());
//        System.out.println(session.getUri());
//        System.out.println(session.toString());
        Map<String,Object> mp = session.getAttributes();
        
        List<String> list = new ArrayList<>();
    	UserVO userVO = (UserVO)mp.get("vo");
    	list.add(userVO.getId());
    	list.add("user");
    	list.add(session.getId());
    	System.out.println("방 들어가야 하는 목록 띄워지냐??" + userVO.getChatRooms());
    	if(userVO.getChatRooms()!=null) {
    		
    		String[] chatRooms = userVO.getChatRooms().split(":");
    		System.out.println(Arrays.toString(chatRooms));
    		for(String s : chatRooms) {
    			if(!s.equals("")) {
    				if(roomList.containsKey(Integer.parseInt(s))) {
        				System.out.println("방 이미 있음");
        				roomList.get(Integer.parseInt(s)).add(session);
        			}else {
        				System.out.println("방 없어서 만듬");
        				Set<WebSocketSession> st = new HashSet<>();
        				st.add(session);
        				roomList.put(Integer.parseInt(s),st );
        			}
    			}
    			
    		}
    	}
    	
        System.out.println("현재 활성 채팅방 :" + roomList.size());
        System.out.println("=============================");
        sessionInfoList.put(session, list);
        sessionSet.add(session);
    }
// 사용자가 채팅할 내용을 적고 보내기를 눌르면 불러온다
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    	System.out.println("받고 보내고 :" + message.getPayload().toString());
    	
        super.handleMessage(session, message);
        String message_s = message.getPayload().toString();
        String[] messages = message_s.split("!ChatKey!");
        System.out.println(Arrays.toString(messages));
        String roomNum = messages[0];
        String content = messages[1];
        String myId = messages[2];
        String myThumbnail = messages[3];
        
        sendMessage(content, roomNum,session,myId,myThumbnail);
    }
//에러
    @Override
    public void handleTransportError(WebSocketSession session,
            Throwable exception) throws Exception {
    	System.out.println("chat error");
    }
 
    @Override
    public boolean supportsPartialMessages() {
    	System.out.println("무언가 1");
        return super.supportsPartialMessages();
    }
// 함수를 따로 정의하였다 메세지를 보내는 함수이다 웹소켓에 저장한 사용자들에게 모두다 보낸다
    public void sendMessage (String message , String roomNum, WebSocketSession session, String myId,String myThumbnail){
    	System.out.println("send : " + message);
    	String json = "{\"type\":\"chat\",\"chat\":\""+message+"\",\"name\":\" " + myId + "\" ,\"date\":\""+new Date()+"\"}" ;
    	System.out.println("send2 : " + json );
    	int roomNum_i = Integer.parseInt(roomNum);
    	
    		System.out.println("flag2");
    		for(WebSocketSession wSession : roomList.get(roomNum_i)) {
    			if (wSession.isOpen()){
                  try{
                      wSession.sendMessage(new TextMessage(json));
                  }catch (Exception ignored){
//                      this.logger.error("fail to send message!", ignored);
                  }
              }
    		}
    	
    	
    	
//        for (WebSocketSession session2: this.sessionSet){
//            if (session2.isOpen()){
//                try{
//                    session2.sendMessage(new TextMessage(json));
//                }catch (Exception ignored){
////                    this.logger.error("fail to send message!", ignored);
//                }
//            }
//        }
    }
// thread로 현새기각을 클라이언트에게 주기적으로 
    @Override
    public void afterPropertiesSet() throws Exception {
        Thread thread = new Thread(){
            int i=0;
            @Override
            public void run() {
                while (true){
                    try {
                        String json = String.format("{\"type\":\"time\",\"time\":\"%s\"}", System.currentTimeMillis());
                        //sendMessage(json);
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
 
        thread.start();
    }
	
}
