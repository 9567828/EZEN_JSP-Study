<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// JSP에서 암묵적으로 사용 가능한 내장 객체들
	// -request : 요청 객체 (각 요청 당 1개)
	// -response : 응답 객체
	// -session : 세션 객체 (각 세션 당 1개)
	// -aaplication : WAS를 의마하는 객체 (서버 당 1개)
	// -pageContext : 해당 JSP페이지 내에서만 사용할 수 있는 객체
	
	request.setAttribute("fruit", "사과");
	session.setAttribute("fruit", "포도");
	application.setAttribute("fruit", "수박");
	pageContext.setAttribute("fruit", "참외");
	
	request.getRequestDispatcher("/attribute/index.jsp").forward(request, response);

%>