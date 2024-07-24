<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 실습 페이지</title>
</head>
<body>
	<h3># 세션에 들어있는 값에 따라 달라지는 페이지</h3>
	
	<button onclick="location.href='/chap04/login/success';">로그인 성공시키기</button>
	<button onclick="location.href='/chap04/login/close';">세션 만료시키기(새로운 세션ID 발급)</button>
	
	<hr>
	
	<%
		String user = null;
		if (session.getAttribute("user") != null) {
			user = (String)session.getAttribute("user");
		}
	
	%>
	
	<% if (user != null) { %>
		<p><b>'<%=user %>'</b>님 환영합니다!
		<button onclick="location.href='/chap04/login/logout';">로그아웃하기</button></p>
	<% } else { %>
		<p>아직 로그인하지 않으셨습니다.</p>
	<% } %>
</body>
</html>