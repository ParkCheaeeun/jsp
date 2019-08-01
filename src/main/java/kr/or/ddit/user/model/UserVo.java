package kr.or.ddit.user.model;

public class UserVo {
	private String userName;

	public UserVo(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + "]";
	}
	
}
