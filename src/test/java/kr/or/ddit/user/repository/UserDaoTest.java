package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.mybatis;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	private IUserDao userDao;
	private SqlSession sqlsession;
	private UserService userService;
	
	@Before
	public void setup() {
		//junit 테스트 메소드 실행 순서
		// @Before -> @Test -> @After
		// Test 메소드 실행되기 전에 Before 적용된 메소드 먼저 실행, @test 메소드 실행수
		// @After이 적용된 메소드 실행
		logger.debug("before");
		userDao = new UserDao();
		sqlsession = mybatis.getSession();
		userService = new UserService();
	}
	
	@After
	public void tearDown() {
		logger.debug("After");
		sqlsession.close();
	}
	
	/**
	* Method : getUserListtest
	* 작성자 : PC-09
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	*/
	@Test
	public void getUserListtest() {
		/***Given***/
		

		/***When***/
		List<User> userList = userDao.getUserList(sqlsession);
		List<User> HalfuserList = userDao.getUserHalfList(sqlsession);
		
		/***Then***/
		assertEquals(105, userList.size());
		assertEquals(50, HalfuserList.size());
	}
	
	/**
	* Method : getUserTest
	* 작성자 : PC-09
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		
		/***When***/
		User userVo = userDao.getUser(sqlsession, userId);
		
		/***Then***/
		assertEquals("브라운", userVo.getUserName());
		assertEquals("brown1234", userVo.getPass());
		
	}
	
	@Test
	public void getUserPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);

		/***When***/
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		List<User> userList = (List<User>) resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void getUserTotalCountTest() {
		/***Given***/
		
		/***When***/
		int totalCnt = userDao.getUserTotalCount(sqlsession);
		
		/***Then***/
		assertEquals(105, totalCnt);
	}
	
	@Test
	public void ceilingTest() {
		/***Given***/
		int totalCnt = 105;
		int pagesize = 10;

		/***When***/
		double paginationSize = Math.ceil((double) totalCnt/pagesize);

		/***Then***/
		assertEquals(11, (int)paginationSize);

	}
	
	@Test
	public void userUpdateTest() {
		/***Given***/
		User userVO = new User();
		userVO.setUserId("dsssa");
		userVO.setUserName("홍길동");
		userVO.setAlias("가나다");
		userVO.setAddr1("대흥동");
		userVO.setAddr2("영민빌딩");
		userVO.setZipcode("34340");

		/***When***/
		int updateCnt = userDao.updateUser(sqlsession, userVO);

		/***Then***/
		assertEquals(updateCnt, 1);
	}
	
	
}
