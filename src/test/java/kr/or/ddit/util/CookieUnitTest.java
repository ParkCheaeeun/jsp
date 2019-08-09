package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUnitTest {

	/**
	* Method : getCookieTest
	* 작성자 : PC-09
	* 변경이력 :
	* Method 설명 : 쿠키 가져오기 테스트
	*/
	@Test
	public void getCookieTest() {
		/***Given***/
//		String cookieString = "userId=brown; rememberMe=Y; test=testValue";
		String cookieString = "rememberMe=Y; userId2=sally; test=testValue; userId=brown";
		
		/***When***/
		String cookieValue = CookieUtil.getCookie(cookieString, "userId");
		String cookieValue2 = CookieUtil.getCookie(cookieString, "rememberMe");
		String cookieValue3 = CookieUtil.getCookie(cookieString, "test");
		String cookieValue4 = CookieUtil.getCookie(cookieString, "userId2");
		
		/***Then***/
		assertEquals("brown", cookieValue);
		assertEquals("Y", cookieValue2);
		assertEquals("testValue", cookieValue3);
		assertEquals("sally", cookieValue4);

	}

}
