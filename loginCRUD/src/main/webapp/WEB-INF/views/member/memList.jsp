<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="loginCRUD.dto.Members, java.util.List" %>
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
		grid-template-columns: 50px 1fr 1.5fr repeat(2, 1fr) repeat(3, 80px) repeat(2, 1fr);
    	justify-items: center;
	    background-color: #fff;
    	box-shadow: 1px 1px 2px 0px rgb(0, 0, 0, 0.6);
    	line-height: 3;
    	font-weight: bold;
	}
	
	#list_wrap {
		display: grid;
  		grid-template-columns: 50px 1fr 1.5fr repeat(2, 1fr) repeat(3, 80px) repeat(2, 1fr);
  		justify-items: center;
  		margin-bottom: 10px;
	}
	
</style>

</head>
<body>

	<% 
		String manager = null;
		if (session.getAttribute("managerId") != null) {
			manager = (String)session.getAttribute("managerId");
		}
	%>
	
	<% if (manager != null) { %>
	
	<div class="manager_wrap">
		<p>관리자 계정 입니다.</p>
		<button onclick="location.href='./myPage?account_id=<%=manager%>'">내정보</button>
		<button onclick="location.href='./logout'">로그아웃</button>
	</div>
	
	<h3>가입자 리스트</h3>
		
	<ul>
		<li>No.</li>
		<li>회원아이디</li>
		<li>회원이메일</li>
		<li>회원비밀번호</li>
		<li>가입날짜</li>
		<li>상태</li>
		<li>동의</li>
		<li>관리자</li>
		<li>소셜로그인</li>
		<li>비밀번호변경일</li>
	</ul>
	<% 
		List<Members> memList = (List) request.getAttribute("memList");
		System.out.println("memList size: " + (memList != null ? memList.size() : "null"));
		if (memList != null && !memList.isEmpty()) {
		for (Members mem : memList) {
	%>
	<div id="list_wrap">
		<div><%=mem.getRownum() %></div>
		<div><%=mem.getAccount_id() %></div>
		<div><%=mem.getAccount_email() %></div>
		<div><%=mem.getAccount_pw() %></div>
		<div><%=mem.getJoin_date() %></div>
		<div><%=mem.getMember_status() %></div>
		<div><%=mem.getTerms_agree() %></div>
		<div><%=mem.getAccess_manager() %></div>
		<div><%=mem.getSocial_login() %></div>
		<div><%=mem.getChange_pw_date() %></div>
	</div>
	<% } 
		}else {
		System.out.println("회원 목록이 비었다");
	 } %>
	 
	 	<% } else { %>
		<p>로그인 하지 않으셨습니다.</p>
		로그인 하시겠습니까? <button onclick="location.href='./login'">로그인</button> <br />
		회원이 아니신가요? <button onclick="location.href='./join';">회원가입하기</button>
	<% } %>
	
</body>
</html>