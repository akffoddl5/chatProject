<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by TEMPLATED
http://templated.co
Released for free under the Creative Commons Attribution License

Name       : Skeleton 
Description: A two-column, fixed-width design with dark color scheme.
Version    : 1.0
Released   : 20130902

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<link href="resources/css/default.css" rel="stylesheet" type="text/css" media="all" />

<link href="resources/css/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
function friendClick(id){

	document.getElementById("partner").textContent= id;
	alert("soloChat 상대 : "+id);
  	var myId = '${vo.id}';
  	var query = {"myId" : myId , "partnerId" : id};
  	$.ajax({
  		url : "soloChatStart.do",
  		type : 'POST',
  		data : query,
  		success : function(data) {
  			alert("방 번호 부여 받음 :" + data);
  			document.getElementById("hiddenId").value = id;
  			document.getElementById("hiddenNum").value = data;
  			// 웹소켓 열기 여기서.  근데 걍 index 할때 웹소켓 열래
  			//var wsUri = "ws://localhost:8080/chat/echo.do";
  		}
  	});
  	
  	
	
}

function friendBlock(id){
	
	alert("DDD");
	if(confirm(id +"님을 차단하시겠습니까 ? ")){
		alert("차단 하였습니다");
		location.href="/chat/friendBlock.do?friendId="+id
		
	}
	else{
		return false;
	}


}
</script>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$(document).ready(function(){
	   
	   //var wsUri = "ws://172.30.1.46:8080/chat/echo.do";
	   var wsUri = "ws://localhost:8080/chat/echo.do";
	    websocket = new WebSocket(wsUri);
	//딱봐도 알거라고 믿겟음 함수명이 모든걸 말아주고있져?
	    websocket.onopen = function(evt) {
		alert("socket 정상적으로 열음");
	        onOpen(evt)
	    };
	//것도 메시지보내는
	    websocket.onmessage = function(evt) {
	      //alert(evt + "받는?");
	      //printMessage(evt);
	        onMessage(evt);
	    };
	    
	    websocket.onclose = function(message){

	    	
			alert(message);
			websocket = new WebSocket(wsUri);
        };
	    
	    function printMessage(evt){
	    	alert("chat 받았음");
	       $("#chatList").append(evt);
	    }
	    
	//에러
	    websocket.onerror = function(evt) {
	        onError(evt)
	    };
	   
	    
	    
	    $("#eachList").click(function(){
		      alert("eachlist click");
		      websocket = new WebSocket(wsUri);
		     
		       
		});
	    
	    
	    
	    $("#chatSendBtn").click(function(){
	       var content = document.getElementById("chatSend").value;
	       var partnerId = document.getElementById("hiddenId").value;
	       var roomNum = document.getElementById("hiddenNum").value;
	       var myId = '${vo.id}';
	       var myThumbnail = '${vo.thumbnailPath}';
	       alert(myId);
	       var finalValue = roomNum+"!ChatKey!"+content+"!ChatKey!"+myId+"!ChatKey!"+myThumbnail;
	       doSend(finalValue);
	       $('#chatSend').val('');
	       
	       var query = {"myId" : myId ,"content" : content, "roomNum" : roomNum,"thumnailPath":myThumbnail};
	       $.ajax({
	            type: "POST",
	            url: "insertChat.do",
	            data: query,
	            success: function(data){
	                  alert("디비 넣었음");
	            }
	         });
	       
	       
	    });
	    
	    function onOpen(evt) {
	       $("#chatList").prepend("관리자와의 채팅이 시작되었습니다.");
	    }

	    function onMessage(evt) {
			alert("chat 받았음");
	        var recv = JSON.parse(evt.data);
	        if(recv.type=='time')
	            $('#time').text(recv.time);
	        else if(recv.type=='chat'){
	           //alert("chat 들어옴");
	            var str = '<li style="">';
	            str += '<table cellpadding="0" cellspacing="0">';
	            str += '<tr>';
	            
	            str += '<td class="chat_td">';
	            str += '<div style="font-size:14px;" class="email">'
	            str += "아이디 :"+recv.name;
	            str += '</div>';
	            str += '<div class="chat_preview">';
	            str += recv.chat;
	            str += '</div></td>';
	            str += '</tr></table></li>';
	            $("#chatList").append(str);
	        }
	        
	        el = document.getElementById('chatList');

	        if (el.scrollHeight > 0) el.scrollTop = el.scrollHeight;
	        
	    }

	    function onError(evt) {
	    }

	    function doSend(message) {
	       
	        websocket.send(message);
	    }
	    // 주기적으로 시간표시
	    function getCurrentTime(){
	        
	        var Now = new Date();
	        var NowTime = Now.getFullYear();

	        NowTime += '-' + Now.getMonth() + 1 ;
	        NowTime += '-' + Now.getDate();
	        NowTime += ' ' + Now.getHours();
	        NowTime += ':' + Now.getMinutes();
	        NowTime += ':' + Now.getSeconds();

	        return NowTime;
	    }
	    
	   
	   
	});



