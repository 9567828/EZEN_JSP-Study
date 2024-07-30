package login_page.webprocess;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_page.dao.Ojdbcconnection;
import login_page.web.WebProcess;

public class loginProcess implements WebProcess {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		Ojdbcconnection ojdbc = (Ojdbcconnection) request.getServletContext().getAttribute("ojdbc");
		String sql = "SELECT account_id, account_pw FROM accounts WHERE account_id";
		
		return "/member/login";
	}

}
