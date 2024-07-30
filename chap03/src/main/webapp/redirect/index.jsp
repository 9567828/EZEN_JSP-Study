<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리다이렉트</title>
</head>
<body>
	<h3># Redirect</h3>
	
	<ul>
		<li>
			요청을 보낸 클라이언트에게 다른 주소로 다시 요청하라고 응답하는 것
		</li>
		<li>클라이언트측에서 찾아올 수 있는 주소를 응답해줘야 한다</li>
		<li>리다이렉트를 응답받은 클라이언트측의 웹브라우저는 받은 주소로 새로운 요청을 다시 보낸다(이전 요청은 사라짐)</li>
	</ul>
	
	<!-- 
		a링크를 클릭해 요청 보내는 것도 GET 방식이다.
		GET방식 요청은 URL을 직접 조작하여 데이터를 만들어 보낼 수 있다 
	-->
	<a href="/chap03/redirect/test?name=mike&age=35">데이터와 함께 요청 보내기</a>
	<a href="/chap03/redirect/test">데이터 없이 요청 보내기</a>
	
</body>
</html>