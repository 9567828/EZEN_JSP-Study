<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="chap06.dto.Employee, java.util.List" %>

    
<%
	Employee emp = (Employee) request.getAttribute("emp");
	List<String[]> jobs = (List<String[]>) request.getAttribute("jobs");
	List<String[]> depts = (List<String[]>) request.getAttribute("depts");
	String full_name = emp.getFirst_name() + " " + emp.getLast_name();
	
	int emp_id = emp.getEmployee_id();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=full_name %>사원 정보 수정</title>
</head>
<body>
	<h3>[<%=full_name %>] 사원 정보 수정</h3>
	
	<form action="./update" method="POST">
		<!-- readonly 수정불가능 -->
		사원번호 : <input type="number" name="employee_id" value="<%=emp.getEmployee_id() %>" readonly /> <br>
		이름 : <input type="text" name="first_name" id="" value="<%=emp.getFirst_name() %>" /> <br />
		성 : <input type="text" name="last_name" id="" value="<%=emp.getLast_name() %>" /> <br />
		<!-- jobs 테이블에 있는 직책을 선택해서 수정할 수 있도록 해주어야 한다 -->
		직책 : 
		<select name="job_id">
			<% for (String[] job : jobs) { %>
				<option value="<%=job[0]%>"><%=job[1] %>(<%=job[0] %>)</option>
			<% } %>
		</select> 
		<br />
		월급 : <input type="text" name="salary" id="" value="<%=emp.getSalary() %>" /> <br />
		커미션 : <input type="text" name="commission_pct" id="" value="<%=emp.getCommission_pct() %>" /> <br />
		부서번호 :
		<select name="department_id" id="">
			<% for (String[] dep : depts) { %>
				<option value="<%=dep[0]%>"><%=dep[1] %>(<%=dep[0] %>)</option>
			<% } %>
		</select>
		<br />
		<input type="submit" value="완료" />
	</form>
	<button id="backBtn">뒤로가기</button>
	
	<script>
		const backBtn = document.getElementById("backBtn");
		
		backBtn.addEventListener("click", (e) => {
			location.href = "./detail?employee_id=<%=emp_id%>";
		})
	
	</script>
</body>
</html>