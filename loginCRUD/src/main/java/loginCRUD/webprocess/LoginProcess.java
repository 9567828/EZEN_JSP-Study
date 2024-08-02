package loginCRUD.webprocess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginCRUD.dao.DBconnection;
import loginCRUD.web.WebProcess;

public class LoginProcess implements WebProcess {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        DBconnection db = (DBconnection) request.getServletContext().getAttribute("db");
        
        String sql = "SELECT account_id, account_pw, access_manager FROM accounts WHERE account_id = ?";
        String inputId = request.getParameter("account_id");
        String userPw = request.getParameter("account_pw");
        
        HttpSession session = request.getSession();
        
        try (
            Connection conn = db.getConnection();
            PreparedStatement pstmt1 = conn.prepareStatement(sql);
        ) {
            System.out.println("Database connection established");
            pstmt1.setString(1, inputId);
            
            try(ResultSet rs = pstmt1.executeQuery()) {
                if(rs.next()) {
                    String dbPassword = rs.getString("account_pw");
                    String accessManager = rs.getString("access_manager");
                    String userId = rs.getString("account_id");
                    System.out.println("관리자: " + accessManager);
                    
                    if (userPw.equals(dbPassword)) {
                        System.out.println("Password matched");
                        session.setAttribute("userId", userId);
                        session.setAttribute("userPw", dbPassword);
                        
                        accessManager = accessManager.trim(); // 앞뒤 공백 제거
                        
                        if ("Y".equalsIgnoreCase(accessManager)) {
                            System.out.println("관리자 로그인 성공: " + userId);
                            session.setAttribute("managerId", userId);
                            return "redirect:/member/memList?account_id=" + userId;
                        } else {
                            System.out.println("일반 사용자 로그인 성공: " + userId);
                            return "redirect:/member/myPage?account_id=" + userId;
                        }
                    } else {
                        request.setAttribute("failedLogin", "비밀번호가 틀립니다.");
                        return "/member/login";
                    }
                } else {
                    request.setAttribute("failedLoginId", "존재하지 않는 아이디입니다.");
                    return "/member/login";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("예상치 못한 예외 발생: " + e.getMessage());
            request.setAttribute("failedLogin", "로그인 처리 중 오류가 발생했습니다.");
            return "/member/login";
        } finally {
            System.out.println("로그인 완료");
        }
    }
}