package loginCRUD.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginCRUD.dao.DBconnection;
import loginCRUD.web.WebProcess;

public class LoginFormProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
		
		String sql = "SELECT account_id, account_pw FROM accounts";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			try(ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					rs.getString("account_id");
					rs.getString("account_pw");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/member/login";
	}

}
