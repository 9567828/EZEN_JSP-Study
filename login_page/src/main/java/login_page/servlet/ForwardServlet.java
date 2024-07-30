package login_page.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login_page.web.WebProcess;
import login_page.webprocess.JoinFormProcess;
import login_page.webprocess.JoinProcess;
import login_page.webprocess.MemListProcess;
import login_page.webprocess.MypageProcess;
import login_page.webprocess.loginProcess;

public class ForwardServlet extends HttpServlet {
	
	final private static HashMap<String, WebProcess> URI_MAPPING = new HashMap<>();
	
	final private static String PREFIX = "/WEB-INF/views";
	final private static String SUFFIX = ".jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		config.getServletContext().setAttribute("ojdbc", config);
		
		URI_MAPPING.put("GET:/member/join", new JoinFormProcess());
		URI_MAPPING.put("POST:/member/join", new JoinProcess());
		URI_MAPPING.put("GET:/member/login", new loginProcess());
		URI_MAPPING.put("GET:/member/memList", new MemListProcess());
		URI_MAPPING.put("GET:/member/mypage", new MypageProcess());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			resp.sendRedirect(req.getContextPath() + "/");
			return;
		}
		
		if (nextView.startsWith("redirect:")) {
			resp.sendRedirect(nextView.substring("redirect:".length()));
		} else {
			req.getRequestDispatcher(PREFIX + nextView + SUFFIX).forward(req, resp);
		}
	}
}
