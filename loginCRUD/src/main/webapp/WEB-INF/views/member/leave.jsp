<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴페이지</title>
</head>
<body>

    <% if (request.getAttribute("leaveSuccess") != null) { %>
        <p>${leaveSuccess}</p>
        <a href="./login">로그인 페이지로 이동</a>
    <% } else if (request.getAttribute("failedLeave") != null) { %>
        <p>${failedLeave}</p>
        <a href="./myPage">마이페이지로 돌아가기</a>
    <% } %>

</body>
</html>