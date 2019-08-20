package kr.or.ddit.user.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.mybatis;

public class UserService implements IUserService{
	
	private IUserDao userDao;
	
	public UserService(){
		userDao = new UserDao();
	}
	
	@Override
	public List<User> getUserList() {
		SqlSession sqlSession = mybatis.getSession();
		List<User> list = userDao.getUserList(sqlSession);
		return list;
	}

	@Override
	public List<User> getUserHalfList() {
		SqlSession sqlSession = mybatis.getSession();
		List<User> list = userDao.getUserHalfList(sqlSession);
		return list;
	}

	@Override
	public User getUser(String userId) {
		SqlSession sqlSession = mybatis.getSession();
		User user = userDao.getUser(sqlSession , userId);
		return user;
	}

}
