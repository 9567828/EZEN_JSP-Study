<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Context Path</title>
</head>
<body>

	<h3># Context Path</h3>
	
	<ul>
		<li>현재 프로젝트의 Context로 접근할 수 있는 경로를 의미한다</li>
		<li>사실은 서버의 설정 파일에 직접 적어야 하는 내용이지만 Eclipse의 Add and Remove 메뉴를 통해 자동으로 등록된다</li>
		<li>Add and Remove를 수행할 때마다 실제로는 sever.xml의 context가 수정된다</li>
		<li>request.getContextPaht() 메서드를 활용하여 링크를 만들면 Context 경로 설정이 나중에 변경되더라도 올바르게 동작하는 링크를 만들 수 있다</li>
	</ul>
	
	<a href="/chap05/encoding.jsp">encoding 보러가기 (설정이 바뀌면 유효하지 않을 수 있는 링크)</a> <br>
	<a href="<%=request.getContextPath()%>/encoding.jsp">encoding 보러가기 (설정이 바뀌어도 유효한 링크)</a> <br>

</body>
</html>