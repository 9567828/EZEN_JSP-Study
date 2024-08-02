package loginCRUD.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginCRUD.web.WebProcess;

public class LogOutProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse respones) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("managerId");
		session.invalidate();
		
		return "redirect:/member/login";
	}

}
