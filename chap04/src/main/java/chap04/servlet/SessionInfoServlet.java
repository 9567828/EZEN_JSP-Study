package chap04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/session_info")
public class SessionInfoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service에서는 요청 방식 상관없이 모든 요청을 받는다 GET, POST 구분 없음
		
		// 요청 객체에 실려있는 세션ID가 해당 세션 객체를 받는대에 필요하므로
		// 요청 객체로 세션 객체를 불러야 한다
		
		HttpSession session = req.getSession();
		
		System.out.println("세션ID: " + session.getId());
		System.out.println("최초생성시간: " + session.getCreationTime());
		System.out.println("최근활동시간: " + session.getLastAccessedTime());
		System.out.println("세션만료시간: " + session.getMaxInactiveInterval());
		
		resp.sendRedirect("/chap04/session/session_index.jsp");
	}

}
