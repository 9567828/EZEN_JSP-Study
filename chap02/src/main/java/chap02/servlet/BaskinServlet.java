package chap02.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/baskin31")
public class BaskinServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] iflavors = req.getParameterValues("iflavor");
		
		System.out.println("선택한 맛");
		for (String iflavor : iflavors) {
			System.out.println(iflavor);
		}
		
	}

}
