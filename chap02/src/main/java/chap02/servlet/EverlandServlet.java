package chap02.servlet;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form/answerT")
public class EverlandServlet extends HttpServlet {
	
	private static HashMap<String, HashMap<String, Integer>> priceMap = new HashMap<>();
	
	static {
		priceMap.put("adult", new HashMap<String, Integer>());
		priceMap.put("youth", new HashMap<String, Integer>());
		priceMap.put("child", new HashMap<String, Integer>());
		
		priceMap.get("adult").put("day", 54000);
		priceMap.get("adult").put("night", 45000);
		priceMap.get("youth").put("day", 46000);
		priceMap.get("youth").put("night", 39000);
		priceMap.get("child").put("day", 43000);
		priceMap.get("child").put("night", 36000);
	};
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 수량입력을 안하면 빈값으로 들어온다. 처리가 필요함
		String adultTickeQty = req.getParameter("adult-ticket-qty");
		String youthTickeQty = req.getParameter("youth-ticket-qty");
		String childTickeQty = req.getParameter("child-ticket-qty");
		
		String adultTickeType = req.getParameter("adult-ticket-type");
		String youthTickeType = req.getParameter("youth-ticket-type");
		String childTickeType = req.getParameter("child-ticket-type");
		
		// 타입이 없는채로 이 서블릿에 들어오면 다른 페이지로 보내버리겠다.. (리다이렉트)
		if (adultTickeType == null || adultTickeType.equals("") 
				|| youthTickeType == null || youthTickeType.equals("") 
				|| childTickeType == null || childTickeType.equals("")) {
			// 다른 페이지로 보내는 작업
			resp.sendRedirect("/chap02/form/index.jsp");
		}
		
		System.out.println("대인 수량: " + adultTickeQty);
		System.out.println("청소년 수량: " + youthTickeQty);
		System.out.println("소인 수량: " + childTickeQty);
		
		int aQty = 0;
		int yQty = 0;
		int cQty = 0;
		
		// 받은 파라미터가 null이거나 비어있는 문자열인 경우 대비해야 한다.
		if (adultTickeQty != null && !adultTickeQty.equals("")) {
			aQty = Integer.parseInt(adultTickeQty);
		}
		if (youthTickeQty != null && !youthTickeQty.equals("")) {
			yQty = Integer.parseInt(adultTickeQty);
		}
		if (childTickeQty != null && !childTickeQty.equals("")) {
			cQty = Integer.parseInt(adultTickeQty);
		}
		
		int aPrice = priceMap.get("adult").get(adultTickeType);
		int yPrice = priceMap.get("youth").get(youthTickeType);
		int cPrice = priceMap.get("child").get(childTickeType);
		
		StringBuilder message = new StringBuilder();
		
		message.append("## 주문하신 티켓 현황##\n");
		message.append("대인: ");
		message.append(adultTickeQty);
		message.append("(");
		message.append(adultTickeType);
		message.append(") x ");
		message.append(aPrice);
		message.append(" 청소년: ");
		message.append(youthTickeQty);
		message.append("(");
		message.append(youthTickeType);
		message.append(") x ");
		message.append(yPrice);
		message.append(" 소인/경로: ");
		message.append(childTickeQty);
		message.append("(");
		message.append(childTickeType);
		message.append(") ");
		message.append(cPrice);
		message.append("원\n");
		message.append("-------------------\n");
		message.append("총\t");
		
		int totalPrice = aPrice * aQty + yPrice * yQty + cPrice * cQty;
		
		message.append(totalPrice);
		message.append("원\n");
		
		System.out.println(message);
	}
}
