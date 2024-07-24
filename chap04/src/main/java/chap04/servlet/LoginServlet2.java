package chap04.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login2/*")
public class LoginServlet2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String cmd = uri.substring("/chap04/login2/".length());
		
		
		System.out.println("ip addr: " + req.getRemoteAddr());
		System.out.println("url: " + req.getRequestURL());
		System.out.println("uri: " + uri);
		System.out.println("cmd: " + cmd);
		
		HttpSession session = req.getSession();
		
		if (cmd.equals("success")) {
			session.setAttribute("user", "김민수");
			
			// 해당 세션ID에 만료시간 설정하기 (초)
			session.setMaxInactiveInterval(10);
			
			resp.sendRedirect("/chap04/login2/result");
		} else if (cmd.equals("result")) {
			req.getRequestDispatcher("/session/session_ex.jsp").forward(req, resp);
		} else if (cmd.equals("logout")) {
			// 세션 어트리뷰트에 user 가 없으면 로그아웃으로 간주
			session.removeAttribute("user");
			
			session.setMaxInactiveInterval(1800); // 세션 만료시간 없애기
			
			resp.sendRedirect("/chap04/login2/result");
			
		} else if (cmd.equals("close")) {
			session.invalidate(); // 세션 만료시키기
			
			// 세션 만료 후 리다이렉트시 바로 새로운 세션ID를 발급받게 된다
			resp.sendRedirect("/chap04/login2/result");
			
		}
	}
}
