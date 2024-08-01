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

public class MemListProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
		
		HttpSession session = request.getSession();
		String managerId = (String) session.getAttribute("managerId");
		
		 if (managerId == null) {
            // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            return "redirect:/member/login";
        }

		String selectSql = "SELECT rownum, accounts.* FROM (SELECT * FROM accounts ORDER BY join_date asc) accounts";
		
		try (
			Connection conn = db.getConnection();
			PreparedStatement selectPstmt = conn.prepareStatement(selectSql);
		) {
			try (ResultSet rs = selectPstmt.executeQuery();) {
				List<Members> memList = new ArrayList<>();
				while(rs.next()) {
					Members mem = new Members(
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
							);
					memList.add(mem);
				}
				request.setAttribute("memList", memList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return "/member/memList";
	}

}
