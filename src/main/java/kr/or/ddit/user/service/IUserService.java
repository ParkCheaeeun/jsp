package kr.or.ddit.user.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;

public interface IUserService {
	/**
	* Method : getUserList
	* 작성자 : PC-09
	* 변경이력 :
	 * @param sqlsession 
	* @return
	* Method 설명 : 전체 사용자 리스트 조회
	*/
	List<User> getUserList();
	
	/**
	* Method : getUserHalfList
	* 작성자 : PC-09
	* 변경이력 :
	 * @param sqlsession 
	* @return
	* Method 설명 : 
	*/
	List<User> getUserHalfList();
	
	/**
	* Method : getUser
	* 작성자 : PC-09
	* 변경이력 :
	 * @param sqlsession 
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회
	*/
	User getUser(String userId);
}
