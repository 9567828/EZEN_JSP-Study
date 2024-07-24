<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키리스트</title>
</head>
<body>

	<p>값 수정 기능 구현해보기</p>
	<p>(수정 시 input에 공백이 포함된 채로 버튼을 누르면 요청을 보내지 않도록 만들어보기)</p>
	<ul>
		<% for (Cookie cookie : (Cookie[])(request.getAttribute("cookies"))) { %>
			<li>
				<% String cookieName = cookie.getName(); %>
				<%=cookieName%>=<%=cookie.getValue() %>
				<!-- [<input type="text" name="edit-cookie-value" id="" form="edit-form" />
				<input type="text" name="cookie-value" value="<%=cookie.getValue()%>" form="edit-form" style="display: none;" />
				<button type="submit" form="edit-form">수정</button>]  -->
				<!-- 풀이 -->
				<form action="./modify" class="modi-form" method="GET">
					<!-- 숨겨서 가져간다 위에 굳이 display none을 안해도 됐다 -->
					<input type="hidden" name="to_modi" value="<%=cookieName%>"/>
					[<input type="text" name="modi_value" />
					<button id="modi_btn">수정</button>]
				</form>
				<!-- cookie-name 이라는 파라미터를 서블릿에 보내주는 것 -->
				[<a href="./delete?cookie-name=<%=cookieName%>">삭제</a>]
			</li>
		<% } %>
	</ul>
	
	<!-- <form action="/chap04/cookie/ex/edit" method="GET" id="edit-form"></form> -->
	<a href="../cookie_index.jsp">쿠키 인덱스로</a>

	<script src="/chap04/resources/js/modi_cookie.js"></script>

</body>
</html>