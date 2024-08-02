package jspBoard.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.web.WebProcess;

public class BoardWriteProcess implements WebProcess {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// 받은 파라미터로 DB에 글 추가하기
		// 글 추가하고 나면 board로 리다이렉트한다
		
		return "redirect:/board/";
	}
}
