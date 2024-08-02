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
		String userId = (String) session.getAttribute("userId");
		
		if (userId == null || userId.isEmpty()) {
		    System.out.println("userId is null or empty");
		    return "redirect:/login"; // 로그인 페이지로 리다이렉트
		}
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, userId);
			
			System.out.println("탈퇴시도 아이디: " + userId);

			int result = pstmt.executeUpdate();
			
			System.out.println("결과: " + result);
			
	        if (result > 0) {
	            // 세션 무효화 전에 성공 메시지를 request에 저장
	            request.setAttribute("leaveSuccess", "탈퇴가 성공적으로 처리되었습니다.");
	            session.invalidate();
	            return "/member/leave";
	        } else {
	            System.out.println("탈퇴 실패");
	            request.setAttribute("failedLeave", "탈퇴에 실패했습니다");
	            return "/member/leave";
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
	        request.setAttribute("errorMessage", "데이터베이스 오류가 발생했습니다");
	        return "/error";
		}
	}

}
