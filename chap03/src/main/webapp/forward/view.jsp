<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피 추가하기 페이지 입니다.</title>
</head>
<body>

	<h3>도착한 커피의 정보</h3>
	
	<ul>
		<li>커피이름: <%=request.getParameter("cname") %></li>
		<li>커피가격: <%=request.getParameter("price") %></li>
		<li>개수: <%=request.getParameter("qty") %></li>
	</ul>
	
	<p>정말 추가하시겠습니까?</p>
	<button>예</button>
	<button>아니오</button>
	

</body>
</html>