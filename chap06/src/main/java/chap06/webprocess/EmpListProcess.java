package chap06.webprocess;

import java.sql.Connection;
import java.sql.DriverManager;
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

public class EmpListProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		
		String sql = "SELECT * FROM employees2";
		
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			List<Employee> empList = new ArrayList<>();
			while(rs.next()) {
				Employee emp = new Employee(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("job_id"),
						rs.getDouble("salary"),
						rs.getDouble("commission_pct"),
						rs.getInt("department_id")
						);
				empList.add(emp);
			}
			request.setAttribute("empList", empList);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return "/emp/list";
	}

}
