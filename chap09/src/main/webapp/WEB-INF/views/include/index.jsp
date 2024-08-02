<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<body>
	<h3># include 기능을 이용해 뷰 파일 분할하기</h3>
	
	<ul>
		<li>
			JSP include : Dispatcher의 forward처럼 request와 resopnse를 다른 페이지로 그대로 전달하여 뷰를 생성하고
			그 결과를 포함시키는 기능 다른 페이지로 갔다오는 기능이기 때문에 현재 페이지에서 선언한 page scope의
			어트리뷰트를 사용할 수 없다
		</li>
		<li>
			File include : 해당 파일 내용을 읽어서 현재 파일 내부에 포함시키는 기능
			컴파일 전에 파일 자체를 포함시킨 후 컴파일을 진행하기 때문에 page scope의 값을 활용할 수 있다
		</li>
	</ul>
	
	<c:url var="to_jsp_include" value="/include/jsp" />
	<c:url var="to_file_include" value="/include/file" />
	
	<a href="${to_jsp_include}">JSP include 해보러가기..</a>
	<a href="${to_file_include}">File include 해보러가기..</a>

</body>
</html>