<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
	<p>
		이름: <%=request.getAttribute("first_name") %>
	</p>
	<p>
		성: <%=request.getAttribute("last_name") %>
	</p>
</body>
</html>