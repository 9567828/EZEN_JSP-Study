package loginCRUD.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginCRUD.dao.DBconnection;
import loginCRUD.web.WebProcess;
import loginCRUD.webprocess.ChangePwFormProcess;
import loginCRUD.webprocess.ChangePwProcess;
import loginCRUD.webprocess.CheckPwFormProcess;
import loginCRUD.webprocess.CheckPwProcess;
import loginCRUD.webprocess.ErrorProcess;
import loginCRUD.webprocess.JoinFormProcess;
import loginCRUD.webprocess.JoinProcess;
import loginCRUD.webprocess.LeaveProcess;
import loginCRUD.webprocess.LogOutProcess;
import loginCRUD.webprocess.LoginFormProcess;
import loginCRUD.webprocess.LoginProcess;
import loginCRUD.webprocess.MemListProcess;
import loginCRUD.webprocess.MemListUpdateProcess;
import loginCRUD.webprocess.MyPageProcess;
import loginCRUD.webprocess.SuccessProcess;


public class ForwardServlet extends HttpServlet {
	final private static HashMap<String, WebProcess> URI_MAPPING = new HashMap<>();
	
	final private static String PREFIX = "/WEB-INF/views";
	final private static String SUFFIX = ".jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		config.getServletContext().setAttribute("db", 
				new DBconnection(
						config.getInitParameter("dbUrl"), 
						config.getInitParameter("user"), 
						config.getInitParameter("pw")));
		
		URI_MAPPING.put("GET:/error", new ErrorProcess());
		URI_MAPPING.put("GET:/success", new SuccessProcess());
		URI_MAPPING.put("GET:/member/join", new JoinFormProcess());
		URI_MAPPING.put("POST:/member/join", new JoinProcess());
		URI_MAPPING.put("GET:/member/login", new LoginFormProcess());
		URI_MAPPING.put("POST:/member/login", new LoginProcess());
		URI_MAPPING.put("GET:/member/myPage", new MyPageProcess());
		URI_MAPPING.put("GET:/member/memList", new MemListProcess());
		URI_MAPPING.put("GET:/member/memList", new MemListUpdateProcess());
		URI_MAPPING.put("GET:/member/checkPassword", new CheckPwFormProcess());
		URI_MAPPING.put("POST:/member/checkPassword", new CheckPwProcess());
		URI_MAPPING.put("GET:/member/changePassword", new ChangePwFormProcess());
		URI_MAPPING.put("POST:/member/changePassword", new ChangePwProcess());
		URI_MAPPING.put("GET:/member/logout", new LogOutProcess());
		URI_MAPPING.put("GET:/member/leave", new LeaveProcess());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
	    resp.setCharacterEncoding("UTF-8");
		
		String method = req.getMethod();
		String uri = req.getRequestURI();
		
		System.out.println("요청방식: " + method);
		System.out.println("요청URI: " + uri);
		System.out.println("만들어내는키 - " + method + ":" + uri);
		
		WebProcess wp = URI_MAPPING.get(method + ":" + uri);
		
		String nextView = null;
		if (wp != null) {
			nextView = wp.process(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/error");
			return;
		}
		
		if (nextView.startsWith("redirect:")) {
			resp.sendRedirect(nextView.substring("redirect:".length()));
		} else {
			req.getRequestDispatcher(PREFIX + nextView + SUFFIX).forward(req, resp);
		}
	}
}
