<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="frags/header.jspf" %>
<%@ include file="frags/init_vars.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file include</title>
</head>
<body>

	<h3>file include 해보기</h3>
	
	<c:if test="${animal == '코끼리' }">
		<p>동물이 코끼리네요</p>
	</c:if>
	
	<%@ include file="frags/coffee_table.jspf" %>

</body>
</html>