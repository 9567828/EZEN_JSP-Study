<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3># Http Session</h3>
	
	<ul>
		<li>클라이언트가 최초로 웹 서버에서 접속하면 웹 서버는 해당 클리언트에게 세션ID를 발급한다</li>
		<li>
			발급받은 세션ID는 클라이언트의 쿠키에 보관된다 (클라이언트가 보유하고 있는 쿠키는 해당 서버로 가는 모든 요청에 포함된다)
		</li>
		<li>웹브라우저의 쿠키에 저장되어 있는 세션ID는 해당 클라이언트가 예전에 서버에 접속한 적이 있는 클라이언트라는 것을 증명할 수 있는 열쇠가 된다</li>
		<li>세션ID는 기본적으로 사용자의 웹 브라우저가 종료될 때 함께 사라지도록 설정되어 있다</li>
		<li>세션ID를 보유하고 있어야 해당 섹션 객체에 접근할 수 있다</li>
		<li>세션 객체는 해당 세션ID를 지닌 클라이언트가 사용할 수 있는 보관함 역할을 한다</li>
		<li>세션 객체에 어트리뷰트에 데이터를 추가하면 세션ID별로 하나씩 존재하기 때문에 너무 많은양의 데이터를 세션 영역에 저장하는 경우서버의 성능이 저하될 위험이 있다</li>
	</ul>
	
	<h3># JSP에서 세션 정보에 접근하기</h3>
	
	<ul>
		<li>JSP의 session 내장객체를 사용해 세션 정보를 확인할 수 있다</li>
		<li>SESSION ID: <%=session.getId() %></li>
		<!-- 시간으로 보기 위해서 Date를 걸어준것 -->
		<li>세션ID 생성시간(최초접속시간): <%=new Date(session.getCreationTime())%></li>
		<li>마지막으로 접속했던 시간: <%=new Date(session.getLastAccessedTime())%></li>
		<li>미활동시 세션 자동 만료시간: <%=session.getMaxInactiveInterval() %>초(30분)</li>
	</ul>
	
	<h3># 서블릿에서 세션 정보에 접근하기</h3>
	
	<button onclick="location.href='/chap04/servlet/session_info';">서블릿으로 요청 보내기</button>
	
	<h3># 세션 실습하러 가기</h3>
	
	<a href="./session_ex.jsp">▶▶▶▶</a>

</body>
</html>