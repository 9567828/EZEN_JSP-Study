<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="loginCRUD.dto.Members, java.util.List" %>
<% 
	Members mem = (Members) request.getAttribute("mem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나으 정보</title>
</head>
<body>
	<% 
		String user = null;
		if (session.getAttribute("userId") != null) {
			user = (String)session.getAttribute("userId");
		}
	%>
	
	<% if (user != null) { %>
		<h3>내 정보</h3>
		<button onclick="">로그아웃</button>
		<p>반갑습니다 <b>[<%=user%>]</b>님</p>
		<hr />
		
		가입 이메일: <%=mem.getAccount_email() %> <br />
		비밀번호: <button onclick="location.href='./checkPassword'">변경하기</button> <br />
		소셜가입여부: <%=mem.getSocial_login() %> <br>
		가입일: <%=mem.getJoin_date() %> <br />
		<br />
		회원탈퇴하기 <button>탈퇴</button>
		
	<% } %>

</body>
</html>