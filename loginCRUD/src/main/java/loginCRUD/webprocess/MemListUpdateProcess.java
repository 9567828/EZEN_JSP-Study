package loginCRUD.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginCRUD.dao.DBconnection;
import loginCRUD.dto.Members;
import loginCRUD.web.WebProcess;

public class MemListUpdateProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
		
		HttpSession session = request.getSession();
		String managerId = (String) session.getAttribute("managerId");
		String userId = (String) session.getAttribute("userId");
		
		 if (managerId == null) {
            // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            return "redirect:/member/login";
        }

		String sql = "UPDATE accounts SET member_status = ?, access_manager = ? WHERE account_id = ?";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, request.getParameter("member_status"));
			pstmt.setString(2, request.getParameter("access_manager"));
			pstmt.setString(3, userId);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("수정성공");
				return "./memList";
			} else {
				System.out.println("수정 실패");
				request.setAttribute("failedM", "수정이 실패했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return "/member/memList";
	}

}
