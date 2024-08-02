<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="loginCRUD.dto.Members, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<button onclick="location.href='./logout'">로그아웃</button>
		<p>반갑습니다 <b>[<%=user%>]</b>님</p>
		<hr />
		
		가입 이메일: <%=mem.getAccount_email() %> <br />
		비밀번호: <button onclick="location.href='./checkPassword'">변경하기</button> <br />
		소셜가입여부: <%=mem.getSocial_login() %> <br>
		가입일: <%=mem.getJoin_date() %> <br />
		관리자계정: <%=mem.getAccess_manager() %> <br>
		<c:if test="${not empty managerId}">
			<c:url var="to_memlist" value="/member/memList" />
			<a href="${to_memlist}">회원정보목록</a> <br />
		</c:if>
		<br />
		회원탈퇴하기 <button id="leaveBtn">탈퇴</button>
		
	<% } else { %>
		<p>로그인 하지 않으셨습니다.</p>
		로그인 하시겠습니까? <button onclick="location.href='./login'">로그인</button> <br />
		회원이 아니신가요? <button onclick="location.href='./join';">회원가입하기</button>
	<% } %>
	
	<script>
		const leaveBtn = document.getElementById("leaveBtn");
		
		leaveBtn.addEventListener("click", (e) => {
			if (confirm("정말로 탈퇴 하시겠습니까?")) {
				location.href = "./leave"
			}
			
		})
	
	
	</script>

</body>
</html>