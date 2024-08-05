<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시글 목록 페이지</title>
</head>
<body>

	<h3>게시글 목록 페이지</h3>
	<button onclick="location.href='./write'">글쓰기</button>
	
	<table border=1>
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>작성날짜</th>
			<th>좋아요</th>
			<th>싫어요</th>
		</tr>
	<c:forEach items="${boards}" var="board">
		<tr>
			<td>${board.board_id }</td>
			<td>
				<a href="detail?board_id=${board.board_id }">${board.board_title }</a>
			</td>
			<td>${board.board_writer }</td>
			<td>${board.board_view_count }</td>
			<td>${board.board_write_date }</td>
			<td>${board.board_good_count }</td>
			<td>${board.board_bad_count }</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html>