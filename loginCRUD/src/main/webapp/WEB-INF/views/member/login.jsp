<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h3>로그인</h3>
	
	<form action="./login" id="login_form" method="POST">
		ID: <input type="text" name="account_id" id="a_id" /> <br />
		PW: <input type="password" name="account_pw" id="a_pw" /> <br />
		<input type="submit" value="로그인" />
	</form>
	
	<c:if test="${not empty failedLogin}">
		<div style="color: red;">${failedLogin}</div>
	</c:if>
	
	<c:if test="${not empty failedLoginId}">
		<div style="color: red;">${failedLoginId}</div>
	</c:if>
	
	<hr />
	아직 회원이 아니신가요? <button onclick="location.href='./join'">회원가입</button>
	
	<script>
	
		const aId = document.getElementById("a_id");
		const aPw = document.getElementById("a_pw");
		const loginForm = document.getElementById("login_form");
		
		loginForm.addEventListener("submit", (e) => {
			e.preventDefault();
			
			const inputId = aId.value;
			const inputPw = aPw.value;
			
			if (inputId == "") {
				alert("아이디를 입력해주세요")
				return;
			}
			
			if (inputPw == "") {
				alert("비밀번호를 입력해주세요")
				return;
			}
			
			loginForm.submit();
			
		})
		
	
	</script>
	
</body>
</html>