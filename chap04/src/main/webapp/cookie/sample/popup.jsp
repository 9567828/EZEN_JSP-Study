<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나는나는 팝업창</title>
</head>
<body>
	팝업창의 내용입니다.<br>
	
	<div style="position: fixed; right: 10px; bottom: 10px;">
		오늘은 그만 보기 <input type="checkbox" name="" id="chk-no-more" />
	</div>
	
	<script>
		const chkNoMore = document.getElementById("chk-no-more");
		
		chkNoMore.addEventListener("change", (e) => {
			// alert("변화가 있음!");
			console.dir(e.target.checked);
			if(e.target.checked) {
				// opener: 팝업창에서 부모 window를 가리키는 객체
				opener.location.href = "/chap04/popup/nomore";
				window.close(); // 현재창 (팝업도) 닫기				
			}
		});
	</script>
</body>
</html>