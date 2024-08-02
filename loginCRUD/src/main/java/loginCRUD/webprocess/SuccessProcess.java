package loginCRUD.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginCRUD.web.WebProcess;

public class SuccessProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		request.getAttribute("successJoin");
		request.getAttribute("successChange");
		return "/success";
	}

}
