package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.mybatis;

public class UserDao implements IUserDao{
	
	
	
	@Override
	public List<UserVo> getUserList() {
		//db에서 조회가 되었다고 가정하고 가짜 객체를 리턴
//		List<UserVo> userList = new ArrayList<UserVo>();
//		userList.add(new UserVo("brown"));
//		userList.add(new UserVo("Sally"));
//		userList.add(new UserVo("cony"));
//		userList.add(new UserVo("moon"));
//		userList.add(new UserVo("james"));
		
		SqlSession sqlSession = mybatis.getSession();
		List<UserVo> userList = sqlSession.selectList("user.getUserList");
		sqlSession.close();
		
		return userList;
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
	public UserVo getUser(String userId) {
		SqlSession sqlSession = mybatis.getSession();
		UserVo userVo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		
		return userVo;
	}
	
	
}
