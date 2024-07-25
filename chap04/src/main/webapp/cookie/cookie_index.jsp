<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3># Http Cookie</h3>
	
	<ul>
		<li>서버에서 클라이언트의 웹 브라우저에 데이터를 보관할 수 있는 기능</li>
		<li>서버에 데이터를 절약하고 자잘한 데이터 저장을 클라이언트에게 미룰 수 있다</li>
		<li>클라이언트는 해당 서버로 접속할 때 본인이 보유한 모든 쿠키를 요청에 실어서 보내게 된다</li>
		<li>서버 측에서는 요청 객체에서 원하는 쿠키를 꺼내 확인을 할 수 있다</li>
		<li>쿠키 또 한 파라미터, 어트리뷰트처럼 name/value 형태로 데이터를 저장하게 된다</li>
		<li>
			쿠키는 언제든지 클라이언트 측에서 열어볼 수 있고, 위/변조가 가능하기 때문에 보안상 중요한 데이터는 쿠키 대신 세션에 보관해야 한다
		</li>
	</ul>
	
	<a href="./sample/popup_main.jsp">쿠키체험하러가기</a>

	<h3># 쿠키 설정하기</h3>
	
	<ul>
		<!-- 아래 두개를 하나의 서블릿으로 처리가 가능하다 -->
		<li><a href="/chap04/cookie/ex/add">쿠키가 추가되는 서블릿</a></li>
		<li><a href="/chap04/cookie/ex/list">쿠키 목록 보러가기</a></li>
	</ul>
	

</body>
</html>