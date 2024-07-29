<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕하슈</title>
</head>
<body>
	<h3>로그인</h3>
	<hr />
	<form action="" method="GET">
		아이디: <input type="text" name="login_id" id="" /> <br />
	 	비밀번호: <input type="text" name="login_pw" id="" /> <br />
		<input type="submit" value="로그인" />
	</form>
	<hr />
	아이디가 없으신가요? <button onclick="location.href='./join';">회원가입하기</button>
</body>
</html>