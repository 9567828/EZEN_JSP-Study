<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="header_css" value="/assets/css/header.css" />
<c:url var="ex1" value="/include/jsp" />
<c:url var="ex2" value="/include/ex2" />
<c:url var="ex3" value="/include/ex3" />
<c:url var="ex4" value="/include/ex4" />
<c:url var="ex5" value="/include/ex5" />

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>JSP File include test page</title>
	<link rel="stylesheet" href="${header_css}" />
</head>
<body>

<div id="nav-bar">
	<div><a href="${ex1}">예제1</a></div>
	<div><a href="${ex2}">예제2</a></div>
	<div><a href="${ex3}">예제3</a></div>
	<div><a href="${ex4}">예제4</a></div>
	<div><a href="${ex5}">예제5</a></div>
</div>