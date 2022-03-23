package kiemtra;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	// táº¡o vÃ  gá»­i cookie vá»� client Ä‘á»ƒ lÆ°u
	public static Cookie add(String name, String value, int hours, HttpServletResponse response) {
		Cookie cookie = new Cookie(name,value);
		cookie.setMaxAge(hours*60*60);
		cookie.setPath("/");
		response.addCookie(cookie);
		return cookie;
		
	}
	// Ä‘á»�c giÃ¡ trá»‹ cookie gá»­i tá»« client
	public static String get(String name,HttpServletRequest request) {
		
		Cookie [] cookie = request.getCookies();
		if (cookie != null) {
			for(Cookie cookie1: cookie) {
				if(cookie1.getName().equalsIgnoreCase(name)) {
					return cookie1.getValue();
				}
			}
		}
		return "";
	}

}

