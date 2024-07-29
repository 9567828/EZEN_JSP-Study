package chap06.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.Ojdbcconnection;
import chap06.web.WebProcess;

public class loginProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		String sql = "SELECT account_id, account_pw FROM accounts WHERE account_id";
		
		return "/member/login";
	}

}
