package kr.or.ddit.util;

public class CookieUtil {

	/**
	* Method : getCookie
	* 작성자 : PC-09
	* 변경이력 :
	* @param cookieString
	* @param string
	* @return
	* Method 설명 : 쿠키 문자열로부터 특정 쿠키의 값을 반환한다.
	*/
	public static String getCookie(String cookieString, String cookieId) {
		String[] cookies = cookieString.split("; ");
		
		String cookieValue = "";
		for(String cookie : cookies) {
			if(cookie.split("=")[0].equals(cookieId)) {
				cookieValue = cookie.split("=")[1];
				return cookieValue;
			}
		}
		
		return null;
	}

}
