const modiForms = document.getElementsByClassName("modi-form");

Array.from(modiForms).forEach((modiForm) => {
	console.dir(modiForm);
	
	//form.elements 에서 name 속성 또는 id 속성으로 폼 내부 요소 선택 가능
	const modiValue = modiForm.elements.modi_value;
	const modiBint = modiForm.elements.modi_btn;
	
	modiBint.addEventListener("click", (e) => {
		e.preventDefault();
		
		// modi-value의 값이 유효한 값이고 동시에 공백이 없을때만 submit()을 발생
		const mvlaue = modiValue.value;
		if (mvlaue) {
			// 공백이 포함되어있는지
			if(!mvlaue.includes(" ")) {
				// true가 안떳을 때만 서블릿 해준다
				modiForm.submit();
				return;
			}
		}
		
		console.log("요청을 보내지 않았습니다")
	})
	
})