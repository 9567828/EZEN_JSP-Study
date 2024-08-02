package jspBoard.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.web.WebProcess;

public class BoardWriteFormProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
	
		return "/board/wirteForm";
	}

}
