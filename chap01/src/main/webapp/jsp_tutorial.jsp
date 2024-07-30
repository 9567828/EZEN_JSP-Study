<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_tutorial.jsp</title>
</head>
<body>
	<!-- Ctrl + E(기본설정) : Emmet 적용 -->
	<!-- shift + tab으로 바꿈 -->
	<h3># JSP</h3>
	
	<ul>
		<li>Java Server Pages (JSP)</li>
		<li>상황에 따라 달라지는 웹페이지(동적 웹페이지)를 생성하기 위한 JAVA API</li>
		<li>HTML코드 내부에 자바 코드를 활용하는 것 처럼 사용할 수 있다</li>
		<li>.jsp파일의 실행 결과는 .html형식의 문자열이다</li>
	</ul>
	
	<h3># Web Server</h3>
	<ul>
		<li>웹서버는 요청(request)이오면 응답(response)을 하는 프로그램이다</li>
		<li>
			사용자가 보내는 요청에 따라 알맞은 정적자원(그림파일, 텍스트, 음악 파일, .html페이지)을 응답해준다
		</li>
		<li>
			Apache-Tomcat의 Apache가 Web Server의 역할을 수행한다
		</li>
	</ul>
	
	<h3># Web Application Server</h3>
	
	<ul>
		<li>
			JSP 페이지에 요청을 보내면 요청에 따라
			해당 요청에 알맞는 .html을 생성하여 응답해줄 수 있는 서버
		</li>	
		<li>
			단순히 정해진 응답을 하는 것이 아니라
			요청이나 상황에 따라 다른 형태의 .html을 생성하여 응답한다
		</li>
		<li>
			Apache-Tomcat의 Tomcat이 JSP 문법을 해석하여 동작시키는 프로그램이다
		</li>
	</ul>
	
	<h3># .jsp 파일의 처리 순서</h3>
	
	<ol>
		<li>.jsp파일을 해석하여 .java파일로 변환된다 (1차 컴파일)</li>
		<li>변환된 .java파일을 실행 가능하도록 컴파일 한다 (2차 컴파일)</li>
		<li>컴파일 된 결과물이 웹컨테이너에 등록되어 사용자의 요청을 기다린다</li>
		<li>
			사용자가 해당 페이지를 요청하면 웹 컨테이너에 등록되어 있던
			.jsp파일 컴파일 결과물을 실행한 결과를 응답한다 
		</li>
	</ol>
	<div>컴파일 된 결과물의 위치: C:\aiautomation_kse\jsp-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\chap01\org\apache\jsp</div>

	<%-- JSP 주석 --%>
	<%--
		<%  %> : 해당 영역 내부에서 자바 코드를 사용할 수 있다
		<%= %> : 자바에 있는 값을 HTML로 출력한다
		<%! %> : 자바 메서드를 선언할 수 있다
		<%@ %> : JSP 페이지에 대한 설정 문법 
	--%>
	
	<%!
		int count = 0;
		
		public String printRabbit() {
			return "<pre>"
				  +" /)/)\n"
				  +"(  ..)\n"
				  +"(  >$</pre>";
		}
	%>
	 
	<% for (int i = 0; i < 10; ++i) { %>
		<div id="div<%=i %>"><%=i%>번째 div입니다</div>
	<% } %>
	
	<% for (int i = 0; i < 5; ++i) { %>
		<%=printRabbit() %>	
	<% } %>
</body>
</html>






