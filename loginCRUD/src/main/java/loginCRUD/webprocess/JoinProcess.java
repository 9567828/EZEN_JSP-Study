package loginCRUD.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginCRUD.dao.DBconnection;
import loginCRUD.web.WebProcess;

public class JoinProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
		
		HttpSession session = request.getSession();
		
		String checkIdSql = "SELECT account_id FROM accounts WHERE account_id = ?";
		String insertSql = "INSERT INTO accounts"
				+ "(account_id, account_email, account_pw, terms_agree, member_status, join_date) "
				+ "VALUES (?, ?, ?, ?, ?, sysdate)";
		
		String inputJoinId = request.getParameter("account_id");
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt1 = conn.prepareStatement(checkIdSql);
			PreparedStatement pstmt2 = conn.prepareStatement(insertSql);
		) {
			
			pstmt1.setString(1, inputJoinId);
			try(ResultSet rs = pstmt1.executeQuery()) {
				if (rs.next()) {
					request.setAttribute("existId", "이미 존재하는 아이디 입니다.");
					return "/member/join";
				}
			}
			
			pstmt2.setString(1, inputJoinId);
			pstmt2.setString(2, request.getParameter("account_email"));
			pstmt2.setString(3, request.getParameter("account_pw"));
			pstmt2.setString(4, request.getParameter("terms_agree"));
			pstmt2.setString(5, request.getParameter("member_status"));
			
			int result = pstmt2.executeUpdate();
			
			if (result > 0) {
				request.setAttribute("successJoin", "가입 완료 되었습니다~~~!~!");
				session.setAttribute("joinId", inputJoinId);
				return "redirect:/success";
			} else {
				request.setAttribute("faild_join", "가입에 실패하였습니다.");
				return "/member/join";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("가입오류: " + e.getMessage());
		}

		return "/memeber/join";
	}

}
