<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="chap06.dto.Employee" %>
    
<%
	Employee emp = (Employee) request.getAttribute("emp");
	String full_name = emp.getFirst_name() + " " + emp.getLast_name();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=full_name %>사원 정보 수정</title>
</head>
<body>
	<h3>[<%=full_name %>] 사원 정보 수정</h3>
</body>
</html>