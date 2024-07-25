package chap02.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fshop")
public class FruitShopServlet extends HttpServlet {
	
	// 해당 서블릿으로 GET방식 돌아오면  dog
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET방식 요청 입니당");
		
		// form으로 요청보낸 데이터들을 요청 객체의 getParameter() 메서드로 꺼낼 수 있다.
		// getParameter()는 어떤 데이터를 보내던 간에 일단은 문자열로 꺼내게 된다
		String fname = req.getParameter("fname");
		String fprice = req.getParameter("fprice");
		
		System.out.println("도착한 과일이름: " + fname);
		System.out.println("도착한 과일가격: " + fprice);
	}
	
	
	// POST방식 요청은 doPost()에 도착한다
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST방식 요청 입니당");
		
		String fcolor = req.getParameter("fcolor");
		String fname = req.getParameter("fname");
		
		System.out.println("사용자가 고른 색: " + fcolor);
		System.out.printf("사용자가 고른 과일: %s\n", fname);
		
		
	}

}
