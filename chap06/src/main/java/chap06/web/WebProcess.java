package chap06.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹프로젝트의 요청은 항상 일정한 절차를 지니게 된다
// 요청 -> 처리 -> 화면 그리기 -> 응답

public interface WebProcess {
	// 웹 요청에 대한 처리를 하고 나면 항상 우리는 다음 .jsp의 경로 (다음페이지의 경로)를 알아야 한다
	// 항상 일정하게 페이지 경로를 전달한다
	String process(HttpServletRequest request, HttpServletResponse response);
	
}