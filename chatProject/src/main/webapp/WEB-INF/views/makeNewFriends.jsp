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
<link href="resources/css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/css/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$(document).ready(function(){
	$("#plusFriendBtn").click(function(){
		var plusId = document.getElementById("idText").value;
		alert(plusId);
		var myId = '${vo.id}';
		alert(myId);
		var query = {"myId" : myId , "plusId" : plusId};
		$.ajax({
			url : "addFriend.do",
			type : 'POST',
			data : query,
			success : function(data) {
				alert(data);
				document.getElementById("idText").value = '';
			}
		})
		
	});
	

});
	
	function addReFriend(id){
		alert(id + " 친구 추가 완료");
		location.href="/chat/addReFriend.do?friendId="+id
	}
	
	
</script>
</head>
<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img src="resources/images/${vo.thumbnailPath }" style="height: 70px; width: 70px;" alt="" />
			<h1><a href="#">${vo.id }</a></h1>
			<span>Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a></span>
		</div>
		<div id="menu">
			<ul>
				<li><a href="index.go" accesskey="1" title="">My Friends</a></li>
				<li><a href="chattings.go" accesskey="2" title="">Chattings</a></li>
				<li class="current_page_item"><a href="makeNewFriends.go" accesskey="3" title="">MAKE NEW FRIENDS</a></li>
				<li><a href="bannedFriends.go" accesskey="4" title="">Banned Friends</a></li>
				<li><a href="myProfile.go" accesskey="5" title="">My Profile</a></li>
			</ul>
		</div>
	</div>
	<div id="main">
		<div class="title">
				<h2>친구 추가</h2>
				<span class="byline">친구 아이디를 입력해 친구추가 해보세요.</span><br></br>
				<center>
				<table style="width:60%;">
				<tr style="height: 50px;">
				<td style="width: 80%;"><input type="text" id="idText" style="width: 90%; height: 20px;" placeholder="아이디"></input></td><td style="width: 20%;"><button id = "plusFriendBtn">친구추가</button></td>
				</tr>
				</table>
				</center>
		</div>
		
		<div id="featured">
			<div class="title">
				<h2>Recommand Friends</h2>
				<span class="byline">추천 친구 목록</span>
			</div>
			<ul class="style1">
			
			<c:forEach items="${reFriendsList }" var="reFriendVO">
				<li>
				
				<table style="width: 95%;">
				<tr>
				<td style="width: 90%;">
				<p class="date"><img src="resources/images/${reFriendVO.thumbnailPath }" alt="" style="width: 100%; height:110%;" /></p>
					<h3>&nbsp;&nbsp;<b>${reFriendVO.id }</b></h3>
					<p>${reFriendVO.stateMessage } &nbsp;</p>
				</td>
				<td><img src="resources/images/icon+.jpeg" alt="" style="width: 70%; height: 30px; cursor: pointer;" onclick="addReFriend('${reFriendVO.id }')"/> </td>
				</tr>	
				</table>
				
					
				</li>
			</c:forEach>
				
				<li>
					<p class="date"><a href="#"></a></p>
					<h3>Sagittis diam dolor amet</h3>
					<p><a href="#">Etiam non felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas at sem. Mauris quam enim, molestie. Donec leo, vivamus fermentum nibh in augue praesent congue rutrum.</a></p>
				</li>
				
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
