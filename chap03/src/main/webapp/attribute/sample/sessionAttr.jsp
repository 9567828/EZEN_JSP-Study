<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션Attr연습</title>
</head>
<body>

	<h3># 세션 연습하기</h3>
	
	<p>
		일단 한 번 세션 객체에 값을 등록해놓으면 해당 세션이 만료되기 전까지는 해당 값이 계속 존재하게 된다.
		(로그인 결과, 오늘 하루 더 이상 보지 않음 등)
	</p>
	
	<p><b>로그인을 성공한 적이 있는 사용자는 로그인 폼 대신 로그아웃 버튼이 보인다</b></p>
	
	<% if(session.getAttribute("login") != null) { %>
		''님은 이미 로그인 중 입니다. <br> <button>로그아웃</button>
	<%} else { %>
	
	<form id="login-form" action="/chap03/user/login" method="POST">
		ID: <input type="text" name="user_id" id="user-id-input" value="testuser" /> <br>
		PW: <input type="text" name="user_password" id="user-pw-input" value="1234" /> <br>
	</form>
	<button id="login-btn">로그인</button>
	<% } %>
	
	<!-- 자바스크립트로 form submit 하기 -->
	<script src="./form_submit.js"></script>
</body>
</html>