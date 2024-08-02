<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>여기는 접속하면 팝업창이 뜨는 페이지 입니당..</p>
	
	<script>
		// 서블릿에서 브라우저에 추가한 쿠키를 자바스크립트에서 활요할 수 있다
		console.log(document.cookie);
		// 팝업창 띄우는 함수
		
		// 쿠키값이 없을 때만 발동
		if (!document.cookie.includes("nomore=t")) {
			let popupOptions = "width=500, height=500, top=100, left=100";
			window.open("./popup.jsp", "popup test", popupOptions);			
		}
		
	</script>
</body>
</html>