package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;

public class UserServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	private IUserService userService;
	
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Method : getUserTest 작성자 : PC-09 변경이력 : Method 설명 :사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/*** Given ***/
		String userId = "brown";

		/*** When ***/
		User userVo = userService.getUser(userId);

		/*** Then ***/
		assertEquals("브라운", userVo.getUserName());
		assertEquals("brown1234", userVo.getPass());

	}

	@Test
	public void getUserListtest() {
		/*** Given ***/

		/*** When ***/
		List<User> userList = userService.getUserList();
		List<User> HalfuserList = userService.getUserHalfList();

		/*** Then ***/
		assertEquals(105, userList.size());
		assertEquals(50, HalfuserList.size());
	}

}
