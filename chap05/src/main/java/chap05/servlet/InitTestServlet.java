package chap05.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitTestServlet extends HttpServlet {
	
	// init(): 이 서블릿이 최초로 실행 될 때 딱한 번 실행되는 메서드
	// 		   해당 서블릿의 초기화 작업을 위해 사용할 수 있게끔 만들어 두었다
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String user = config.getInitParameter("db_account");
		String pw = config.getInitParameter("db_password");
		
		System.out.println(user);
		System.out.println(pw);
	}
	
	
	// 결국은 doGet을 쓴다는 의미이다. post가 들어오면 doGet으로 보내버린다 = service 쓰는거랑 별 반 차이가 없다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ServletContext : 서블릿들을 담아놓는 통과 소통할 수 있는 객체 (즉, 서버 그 자체를 의미한다=톰캣)
		ServletContext application = req.getServletContext();
		
		// web.xml에서 <context-param>으로 등록한 초기화 파라미터들은 톰캣에 등록되어 있다
		System.out.println(application.getInitParameter("puppy_img"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
