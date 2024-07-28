package chap06.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.Ojdbcconnection;
import chap06.web.WebProcess;
import chap06.webprocess.EmpDeleteProcess;
import chap06.webprocess.EmpDetailProcess;
import chap06.webprocess.EmpListProcess;
import chap06.webprocess.EmpUpdateProcess;
import chap06.webprocess.HelloProcess;

public class ForwardServlet extends HttpServlet {
	
	// 매핑에 들어가는 String 타입은 uri와 method가 된다
	final private static HashMap<String, WebProcess> URI_MAPPING = new HashMap<>();
	
	final private static String PREFIX = "/WEB-INF/views";
	final private static String SUFFIX = ".jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서버(application)의 어트리뷰트에 DB 연결 객체를 미리 추가해둔다
		config.getServletContext().setAttribute("ojdbc", new Ojdbcconnection(config.getInitParameter("jdbcUrl"), config.getInitParameter("user"), config.getInitParameter("pw")));
				
		URI_MAPPING.put("GET:/hello", new HelloProcess());
		URI_MAPPING.put("GET:/emp/list", new EmpListProcess());
		URI_MAPPING.put("GET:/emp/detail", new EmpDetailProcess());
		URI_MAPPING.put("GET:/emp/delete", new EmpDeleteProcess());
		URI_MAPPING.put("GET:/emp/update", new EmpUpdateProcess());
		
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
			// service 함수를 끝내줘야 하기 때문에 return을 걸어준다
			return;
		}
		
		// 이후에 화면을 그리기 위해 JSP페이지로 포워드 한다.
		// process에 들어갈 경로를 축소 시키기 위해서 반복으로 들어가는 내용을 넣어준다
		// 리다이렉트 구문이 있으면 리다이렉트로 가고 아니면 포워드 시켜준다
		if (nextView.startsWith("redirect:")) {
			resp.sendRedirect(nextView.substring("redirect:".length()));
		} else {
			req.getRequestDispatcher(PREFIX + nextView + SUFFIX).forward(req, resp);			
		}
	}
	
}
