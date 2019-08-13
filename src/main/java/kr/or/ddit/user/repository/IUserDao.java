package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.User;

public interface IUserDao {
	
	List<User> getUserList();
	
	List<User> getUserHalfList();
	
	User getUser(String userId);
	
	
}
