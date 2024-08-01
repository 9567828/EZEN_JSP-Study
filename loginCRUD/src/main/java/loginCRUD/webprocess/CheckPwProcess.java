package loginCRUD.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginCRUD.dao.DBconnection;
import loginCRUD.web.WebProcess;

public class CheckPwProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
		
		String sql = "SELECT account_id, account_pw FROM accounts WHERE account_pw = ?";
		String inputPw = request.getParameter("account_pw");
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, inputPw);
			
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					if (inputPw.equals(rs.getString("account_pw"))) {
						System.out.println("비밀번호 일치");
						request.setAttribute("prevPw", rs.getString("account_pw"));
						return "redirect:/member/changePassword";
					}
				} else {
					System.out.println("비번 틀림");
					request.setAttribute("wrongPw", "비밀번호가 틀립니다.");
					return "/member/checkPassword";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/member/checkPassword";
	}

}
