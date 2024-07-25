<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my Page2</title>
</head>
<body>
	<h1>마이페이지2 입니다</h1>
	
	<p>
		WEB-INF 폴더 밑에(안에) 넣어놓은 .jsp 페이지는 (뿐만 아니라 다른 자원들도) 
		일반적인 방법(그냥 주소창에 webapp 밑의 경로를 치고 들어오는 방법)으로 접근하는 것이 금지되어 있다.
	</p>
	<p>web.xml에서의 매핑으로 이 페이지에 접근 할 수 있었다</p>
	
	<p>다른 서블릿에서의 포워딩으로 이 페이지에 접근할 수 있었다</p>
	

</body>
</html>