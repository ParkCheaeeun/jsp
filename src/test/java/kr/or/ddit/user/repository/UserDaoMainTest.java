package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.mybatis;

public class UserDaoMainTest {

	public static void main(String[] args) {
		//userDao.getUserList();
		IUserDao userDao = new UserDao();
		SqlSession sqlsession = mybatis.getSession();
		
		List<User> userList = userDao.getUserList(sqlsession);
		sqlsession.close();
		
		if(userList.size() == 5) {
			System.out.println("db 조회 성공");
		}else {
			System.out.println("db 조회 실패");
		}
	}

}
