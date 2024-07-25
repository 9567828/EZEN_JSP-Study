package chap04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/popup/nomore")
public class NomorePopupServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 원하는 쿠키 객체를 생성한다
		Cookie cookie = new Cookie("nomore", "t");
		
		// 쿠키의 만료 시간을 설정 (초단위)
		// 양수: 양수로 설정하면 초를 의미한다
		// 음수: 음수로 설정하면 브라우저 종료 시 삭제되는 쿠키
		// 0: 0으로 설정하면 해당 쿠키를 즉시 삭제한다
		// 24시간 설정법
		cookie.setMaxAge(60 * 60 * 24);
		
		// 쿠키의 적용 경로(범위)를 설정
		// 미설정 시 현재 경로가 자동으로 지정 된다
		// 설정시 해당 경로상에서 적용되는 쿠키가 된다
		cookie.setPath("/chap04/cookie/sample/");
		
		resp.addCookie(cookie);
		resp.sendRedirect("/chap04/cookie/sample/popup_main.jsp");
	}
}
