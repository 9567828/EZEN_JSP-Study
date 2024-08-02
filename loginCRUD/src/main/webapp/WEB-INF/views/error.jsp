<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류페이지 입니다</title>
</head>
<body>
	<h3>404 not found page 입니다</h3>
	
	<c:if test="${not empty failedM}">
	    <h3>${failedM}</h3>
	    <button onclick="location.href = '/member/memList';">회원정보 보러가기</button>
	    <c:remove var="failedM" scope="request" />
	</c:if>

	<c:if test="${not empty failedLeave}">
	    <h3>${failedLeave}</h3>
	    <button onclick="location.href = '/member/myPage';">돌아가기</button>
	    <c:remove var="failedM" scope="request" />
	</c:if>
	
</body>
</html>