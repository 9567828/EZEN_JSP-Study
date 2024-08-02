package loginCRUD.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginCRUD.dao.DBconnection;
import loginCRUD.dto.Members;
import loginCRUD.web.WebProcess;

public class MyPageProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		 if (userId == null) {
            // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            return "redirect:/member/login";
        }
		
		String sql = "SELECT rownum, accounts.* FROM accounts WHERE account_id = ?";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, userId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					request.setAttribute("mem", new Members(
							rs.getInt("rownum"),
							rs.getString("account_id"),
							rs.getString("account_email"),
							rs.getString("account_pw"),
							rs.getDate("join_date"),
							rs.getString("member_status"),
							rs.getString("terms_agree").charAt(0),
							rs.getString("social_login"),
							rs.getDate("change_pw_date"),
							rs.getString("access_manager").charAt(0)
					));
				} else {
					// 사용자 정보를 찾을 수 없을 경우
					return "redirect:/member/login";
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return "/member/myPage";
	}

}
