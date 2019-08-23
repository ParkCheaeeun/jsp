package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
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
	

	/**
	* Method : insertUser
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param user
	* Method 설명 : 사용자 등록
	*/
	int insertUser(User user);
	
	/**
	* Method : deleteUser
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param userId
	* Method 설명 : 사용자 삭제
	*/
	int deleteUser(String userId);
	
	Map<String, Object> getUserPagingList(Page page);
	
}
