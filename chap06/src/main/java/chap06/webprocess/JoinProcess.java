package chap06.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.Ojdbcconnection;
import chap06.web.WebProcess;

public class JoinProcess implements WebProcess {
	
	public boolean isExist = false;
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		
		String sql = "INSERT INTO accounts(account_id, account_email, account_pw, join_date, terms_agree, member_status) VALUES(?, ?, ?, sysdate, ?, ?)";
		String sql2 = "SELECT account_id FROM accounts WHERE account_id = ?";
	
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		) {
			pstmt.setString(1, request.getParameter("join_id"));
			pstmt.setString(2, request.getParameter("join_email"));
			pstmt.setString(3, request.getParameter("join_pw_check"));
			pstmt.setString(4, request.getParameter("terms_agree"));
			pstmt.setString(5, request.getParameter("member_status"));
			pstmt.executeUpdate();
			
			pstmt2.setString(1, request.getParameter("join_id"));
			
			try (ResultSet rs = pstmt2.executeQuery()) {
				while (rs.next()) {
					if (request.getParameter("join_id") == rs.getString("account_id")) {
						isExist = true;
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/member/join";
	}

}
