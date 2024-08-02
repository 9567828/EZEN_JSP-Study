<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String topping = request.getParameter("topping");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>토핑 선택 결과~!</title>
</head>
<body>

	<h1>당신은 <%=topping %>피자를 선택하셨습니다</h1>

</body>
</html>