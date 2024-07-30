package chap03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_password");
		
		System.out.println("user_id: " + user_id);
		System.out.println("user_password: " + user_pw);
		
		if(user_id != null && user_id.equals("testuser") 
			&& user_pw != null && user_pw.equals("4321")) {
			System.out.println("로그인 성공!");
			
			// 요청객채에서 세션 객체를 호출 할 수 있다
			HttpSession session = req.getSession();
			
			// 세션 객체에도 setAttribute()를 통해 데이터를 실어 놓을 수 있다
			// 로그인 실패는 등록 안하는 것으로
			session.setAttribute("login", true);
		} else {
			System.out.println("로그인 실패");
		}
		
		// 로그인 성공/실패 여부에 따라 결과가 달라지는 페이지로 보내주는 redirect를 설정해준다
		resp.sendRedirect("/chap03/attribute/sample/loginResultPage.jsp");
		
	}

}
