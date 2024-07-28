package chap06.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.Ojdbcconnection;
import chap06.dto.Employee;
import chap06.web.WebProcess;

public class EmpDetailProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		
		String sql = "SELECT * FROM employees2 WHERE employee_id = ?";
		String sql2 = "SELECT max(employee_id) AS max_id, min(employee_id) AS min_id FROM employees2";
		String sql3 = "SELECT job_id, job_title FROM jobs";
		String sql4 = "SELECT department_id, department_name FROM departments";
		
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			PreparedStatement pstmt4 = conn.prepareStatement(sql4);
		) {
			pstmt.setInt(1, Integer.parseInt(request.getParameter("employee_id")));
			
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				rs.next();
				request.setAttribute("emp", new Employee(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("job_id"),
						rs.getDouble("salary"),
						rs.getDouble("commission_pct"),
						rs.getInt("department_id")
						));
			}
			
			// 이전, 다음 버튼의 유무를 확인하기 위해 값들이 필요하다
			try (ResultSet rs = pstmt2.executeQuery()) {
				rs.next();
				request.setAttribute("max_id", rs.getInt("max_id"));
				request.setAttribute("min_id", rs.getInt("min_id"));
			}
			
			try (ResultSet rs = pstmt3.executeQuery()) {
				List<String[]> jobs = new ArrayList<>();
				while(rs.next()) {
					jobs.add(new String[] {rs.getString("job_id"), rs.getString("job_title")});
				}
				request.setAttribute("jobs", jobs);
			}
			
			try (ResultSet rs = pstmt4.executeQuery()) {
				List<String[]> depts = new ArrayList<>();
				while(rs.next()) {
					depts.add(new String[] {rs.getString("department_id"), rs.getString("department_name")});
				}
				request.setAttribute("depts", depts);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/emp/detail";
	}

}
