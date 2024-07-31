<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인에 따라 결과가 달라지는 페이지</title>
</head>
<body>

	<p>로그인 한 적이 있는 사용자면 로그아웃 버튼을 보여준다</p>

	<% if (session.getAttribute("login") != null) { %>
		<button>로그아웃</button>
	<% } %>

</body>
</html>