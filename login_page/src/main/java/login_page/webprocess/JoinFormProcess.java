package login_page.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_page.dao.Ojdbcconnection;
import login_page.dto.Members;
import login_page.web.WebProcess;

public class JoinFormProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		
		String sql = "SELECT * FROM accounts WHERE account_id = ?";
	
		try (
			Connection conn = ojdbc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, request.getParameter("account_id"));
			
			try (ResultSet rs = pstmt.executeQuery()) {
				rs.next();
				request.setAttribute("mem", new Members(
						rs.getString("account_id"),
						rs.getString("account_email"),
						rs.getString("account_pw"),
						rs.getDate("join_date"),
						rs.getString("member_status"),
						rs.getString("terms_agree").charAt(0),
						rs.getString("social_login"),
						rs.getDate("change_pw_date")
						));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/member/join";
	}

}
