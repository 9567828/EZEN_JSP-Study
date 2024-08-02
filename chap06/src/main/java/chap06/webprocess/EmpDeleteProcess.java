package chap06.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.Ojdbcconnection;
import chap06.web.WebProcess;

public class EmpDeleteProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		
		String sql = "DELETE FROM employees2 WHERE employee_id = ?";
		int emp_id = Integer.parseInt(request.getParameter("employee_id"));
		
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, emp_id);
			int row = pstmt.executeUpdate();
			
			if (row > 0) {
				// 삭제가 잘 된 경우 리다이렉트 (리다이렉트 처리는 forwardServlet에서 한다)
				return "redirect:/emp/list";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 삭제가 안된 경우 다시 원래 상세 페이지로 가라
		return "redirect:/emp/detail?employee_id=" + emp_id;
	}
	
}
