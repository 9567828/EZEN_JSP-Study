package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebSErvlet("uri") : 이 서블릿으로 접속할 때 사용할 URI를 설정한다 

// .jsp로 작정된 JSP코드는 1차적으로 서블릿 형태로 변환된다

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	// HttpServlet 상속 받고 service를 오버라이드 한 것이다~
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// HttpServletRequest : 요청 정보가 담겨있는 객체
		// HttpServletResponse : 이 서블릿이 끝나고 나면 응답하게 될 객체
		
		// 출력을 내보내기 위한 롸이터
		// 응답 객체에 데이터를 실어 놓을 수 있는 통로 객체를 생성
		PrintWriter out = resp.getWriter();
		
		// 문자열의 형태를 HTML로만들어서 보내주면 웹브라우저는 그것을 해석하여 그려준다
		out.print("<html><head><title>JSP입니다</title></head><body>");
		out.print("<div style=\"width:300px; height: 100px; padding: 20px; border: solid 3px black;\">"
				+ "Hello~~" + new Date() + "</div>");
		out.print("</body></html>");
		out.print("Hello~" + new Date());
	}

}
