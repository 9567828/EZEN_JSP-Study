<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="login_page.dto.Members, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입자 리스트</title>

<style>
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	
	h3 {
		margin-bottom: 20px;
	}
	
	ul {
		list-style: none;
		height: 50px;
		margin-bottom: 10px;
		display: grid;
		grid-template-columns: repeat(8, 200px);
    	justify-items: center;
	    background-color: #fff;
    	box-shadow: 1px 1px 2px 0px rgb(0, 0, 0, 0.6);
    	line-height: 3;
    	font-weight: bold;
	}
	
	#list_wrap {
		display: grid;
  		grid-template-columns: repeat(8, 200px);
  		justify-items: center;
  		margin-bottom: 10px;
}
	}
	
</style>

</head>
<body>
	<h3>가입자 리스트</h3>
		
	<ul>
		<li>회원아이디</li>
		<li>회원이메일</li>
		<li>회원비밀번호</li>
		<li>가입날짜</li>
		<li>가입상태</li>
		<li>동의여부</li>
		<li>소셜로그인</li>
		<li>비밀번호변경일자</li>
	</ul>
	<% 
		List<Members> memList = (List) request.getAttribute("memList");
		for (Members mem : memList) {
	%>
	<div id="list_wrap">
		<div><%=mem.getAccount_id() %></div>
		<div><%=mem.getAccount_email() %></div>
		<div><%=mem.getAccount_pw() %></div>
		<div><%=mem.getJoin_date() %></div>
		<div><%=mem.getMember_status() %></div>
		<div><%=mem.getTerms_agree() %></div>
		<div><%=mem.getSocial_login() %></div>
		<div><%=mem.getChange_pw_date() %></div>
	</div>
	<% } %>
	
</body>
</html>