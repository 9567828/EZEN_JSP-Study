package jspBoard.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.web.WebProcess;

public class BoardIndexProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// DB에서 모든 게시글 목록을 가져온다
		
		// 어트리뷰트에 데이터를 실어놓는다
		
		
		return "/board/list";
	}

}
