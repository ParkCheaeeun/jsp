package kr.or.ddit.user.repository;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.user.model.UserVo;

public class UserDao implements IUserDao{

	@Override
	public List<UserVo> getUserList() {
		//db에서 조회가 되었다고 가정하고 가짜 객체를 리턴
		List<UserVo> userList = new ArrayList<UserVo>();
		userList.add(new UserVo("brown"));
		userList.add(new UserVo("Sally"));
		userList.add(new UserVo("cony"));
		userList.add(new UserVo("moon"));
		userList.add(new UserVo("james"));
		
		return userList;
	}
	
	
}
