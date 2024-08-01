package chap02.servlet;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form/answer")
public class TicketServlet extends HttpServlet {
	int adultDayPrice = 54000;
	int adultNightPrice = 45000;
	int TeenDayPrice = 46000;
	int TeenNightPrice = 39000;
	int childDayPrice = 43000;
	int childNightPrice = 36000;
	
	
	public static boolean isDayOrNight (int hour) {
		return hour <= 17 ? true : false;
	}
	
	public void buyTicket(int h, int m, String B, String T, String S, int tB, int tT, int tS) {
		int price1 = 0;
		int price2 = 0;
		int price3 = 0;
		
		if (!isDayOrNight(h)) {
			if (B.equals("daybig") || T.equals("dayTeen") || S.equals("dayS")) {
				price1 = 45000 * tB;
				System.out.printf("대인야간 구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tB, price1, h, m);
				price2 = 39000 * tS;
				System.out.printf("청소년야간 구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tT, price2, h, m);
				price3 = 36000 * tT;
				System.out.printf("소인/경로야간 구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tS, price3, h, m);
			} else {
				price1 = 45000 * tB;
				System.out.printf("대인야간 구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tB, price1, h, m);
				price2 = 39000 * tS;
				System.out.printf("청소년야간 구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tS, price2, h, m);
				price3 = 36000 * tT;
				System.out.printf("소인/경로야간 구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tT, price3, h, m);
			}
		} else {
			if (B.equals("nightbig") || T.equals("nightTeen") || S.equals("nightS")) {
				System.out.println("주간시간에는 야간티켓 구매 불가합니다");
			}
			if (B.equals("daybig")) {
				price1 = 54000 * tB;
				System.out.printf("대인주간 구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tB, price1, h, m);
			}
			if (T.equals("dayTeen")) {
				price2 = 46000 * tT;
				System.out.printf("청소년주간구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tT, price2, h, m);
			}
			if (S.equals("dayS")) {
				price3 = 43000 * tS;
				System.out.printf("소인/경로주간 구매 수량: %d, 가격: %d, 구매시간: %d시 %d분\n", tS, price3, h, m);
			}
		};

		System.out.println("총 구매가격: " + (price1 + price2 + price3));
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalTime now = LocalTime.now();
		
		int hours = now.getHour();
		int minute = now.getMinute();
				
		String ticketTypeB = req.getParameter("ticketBig");
		String ticketTypeT = req.getParameter("ticketTeen");
		String ticketTypeS = req.getParameter("ticketS");
		int ticketQtyB = Integer.parseInt(req.getParameter("amountB"));
		int ticketQtyT = Integer.parseInt(req.getParameter("amountT"));
		int ticketQtyS = Integer.parseInt(req.getParameter("amountS"));
		
		buyTicket(hours, minute, ticketTypeB, ticketTypeT, ticketTypeS, ticketQtyB, ticketQtyT, ticketQtyS);
		
		
		System.out.printf("선택한티켓: %s, 수량: %s\n", ticketTypeB, ticketQtyB);
		System.out.printf("선택한티켓: %s, 수량: %s\n", ticketTypeT, ticketQtyT);
		System.out.printf("선택한티켓: %s, 수량: %s\n", ticketTypeS, ticketQtyS);
		
		
	}

}
