package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.mybatis;

public class UserDao implements IUserDao{
	
	
	
	@Override
	public List<User> getUserList(SqlSession sqlSession) {
		//db에서 조회가 되었다고 가정하고 가짜 객체를 리턴
//		List<UserVo> userList = new ArrayList<UserVo>();
//		userList.add(new UserVo("brown"));
//		userList.add(new UserVo("Sally"));
//		userList.add(new UserVo("cony"));
//		userList.add(new UserVo("moon"));
//		userList.add(new UserVo("james"));
		
		return sqlSession.selectList("user.getUserList");

		
	}

	/**
	* Method : getUser
	* 작성자 : PC-09
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : userId를 갖는 사용자 조회
	*/
	@Override
	public User getUser(SqlSession sqlSession, String userId) {
		User userVo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		
		return userVo;
	}

	@Override
	public List<User> getUserHalfList(SqlSession sqlSession) {
		List<User> list = sqlSession.selectList("user.getUserListOnlyHalf");
		return list;
	}

	@Override
	public List<User> getUserPagingList(SqlSession sqlSession, Page page) {
		List<User> list = sqlSession.selectList("user.getUserPagingList", page);
		return list;
	}
	

	/**
	* Method : getUserTotalCount
	* 작성자 : PC-09
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 전체 사용자 건수 조회
	*/
	public int getUserTotalCount(SqlSession sqlSession) {
		return sqlSession.selectOne("user.getUserTotalCnt");
	}
	
	/**
	* Method : insertUser
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param sqlSession
	* @param user
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(SqlSession sqlSession, User user) {
		return sqlSession.insert("user.insertUser", user);
	}

	/**
	* Method : deleteUser
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param sqlSession
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	*/
	@Override
	public int deleteUser(SqlSession sqlSession, String userId) {
		return sqlSession.delete("user.deleteUser", userId);
	}

	@Override
	public int updateUser(SqlSession sqlSession, User user) {
		return sqlSession.update("user.updateUser", user);
	}
	
}
