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
	<h1 style="margin-top: 200px; color: white;"> Chat Site</h1>
		<form action="login.do" , method="post">
			<table border="1" style="width: 30%; height:200px; margin-top: 200px; color: white; text-align: center; ">

				<tr>
					<td>아이디 :</td>
					<td><input type="text" name="id" style="height: 80%; width: 80%; font-size: 18px;"></td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="password" name="password" style="height: 80%; width: 80%; font-size: 18px;"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="로그인" style="height: 80%; width: 20%; font-size: 18px;">
					<input type="button" onclick="location.href='join.go'" value="회원가입" style="height: 80%; width: 20%; font-size: 18px;">
					</td>
					
					
				</tr>

			</table>
		</form>
	</center>
</body>
</html>
