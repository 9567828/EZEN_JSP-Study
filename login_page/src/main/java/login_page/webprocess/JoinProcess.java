package login_page.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_page.dao.Ojdbcconnection;
import login_page.web.WebProcess;

public class JoinProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		
		String sql = "INSERT INTO accounts(account_id, account_email, account_pw, join_date, terms_agree, member_status) VALUES(?, ?, ?, sysdate, ?, ?)";
	
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, request.getParameter("join_id"));
			pstmt.setString(2, request.getParameter("join_email"));
			pstmt.setString(3, request.getParameter("join_pw_check"));
			pstmt.setString(4, request.getParameter("terms_agree"));
			pstmt.setString(5, request.getParameter("member_status"));
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/member/join";
	}

}