</script>



</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img src="resources/images/${vo.thumbnailPath }" style="height: 70px; width: 70px;" alt="" />
			<h1><a href="#">${vo.id }</a></h1>
			<span><a href="http://templated.co" rel="nofollow">회원탈퇴</a></span>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="index.go" accesskey="1" title="">My Friends</a></li>
				<li><a href="chattings.go" accesskey="2" title="">Chattings</a></li>
				<li><a href="makeNewFriends.go" accesskey="3" title="">MAKE NEW FRIENDS</a></li>
				<li><a href="bannedFriends.go" accesskey="4" title="">Banned Friends</a></li>
				<li><a href="myProfile.go" accesskey="5" title="">My Profile</a></li>
			</ul>
		</div>
	</div>
	<div id="main">
		
		
		<div id="featured">
			<div class="title">
				<h2>My Friends</h2>
				<span class="byline">내 친구들과 대화하세요.</span>
			</div>
			<ul class="style1">
			
			<c:forEach items="${friendList }" var="friendVO">
				<li style="cursor: pointer;" id="eachList" id="${friendVO.id }" data-toggle="modal" data-target="#myPopUp" onclick="friendClick('${friendVO.id}')" >
					<p class="date"><img src="resources/images/${friendVO.thumbnailPath }" alt="" style="width: 100%; height:110%;" /></p>
					<h3>&nbsp;${friendVO.id }</h3>
					<p>${friendVO.stateMessage } &nbsp;</p>
				</li>
				 <p><a onclick="friendChat('${friendVO.id}')" style="text-align: right;">채팅하기</a></p>
				 <p><a href="#" onclick="friendBlock('${friendVO.id}')" style="text-align: right;">차단</a></p>
				 
			</c:forEach>
			
				
 <div class="modal fade" id="myPopUp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header" style="width: 100%;">
		<input type="hidden" id = "hiddenId"></input>
		<input type="hidden" id = "hiddenNum"></input>
		<h1><div id="partner"></div></h1><h3>님과의 채팅</h3>	   
		
	      </div>

		

	      <div class="modal-body" style="height: 800px;">
	           <div class="chatContent" id = "chatList" style="height: 700px; border: 1px;"  >
	     		## 채팅 내용 영역 ## 	
	     </div> 
		
	
	     <div class="inputText" >
	     <input type="text" placeholder="채팅을 입력하세요" id="chatSend" style="width: 500px;"></input>
	     <button id="chatSendBtn">전송</button>
	     </div>
	      </div>
	    </div>
	  </div>
	</div>
			
				
				

				 	
	
				
			</ul>
		</div>
		<div id="copyright">
			<span>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a></span>
			<span>Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</span>
		</div>
	</div>
</div>
</body>
</html>
