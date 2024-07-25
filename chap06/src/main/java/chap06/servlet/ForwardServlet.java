package chap06.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.web.WebProcess;
import chap06.webprocess.EmpListProcess;
import chap06.webprocess.HelloProcess;

public class ForwardServlet extends HttpServlet {
	
	// 매핑에 들어가는 String 타입은 uri와 method가 된다
	final private static HashMap<String, WebProcess> URI_MAPPING = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		URI_MAPPING.put("GET:/hello", new HelloProcess());
		URI_MAPPING.put("GET:/employee/list", new EmpListProcess());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		String uri = req.getRequestURI();
		
		System.out.println("요청방식: " + method);
		System.out.println("요청URI: " + uri);
		System.out.println("만들어내는키 - " + method + ":" + uri);
		
		// 요청방식과 URI에 따라 알맞은 처리를 여기서(서블릿) 진행한다
		// 처리를 진행한 후에는 다음에 어떤 JSp로 포워드 해야할지를 알아야 한다
		WebProcess wp = URI_MAPPING.get(method + ":" + uri);
		
		String nextView = null;
		if (wp != null) {
			nextView = wp.process(req, resp);			
		} else {
			resp.sendRedirect(req.getContextPath() + "/hello");
		}
		
		// 이후에 화면을 그리기 위해 JSP페이지로 포워드 한다.
		req.getRequestDispatcher(nextView).forward(req, resp);
	}
	
}
