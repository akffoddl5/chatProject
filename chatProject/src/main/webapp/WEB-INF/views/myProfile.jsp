<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script>
	function updateUser(id){
		alert("[ "+id+" ]" + " 님의 정보 업데이트 완료");
		
	}




</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900"
	rel="stylesheet" />
<link href="resources/css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="resources/css/fonts.css" rel="stylesheet" type="text/css"
	media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->
 <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
 <script type="text/javascript">
    
 		$(function() {
            $("#profileImage").on('change', function(){
                readURL1(this);
            });
        });

        function readURL1(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $("#imagePreview").attr('src', e.target.result);
                }

              reader.readAsDataURL(input.files[0]);
              
            }
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
				<li><a href="makeNewFriends.go" accesskey="3" title="">MAKE NEW FRIENDS</a></li>
				<li><a href="bannedFriends.go" accesskey="4" title="">Banned Friends</a></li>
				<li class="current_page_item"><a href="myProfile.go" accesskey="5" title="">My Profile</a></li>
			</ul>
		</div>
	</div>
	<div id="main">

			<p>
				<h1>회원 정보</h1>
			</p>
			<br></br>
			<form action="updateUser.do" method="post" enctype="multipart/form-data">
				<table
					style="text-align: left; margin-left: auto; margin-right: auto;">
					<tr>
						<td rowspan="3"><img
							src="resources/images/${vo.thumbnailPath }"
							style="height: 300px; width: 300px;" alt=""  id="imagePreview"/></td>
						<td><h2>아이디 : ${vo.id}</h2></td>
					</tr>
					<tr>
						<td><h2>상태 메세지</h2> <textarea rows="5" cols="55" name="stateMessage">${vo.stateMessage }</textarea></td>
					</tr>
					<tr>
						<td><h2>프로필 이미지 변경</h2><input type="file" name="profileImage" id="profileImage"></input></td>
					</tr>
				</table><br></br>
					<input type="hidden" value="${vo.id}" name = "id"></input>
<<<<<<< HEAD
					<input type="hidden" value="default2.jpeg" name = "thumbnailPath"></input> 
					<input type="submit" onclick = "updateUser('${vo.id}')"value="회원정보 수정완료" style="height: 80%; width: 20%; font-size: 18px;"></input>
=======
					
					<input type="submit" value="회원정보 수정완료" style="height: 80%; width: 20%; font-size: 18px;"></input>
					<input type="reset" value="취소" style="height: 80%; width: 20%; font-size: 18px;"></input>
>>>>>>> 0753f8a11e828b0c4532f166d9754ad3291a3784
			</form>
		</div> 	

	</div>
</body>
</html>
