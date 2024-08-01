package loginCRUD.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginCRUD.dao.DBconnection;
import loginCRUD.dto.Members;
import loginCRUD.web.WebProcess;

public class LeaveProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
		
		HttpSession session = request.getSession();
		
		String sql = "DELETE FROM accounts WHERE account_id = ?";
		// Members userId = (Members) session.getAttribute("userId");
		String userId = (String) session.getAttribute("userId");
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, userId);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				session.invalidate();
				return "redirect:/member/leave";
			} else {
				System.out.println("탈퇴 실패");
				request.setAttribute("failedLeave", "탈퇴 실패 했습니다");
				return "/error";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/member/leave";
	}

}
