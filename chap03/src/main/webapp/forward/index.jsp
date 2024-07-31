<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드</title>
</head>
<body>

	<h3># Forward</h3>
	
	<ul>
		<li>사용자가 보낸 요청을 받은 서블릿에서 요청을 처리하다가 나머지 처리를 다른 서블릿으로 넘겨 이어받아 처리하게 하는 것</li>
		<li>사용자가 보낸 요청 객체를 그대로 다음 서블릿으로 전달하기 때문에 요청에 실려있던 값들(파라미터들)이 다음 서블릿으로 그대로 함께 전달된다</li>
		<li>포워드는 주로 서블릿에서 자바 코드가 많이 이용되는 모든 처리(백엔드)를 마친 후 HTML이 많이 이용되는 처리(프론트)는 JSP에서 마저 진행하기 위해 사용된다</li>
	</ul>
	
	<form id="coffee-form" action="./coffee/add" method="GET"></form>
	
	<!-- input태그를 form 바깥에 쓰더라도 해당 form의 소속으로 만들 수 있다 -->
	<input type="text" name="cname" id="" value="Americano" form="coffee-form" />
	<input type="number" name="qty" id="" value="10" form="coffee-form" />
	<input type="number" name="price" id="" value="1500" step="100" form="coffee-form" />
	<input type="submit" value="전송하기" form="coffee-form" />

</body>
</html>