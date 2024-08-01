package loginCRUD.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginCRUD.dao.DBconnection;
import loginCRUD.web.WebProcess;

public class ChangePwProcess implements WebProcess{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		String sql = "UPDATE accounts SET account_pw = ?, change_pw_date = sysdate WHERE account_id = ?";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, request.getParameter("account_pw"));
			pstmt.setString(2, userId);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("비번변경 성공");
				session.setAttribute("successChange", "비밀번호 변경 성공~!@~!");
				return "redirect:/success";
			} else {
				System.out.println("비번변경 실패");
				request.setAttribute("failedChPw", "비밀번호 변경 실패 했습니다");
				return "/member/changePassword";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/member/changePassword";
	}

}
