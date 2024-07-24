const loginForm = document.getElementById("login-form")
const loginBtn = document.getElementById("login-btn")

const userIdInput = document.getElementById("user-id-input");
const userPwInput = document.getElementById("user-pw-input");

loginBtn.addEventListener("click", (e) => {
	// input value 값이 이상할 때 (비어있다거나) 할 때 !로 처리
	if (!userIdInput.value) {
		alert("아이디를 입력해주세요!")
		userIdInput.focus(); // 커서를 해당 요소로 옮기는 메서드
		return;
	} else if (!userPwInput.value) {
		alert("비밀번호를 입력해주세요");
		userPwInput.focus();
		return;
	}
	
	loginForm.submit();
})