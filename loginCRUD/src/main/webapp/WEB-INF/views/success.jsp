<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성공</title>
</head>
<body>

	<c:if test="${not empty sessionScope.successJoin}">
	    <h3>${sessionScope.successJoin}</h3>
	    <button onclick="location.href = '/member/login';">로그인하러가기</button>
	    <c:remove var="successJoin" scope="session" />
	</c:if>
	
	<c:if test="${not empty sessionScope.successChange}">
	    <h3>${sessionScope.successChange}</h3>
	    <button onclick="location.href = '/member/myPage';">마이페이지로 돌아가기</button>
	    <c:remove var="successChange" scope="session" />
	</c:if>

</body>
</html>