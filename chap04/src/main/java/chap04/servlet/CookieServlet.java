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
		} else if (cmd.equals("delete")) {
			// 이미 존재하는 쿠키를 삭제할 때는 요청에 실려있는 쿠키의 
			// 수명을 0으로 수정한 후에 응답에 실어보내주면 된다
			// 하나씩 꺼내주는 메서드가 없어서 for문을 써야 한다.
			Cookie[] cookies = req.getCookies();
			
			// 쿠키가 null이 아닐 때 for문 돌아라
			if (cookies != null) {
				String to_delete = req.getParameter("cookie-name");
				System.out.println("내가 지워야 하는 쿠키이름: " + to_delete);
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(to_delete)) {
						// 해당 이름의 쿠키를 수명 0으로 만들고 응답에 실어 삭제 
						cookie.setMaxAge(0);
						// 삭제를 제대로 하기 위해서 경로를 설정해줘야 한다.
						// cookie는 네임과 벨류만 주고 받기 때문에 쿠키를 정확하게 설정해주어야 한다.
						cookie.setPath("/chap04/cookie");
						resp.addCookie(cookie);
						break;
					}
				}				
			}
			// 이 서블릿의 list 커맨드로 다시 요청 해주세요 라고 응답 (리다이렉트 원리)
			resp.sendRedirect("/chap04/cookie/ex/list");
		} else if (cmd.equals("modify")) {
			String to_modi = req.getParameter("to_modi");
			String modi_value = req.getParameter("modi_value");
			
			System.out.println("바꿔야 하는 쿠키이름: " + to_modi);
			System.out.println("바꾸고 싶은 값: " + modi_value);
			
			// 쿠키 값을 수정하고 싶으면 해당 쿠키를 꺼내서 값을 바꾼 후 응답에 다시 실어놓으면 된다
			Cookie[] cookies = req.getCookies();
			
			if(cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(to_modi)) {
						cookie.setValue(modi_value);
						cookie.setPath("/chap04/cookie");
						resp.addCookie(cookie);
						break;
					}
				}
			}
			
			// 수정이 끝나면 다시 목록으로 돌아가라
			resp.sendRedirect("/chap04/cookie/ex/list");
			
			// modify는 풀이, 나는 edit으로 함 아래.
//			Cookie[] cookies = req.getCookies();
//			String to_editValue = req.getParameter("edit-cookie-value");
//			String cookieValue = req.getParameter("cookie-value");
//			
//			int len = to_editValue.length();
//			char ch = 0;
//			
//			for (int i = 0; i < len; ++i) {
//				ch = to_editValue.charAt(i);
//				if (to_editValue.isEmpty() && ch == ' ') {
//					break;
//				}
//			}
//			
//			
//			if(cookies != null && !to_editValue.isEmpty()) {
//				System.out.println("수정할 벨류: " + cookieValue);
//				System.out.println("수정될 이름: " + to_editValue);
//				
//				for (Cookie cookie : cookies) {				
//					if (cookie.getValue().equals(cookieValue)) {
//						cookie.setValue(to_editValue);
//						cookie.setPath("/chap04/cookie");
//						resp.addCookie(cookie);
//						break;
//					}
//				}				
//			}
//			resp.sendRedirect("/chap04/cookie/ex/list");
		} else {
			// URI가 원하는 cmd가 아닐 때 그냥 메인으로 redirect를 걸어준다.
			resp.sendRedirect("/chap04/cookie/cookie_index.jsp");
		}
	}

}
