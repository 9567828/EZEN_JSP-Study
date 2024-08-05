package jspBoard.web;

import javax.servlet.http.HttpServletRequest;

public class CheckParameters {
	
	public static Integer parseInt(HttpServletRequest req, String name) {
		// 1. 파라미터에서 꺼낸 값이 null인가? (이름이 틀렸거나 값이 진짜로 null이거나)
		String strValue = req.getParameter(name);
		if (strValue == null) {
			return null;
		}
		
		// 2.Integer로 변환될 수 있는 값인가?
		try {
			return Integer.parseInt(strValue);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
