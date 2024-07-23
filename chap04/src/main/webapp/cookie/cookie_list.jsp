<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키리스트</title>
</head>
<body>

	<ul>
		<% for (Cookie cookie : (Cookie[])(request.getAttribute("cookies"))) { %>
			<li>
				<%=cookie.getName() %>=<%=cookie.getValue() %>
				(남은 수명:<%=cookie.getMaxAge() %>)[<a href="#">삭제</a>] 
			</li>
		<% } %>
	</ul>

</body>
</html>