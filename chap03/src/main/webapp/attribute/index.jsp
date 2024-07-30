<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어트리뷰트</title>
</head>
<body>
	<h3># Attribute</h3>
	
	<ul>
		<li>파라미터를 받아서 원하는 처리를 수행한 후 결과를 실어 놓을 수 있는 곳</li>
		<li>page, request, session, application 영역이 있다</li>
		<li>영역별로 저장한 데이터가 유지되는 시간이 다르다</li>
	</ul>
	
	<h3># Request Attribute</h3>
	
	<ul>
		<li>하나의 요청이 끝나기 전가지 유효한 어트리뷰트.</li>
		<li>요청에 대한 응답을 수행하고나면 저장한 데이터가 모두 사라진다.</li>
		<li>주로 서블릿에서 처리한 데이터를 포워드를 통해 JSP로 전달하기 위해 사용됨</li>
	</ul>
	
	<a href="./sample/requestAttr.jsp">request 어트리뷰트 연습하러가기...</a>
	
	<h3># Session Attribute</h3>
	
	<ul>
		<li>하나의 섹션이 만료될때 까지 수명이 유지되는 어트리뷰트</li>
		<li>서버는 해당 서버에 최초로 요청을 보낸 클라이언트에게 session_id를 부여한다</li>
		<li>발급받은 세션ID는 서버에서 유일한 값이며 해당 클라이언트 본인임을 증명할 수 있는 식별값이 된다</li>
		<li>세션은 해당 세션ID가 유효한 기간동안 수명이 유지된다</li>
		<li>세션 어트리뷰트는 해당 세션ID를 키로 사용하여 열 수 있는 보관함이다</li>
		<li>
			세션ID는 접속 시간이 너무 오래되거나 웹 브라우저를 종료하면 만료된다
			(e.g. 은행 사이트, 관공서 사이트 등)
		</li>
	</ul>
	
	<button onclick="location.href='./sample/sessionAttr.jsp'">세션어트리뷰트 연습</button>
	
	<h3># Application Attribute</h3>
	
	<ul>
		<li>서버가 켜져있는동안 유지되는 어트리뷰트</li>
		<li>데이터를 서버에 저장해놓는다</li>
		<li>세션 객체는 세션ID의 개수만큼(즉, 접속자 수만큼)의 인스턴스가 존재하지만 서버는 1대이므로 전역 변수 같은 역할을 하게 된다</li>
	</ul>
	
	<hr />
	
	application 영역에 추가한 값: <%=application.getAttribute("fruit") %> <br>
	session 영역에 추가한 값: <%=session.getAttribute("fruit") %> <br>
	request 영역에 추가한 값: <%=request.getAttribute("fruit") %> <br>
	pageContext 영역에 추가한 값: <%=pageContext.getAttribute("fruit") %> <br>
	
	<a href="/chap03/attribute/sample/addAllAttributes.jsp">어플리케이션 어트리뷰트 추가하러 가기 (리다이렉트)</a> <br>
	<a href="/chap03/attribute/sample/addAllAttributes2.jsp">어플리케이션 어트리뷰트 추가하러 가기 (포워드)</a> <br>
	
</body>
</html>