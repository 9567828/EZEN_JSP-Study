package chap06.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.Ojdbcconnection;
import chap06.dto.Employee;
import chap06.web.WebProcess;

public class EmpUpdateProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		
		String sql = "UPDATE employees2 SET "
				+ "first_name = ? "
				+ "last_name = ? "
				+ "job_id = ? "
				+ "salary = ? "
				+ "commission_pct = ? "
				+ "department_id = ? "
				+ " WHERE employee_id = ?";
		
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, request.getParameter("first_name"));
			pstmt.setString(2, request.getParameter("last_name"));
			pstmt.setString(3, request.getParameter("job_id"));
			pstmt.setDouble(4, Double.parseDouble(request.getParameter("salary")));
			pstmt.setDouble(5, Double.parseDouble(request.getParameter("commission")));
			pstmt.setInt(6, Integer.parseInt(request.getParameter("department_id")));
			pstmt.setInt(7, Integer.parseInt(request.getParameter("emp_id")));			
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/emp/detail";
	}
}
