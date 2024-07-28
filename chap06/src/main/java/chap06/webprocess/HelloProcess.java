package chap06.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.web.WebProcess;

public class HelloProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// 처리하고 싶은 내용 처리하고 다음으로 가야하는 JSP 페이지의 경로를 리턴
		request.setAttribute("userName", "주형돈");
		return "/hello";
	}

}
