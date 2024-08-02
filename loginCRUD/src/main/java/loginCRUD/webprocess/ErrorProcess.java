package loginCRUD.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginCRUD.web.WebProcess;

public class ErrorProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		
		request.setAttribute("error_m", "에러페이지 입니다");
		
		return "/error";
	}

}
