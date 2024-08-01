<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경하기</title>
</head>
<body>

	<h3>비밀번호 변경</h3>
	
	<c:if test="${not empty failedChPw}">
		<div style="color: red;">${failedChPw}</div>
	</c:if>
	
	<form action="./changePassword" id=change_form method="POST">
		변경할 비밀번호: <input type="password" name="account_pw" id="account_pw" /> <br />
		비밀번호 확인: <input type="password" name="account_pw_chk" id="account_pw_chk" /> <br />
	</form>
	<br />
	<input type="submit" value="확인" form="change_form"/>
	<button onclick="location.href='/member/myPage';">취소하기</button>


	<script>
		const change_form = document.getElementById("change_form");
		const inputPw = document.getElementById("account_pw");
		const inputPwChk = document.getElementById("account_pw_chk");
		
		change_form.addEventListener("submit", (e) => {
			e.preventDefault();
			
			if (inputPw.value == "" || inputPw.value.includes(" ")) {
				alert("비밀번호가 공란 혹은 공백이 포함되어 있습니다요")
				return;
			}

			if (inputPwChk.value == "" || inputPwChk.value.includes(" ")) {
				alert("비밀번호 확인에 공란 혹은 공백이 포함되어 있습니다요")
				return;
			}
			
			if (inputPwChk.value != inputPw.value) {
				alert("비밀번호가 일치하지 않습니다요.")
				return;
			}
			
			change_form.submit();
		})
		
		
	</script>
</body>
</html>