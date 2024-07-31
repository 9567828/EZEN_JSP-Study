<%@page import="login_page.webprocess.JoinProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	JoinProcess checkId = new JoinProcess();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>

	<form action="./join" id="join_form" method="POST">
		아이디 : <input type="text" name="account_id" id="join_id" /> <br />
		이메일 : <input type="email" name="account_email" id="join_email" placeholder="abc@naver.com" /> <br />
		비밀번호 : <input type="password" name="account_pw" id="join_pw" /> <br />
		비밀번호확인 : <input type="password" name="account_pw_chk" id="join_pw_check" /> <br />
		<input type="hidden" name="member_status" value="신규" />
		<hr />
		약관에 동의 하시겠습니까? <br />
		<input type="checkbox" name="terms_agree" id="terms_agree" value="Y" /> 동의합니다. <br /><br />
		<input type="submit" value="가입완료" />
	</form>
	<button onclick="location.href='./login';">처음으로</button>
	
	<script>
		const joinForm = document.querySelector("#join_form");
		
		const joinId = document.querySelector("#join_id");
		const joinEmail = document.querySelector("#join_email");
		const joinPw = document.querySelector("#join_pw");
		const joinPwChk = document.querySelector("#join_pw_check");
		const termsAgree = document.querySelector("#terms_agree");
		
		const vaildText = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		
		joinForm.addEventListener("submit", (e) => {
			e.preventDefault();
			
			if (joinId.value == "" || joinId.value.includes(" ")) {
				alert("아이디가 공란 또는 공백이 포함되어있습니다.");
				joinId.focus();
				return;
			}	
			
			if (joinEmail.value == "" || vaildText.test(joinEmail.value) == false) {
				alert("이메일이 공란 혹은 형식이 올바르지 않습니다")
				joinEmail.focus();
				return;
			}
			
			if (joinPw.value == "" || joinPw.value.includes(" ")) {
				alert("비밀번호가 공란 혹은 공백이 포함 되어있습니다");
				joinPw.focus();
				return;
			}
			
			if (joinPwChk.value == "" || joinPwChk.value.includes(" ")) {
				alert("비밀번호 확인이 공란 혹은 공백이 포함 되어있습니다.");
				joinPwChk.focus();
				return;
			}
			
			if (joinPw.value != joinPwChk.value) {
				alert ("비밀번호 확인이 동일하지 않습니다.")
				joinPw.focus();
				return;
			}
			
			if (!terms_agree.checked) {
				alert("동의하셔야 가입이 가능합니다.")
				terms_agree.focus();
				return;
			}
			
			alert("가입되었습니다");
			confirm_login();
		})
		
		function confirm_login() {
			if (confirm("로그인 하시겠습니까?")) {
				location.href="./login";
			}
		}
	
	</script>
</body>
</html>