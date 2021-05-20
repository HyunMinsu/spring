<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/testspring/resources/client/css/mystyle.css">
<script type="text/javascript" src="/testspring/resources/client/js/command.js"></script>
</head>
<body>
<form action="/reivew/login/result.do" method="post" onsubmit="return checkData()">
<table>
	<tr><td>아이디</td><td><input type="text" name="id" id="userId"></td></tr>
	<tr><td>패스워드</td><td><input type="password" name="pwd" value="1234" id="pwd"></td></tr>
	<tr>
		<td>로그인</td>
		<td><input type="submit" value="로그인"></td>
	</tr>
</table>
<img src="/testspring/resources/image/duke.png" alt="이미지 연결 연습">
</form>
</body>
</html>