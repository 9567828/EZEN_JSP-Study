<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="chap06.dto.Employee, java.util.List" %>
<% 
	Employee emp = (Employee) request.getAttribute("emp");
	List<String[]> jobs = (List<String[]>) request.getAttribute("jobs");
	
	String full_name = emp.getFirst_name() + " " + emp.getLast_name();
	
	
	int emp_id = emp.getEmployee_id();
	int next_id = emp_id + 1;
	int prev_id = emp_id - 1;
	
	int max_id = (int) request.getAttribute("max_id");
	int min_id = (int) request.getAttribute("min_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=full_name %> 상세 정보</title>
</head>
<body>
	<h3>[<%=full_name%>]의 상세 정보</h3>
	
	<div id="detail_wrap">
		사원번호 : <%=emp_id %> <button id="deletBtn">삭제</button> <br>
		직책번호 : <%=emp.getJob_id() %> <br>
		부서번호 : <%=emp.getDepartment_id() %> <br>
		월급 : <%=emp.getSalary() %> <br>	
	</div>
	<div id="update_wrap" style="display: none;">
		<form action="">
		<!-- readonly 수정불가능 -->
			사원번호 : <input type="number" name="emp_id" id="" value="<%=emp.getEmployee_id() %>" readonly /> <br>
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
			커미션 : <input type="text" name="commission" id="" value="<%=emp.getCommission_pct() %>" /> <br />
			부서번호 : <input type="text" name="dep_id" id="" value="<%=emp.getDepartment_id() %>" /> <br />
			<input type="submit" value="완료" />
		</form>
	</div>
	<br />
	
	<div id="btnWrap" style="display: flex; gap: 5px;">
		<% if(min_id != emp_id) { %>
			<button id="prevBtn">이전</button>
		<% } %>
		<button id="backToListBtn">목록으로</button>
		<button id="editBtn">수정하기</button>
		<button id="edit-cancle-Btn">취소</button>
		<% if(max_id != emp_id) { %>
			<button id="nextBtn">다음</button>
		<% } %>	
	</div>
	
	
	<script>
		const prevBtn = document.getElementById("prevBtn");

		// 버튼이 있을때만 추가를 하겠다
		// if 문이 없으면 100번 (사원번호 맨앞번호)일 때도 다음 버튼 작동이 잘 된다
		// if(prevBtn){} 을 축소시켜서 prevBtn? 을 넣어준다
		prevBtn?.addEventListener("click", (e) => {
			console.log(nextBtn);
			location.href = "./detail?employee_id=<%=prev_id%>";
		});
		
		const nextBtn = document.getElementById("nextBtn");
		
		nextBtn?.addEventListener("click", (e) => {
			console.log(nextBtn);
			location.href = "./detail?employee_id=<%=next_id%>";
		});
		
		const backToListBtn = document.getElementById("backToListBtn");
		
		// redirect로 할 거 없이 그냥 list로 보내주면 된다
		backToListBtn.addEventListener("click", (e) => {
			location.href = "./list";
		})
		
		const deletBtn = document.getElementById("deletBtn");
		
		deletBtn.addEventListener("click", (e) => {
			location.href = "./delete?employee_id=<%=emp_id%>";
		})
		
		const editBtn = document.getElementById("editBtn");
		const detailWrap = document.getElementById("detail_wrap");
		const updateWrap = document.getElementById("update_wrap");
		const editCancleBtn = document.getElementById("edit-cancle-Btn");
		
		editCancleBtn.style.display = "none";
		
		editBtn.addEventListener("click", (e) => {
			detailWrap.style.display = "none";
			updateWrap.style.display = "block";
			editBtn.style.display = "none";
			editCancleBtn.style.display = "block";
		});
		
		editCancleBtn.addEventListener("click", (e) => {
			detailWrap.style.display = "block";
			updateWrap.style.display = "none";
			
			editBtn.style.display = "block";
			editCancleBtn.style.display = "none";
		})
		
		
		
		
	</script>
	
</body>
</html>