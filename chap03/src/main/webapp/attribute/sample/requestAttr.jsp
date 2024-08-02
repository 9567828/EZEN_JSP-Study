<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리퀘스트 어트리뷰트 연섭</title>
</head>
<body>
	<h3>Request Attribute 연습하는 곳</h3>
	
	<input type="number" name="emp_id" id="" value="100" form="empForm"/>
	<input type="submit" value="사원조회하기" form="empForm"/>
	
	<form action="/chap03/employee/detail" id="empForm" method="GET"></form>

</body>
</html>