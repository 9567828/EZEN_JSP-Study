<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
	<h3>비밀번호 확인</h3>
	<form action="./checkPassword" id="check_form" method="POST">
		비밀번호를 입력해주세요 <br />
		<input type="password" name="account_pw" id="input_pw" />
		<input type="submit" value="확인" />
	</form>
	
	<c:if test="${not empty wrongPw}">
		<div style="color: red;">${wrongPw}</div>
	</c:if>
	
	<script>
		const checkForm = document.getElementById("check_form");
		const inputPw = document.getElementById("input_pw");
		
		checkForm.addEventListener("submit", (e) => {
			e.preventDefault();
			
			if (inputPw.value == "") {
				alert("비밀번호를 입력하세요")
				return;
			}
			
			checkForm.submit();
		})
	</script>
</body>
</html>