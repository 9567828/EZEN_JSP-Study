<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Board 글쓰기</title>
</head>
<body>
	<h3>글쓰기 페이지</h3>
	
	<!-- DB의 컬럼명, DTO의 필드명, form의 name이 모두 같으면 좋다 -->
	<!-- 같은 주소로 들어오는데 글쓰기로 POST를 보내주겠다 -->
	<form action="write" method="POST">
		글제목: <input type="text" name="board_title" id="" /> <br />
		글 비밀번호: <input type="password" name="board_password" id="" /> <br />
		글쓴이: <input type="text" name="board_writer" id="" /> <br />
		글내용: <textarea name="board_content" id="" cols="30" rows="10"></textarea> <br />
		<input type="submit" value="글쓰기" />
	</form>
	
</body>
</html>