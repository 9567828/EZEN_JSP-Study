package chap03.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward/coffee/add")
public class ForwardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청을 받고.. 자바쪽에서 하고싶은 처리를 모두 진행한다
		String cname = req.getParameter("cname");
		String qty = req.getParameter("qty");
		String price = req.getParameter("price");
		
		System.out.println("cname: " + cname);
		System.out.println("qty: " + qty);
		System.out.println("price: "+ price);
		
		// 원래는 PrintWriter를 꺼내서 힘들게 html 코드를 입력해야 하지만
		// HTML코드를 입력하는 부분을 포워드를 통해 다른 .jsp 파일로 넘겨줄 수 있다
		
		// 포워드시에 사용하는 경로는 webapp 밑의 폴더 내부 경로를 사용한다
		// dispatcher는 말 그대로 요청 분배기
		RequestDispatcher dispatcher = req.getRequestDispatcher("/forward/view.jsp");
		
		// forward: 요청/응답 객체를 다른 JSP로 넘겨 처리한 후 그곳에서 응답을 보내버린다
		// include: 요청/응답 객체를 다른 JSP로 넘긴 후 결과를 다시 돌려받아 마저 처리를 진행한다 (서블릿에서는 인클루드는 잘 사용하지 않음)
		// redirect는 조건이 막힌 경우 다른 페이지로 가라고 넘겨주는 것
		// forward는 다른 jsp파일로 넘겨주는 것이다
		
		// req, resp를 그대로 전달하면 된다.
		// 포워드시 현재 서블릿에서 사용하던 요청(req), 응답(resp) 객체를 그대로 전달해준다
		dispatcher.forward(req, resp);

	}

}
