package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	/chap01/gugudan으로 접속하는 사용자들에게
 	멋있는 구구단 페이지를 응답하도록 만들어보세요
*/

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 한글 제대로 나오게
		resp.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("EUC-KR");
		
		PrintWriter out = resp.getWriter();
		
//		out.print("<html><head><title>구구단</title></head><body>");
//		out.print("<div style=\"display: grid; grid-template-columns: repeat(8, 1fr); gap: 10px\">");
//		for (int i = 1; i <= 9; ++i) {
//			for (int j = 2; j <= 9; ++j) {
//				out.print(j + "x" + i + "=" + i * j);
//			}
//		}
//		out.print("</div></body></html>");
		
		// 풀이
		// 이 페이지를 볼 대 당시 웹 브라우저의 URL은
		// http://localhost:9000/chap01/ugugdan이므로
		// 올바르게 css파일을 찾아가기 위해서는 위의 주소를 염두에 두고 주소를 설정해야 한다.
		// href를 ./css/gugudan.css로 설정하면
		// 결과적으로 찾아가는 전체 주소는 http://localhost:9000/chap01/css/gugudan.css가 된다
		// 서버는 저 주소의 자원을 webapp 밑의 폴더에서 찾게 된다
		out.print("<html><head><meta charset=\"UTF-8\">");
		out.print("<title>greatest wonderful gugudan</title>");
		out.print("<link rel=\"stylesheet\" href=\"./css/gugudan.css\">");
		out.print("</head><body>");
		out.print("<h3>아즈 므싯는 구구단</h3>");
		out.print("<div id=\"gugudan\"></div>");
		out.print("<script src=\"./js/gugudan.js\"></script></body>");
	}

}






