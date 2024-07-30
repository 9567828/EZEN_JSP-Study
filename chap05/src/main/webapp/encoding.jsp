<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인코딩</title>
</head>
<body>

	<% String getPath = request.getContextPath(); %>

	<h3># JSP의 여러가지 charset 설정</h3>
	
	<dl>
		<dt>1. HTML meta 태그의 charset 설정</dt>
		<dd>이 페이지를 해석하게 될 웹브라우저가 사용할 charset</dd>
		<dt>2. JSP contentType의 charset 설정</dt>
		<dd>이 서블릿의 결과로 생성되는 응답에 실릴 데이터의 charset</dd>
		<dt>3. JSP pageEncoding의 charset 설정</dt>
		<dd>이 JSP페이지(.jsp)를 서블릿(.java)으로 변환할 때 사용할 charset</dd>
	</dl>
	
	<h3># GET 방식으로 한글을 보내보기</h3>
	
	<ul>
	<!-- 데이터를 get 방식으로 실어서 보내기 ?""="" 과 같은 식 -->
		<li><a href="<%=getPath%>/encodingTest?fruit=사과">데이터 보내기</a></li>
		<li><span onclick="location.href='<%=getPath%>/encodingTest?fruit=포도'">데이터보내기2</span></li>
		<li><span id="get3">데이터보내기3</span></li>
	</ul>
	
	<h3># POST 방식으로 한글 보내기</h3>
	
	<ul>
		<li>
			POST방식은 request 객체의 내부에 실려서 서버에 도착하므로
			데이터를 꺼내기 전에 request 객체의 인코딩 타입을 설정해주어야 한다.
		</li>
	</ul>
	
	<form action="<%=getPath%>/encodingTest" method="POST">
		<input type="text" name="coffee" id="" value="아메리카노" />
		<input type="submit" value="확인" />
	</form>
	
	
	<script>
		const get3 = document.getElementById("get3");
		
		get3.addEventListener("click", () => {
			location.href = "<%=getPath%>/encodingTest?fruit=복숭아";
		});
	</script>

</body>
</html>