<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" >
	function checkValue() {
		if(!document.userInfo.id.value){
			alert("아이디 없음");
			document.userInfo.id.focus();
			return false;
		}
		if(!document.userInfo.password.value){
			alert("비밀번호 없음")
			document.userInfo.password.focus();
			return false;
		}
		if(!document.userInfo.repassword.value){
			alert("비밀번호 확인 없음")
			document.userInfo.password.focus();
			return false;
		}
		if(document.userInfo.password.value != document.userInfo.repassword.value){
			alert("비밀번호를 동일하게 입력하세요")
			documen.userInfo.repassword.focus();
			return false;
		}
		
		alert("회원가입 완료")
		
	}


	$('#user_id').blur(function() {
		val user_id = $('#user_id').val();
		alert('AAAA');
		$.ajax({
			url : '${pageContext.request.contextPath}/idCheck?userId=' + user_Id,
			type : 'get',
			success : function(data) {
				console.log("1=중복 / 0=중복x : "+data);
			}
		})
	})
</script>
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="resources/css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/css/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>


	<center>
	<h1 style="margin-top: 200px; color: white;">JOIN</h1>
		<form action="join.do" name="userInfo"  >
			<table border="1" style="width: 30%; height:200px; margin-top: 200px; color: white; text-align: center; ">

				<tr>
					<td>아이디 :</td>
					<td><input type="text" id="user_id" name="id" style="height: 80%; width: 80%; font-size: 18px;">
					<div class="checkId" id="id_check"></div>
					</td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="password" name="password" id="pwd1" style="height: 80%; width: 80%; font-size: 18px;"></td>
				</tr>
				<tr>
					<td>비밀번호 확인 :</td>
					<td><input type="password" name="repassword" id="pwd2" style="height: 80%; width: 80%; font-size: 18px;"></td>
					<font id="chkNotice" size="2"></font>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="회원가입 완료" onclick="return checkValue()" style="height: 80%; width: 20%; font-size: 18px;">
					</td>
					
					
				</tr>

			</table>
		</form>
	</center>
</body>
</html>
