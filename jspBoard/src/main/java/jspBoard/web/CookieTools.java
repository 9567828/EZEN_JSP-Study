package jspBoard.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieTools {
	public static Cookie getCooke(HttpServletRequest req, String name) {
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		
		return null;
	}
}
