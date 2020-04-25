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
<script>
function friendClick(id){
	alert(id);
}

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
				<li><a href="#" accesskey="2" title="">Chattings</a></li>
				<li><a href="#" accesskey="3" title="">MAKE NEW FRIENDS</a></li>
				<li><a href="bannedFriends.go" accesskey="4" title="">Banned Friends</a></li>
				<li><a href="myProfile.go" accesskey="5" title="">My Profile</a></li>
			</ul>
		</div>
	</div>
	<div id="main">
		<div id="banner">
			<img src="resources/images/pic01.jpg" alt="" class="image-full" />
		</div>
		
		<div id="featured">
			<div class="title">
				<h2>My Friends</h2>
				<span class="byline">내 친구들과 대화하세요.</span>
			</div>
			<ul class="style1">
			
			<c:forEach items="${friendList }" var="friendVO">
				<li style="cursor: pointer;" onclick="friendClick('${friendVO.id}')">
					<p class="date"><img src="resources/images/${friendVO.thumbnailPath }" alt="" style="width: 100%; height:110%;" /></p>
					<h3>&nbsp;${friendVO.id }</h3>
					<p><a href="#">${friendVO.stateMessage } &nbsp;</a></p>
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
