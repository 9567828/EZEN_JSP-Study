package chap04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/ex/*")
public class CookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청 URL: " + req.getRequestURL());
		System.out.println("요청 URI: " + req.getRequestURI());
		
		String root = "/chap04/cookie/ex/";
		String uri = req.getRequestURI();
		
		// 하나의 서블릿에서 uri에 따라 다른 처리를 진행해 줄 수 있다
		String cmd = uri.substring(root.length());
		
		System.out.printf("URI가 %s일 때, cmd는 %s입니다.\n", uri, cmd);
		
		if (cmd.equals("list")) {
			// 목록을 보여주는 기능
			// 클라이언트가 보유하고 있는 쿠키는 모든 요청에 함께 실려오게 된다(경로만 맞다면)
			// 쿠키를 하나만 꺼내는 메서드가 기본적으로 구현 되어 있지 않다
			Cookie[] cookies = req.getCookies();
			
			// 어트리뷰트에는 모든 자바 객체를 추가할 수 있지만 Object로 업캐스팅 된다.
			// 그래서 꺼낼 때는 다운캐스팅을 하게 되는 것
			req.setAttribute("cookies", cookies);
			
			// 쿠키 밑에 쿠키 리스트를 forward로 넘겨서 보여줄 것임
			req.getRequestDispatcher("/cookie/cookie_list.jsp").forward(req, resp);
			
		} else if (cmd.equals("add")) {
			// 새로운 쿠키를 응답에 함께 실어 보내면 응답을 받은 웹브라우져에 추가된다
			Cookie cookie = new Cookie("fav", "apple");
			cookie.setMaxAge(-1); // 웹브라우져가 꺼지면 함게 삭제되는 쿠기 (세션쿠키)
			cookie.setPath("/chap04/cookie");
			
			Cookie cookie2 = new Cookie("coffee", "mega-coffee");
			cookie2.setMaxAge(5); // 수명이 5초만 되는 쿠키 새로고침하면 5초뒤에 사라진다
			cookie2.setPath("/chap04/cookie");
			
			Cookie cookie3 = new Cookie("employee", "Smith");
			cookie3.setMaxAge(60 * 5); // 수명 5분 쿠키
			cookie3.setPath("/chap04/cookie");
			
			resp.addCookie(cookie);
			resp.addCookie(cookie2);
			resp.addCookie(cookie3);
			resp.sendRedirect("/chap04/cookie/cookie_index.jsp");			
		} else {
			// URI가 원하는 cmd가 아닐 때 그냥 메인으로 redirect를 걸어준다.
			resp.sendRedirect("/chap04/cookie/cookie_index.jsp");
		}
	}

}
