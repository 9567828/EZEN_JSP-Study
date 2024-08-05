<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="detail_js" value="/resources/js/detail.js" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 제목: ${board.board_title }</title>
</head>
<body>
	
	<h3>${board.board_writer }님의 글</h3>
	
	<div>${board.board_title}</div>
	<div>${board.board_writer}</div>
	<div>${board.board_write_date}</div>
	<div>${board.board_content}</div>
	<div>조회수: ${board.board_view_count}</div>
	<div>좋아요: ${board.board_good_count}</div>
	<div>싫어요: ${board.board_bad_count}</div>
	<div><input type="password" name="" id="" /><button>글수정</button></div>
	<div><button id="good-btn">추천</button><button id="bad-btn">비추천</button></div>

	<button onclick="location.href='/board/'">목록으로</button>
	
	<!-- 스크립트가 같이 동작하기 때문에 연결이 된다 즉 DB에서 가져온 id를 스크립트 js파일에 전달할 수 있다 -->
	<script>
		const board_id = ${board.board_id};
	</script>
	<script src="${detail_js}"></script>
	
</body>
</html>