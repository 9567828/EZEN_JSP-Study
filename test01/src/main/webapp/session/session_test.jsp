<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 로그인 연습</title>
</head>
<body>
	<h3>세션연습하기</h3>
	
	<form action="./success">
		ID: <input type="text" name="user-id" /> <br>
		PW: <input type="text" name="user-pw" /> <br>
		NAME: <input type="text" name="user-name" /> <br>
	</form>
	<button onclick="location.href='/test01/login-t/success';">로그인 성공해기</button>
</body>
</html>