package kr.or.ddit.user.model;

public class UserVo {
	private String userName;
	private String userId;
	private String pass;
	
	public UserVo() {
		
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

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
		return "UserVo [userName=" + userName + ", userId=" + userId + ", pass=" + pass + "]";
	}

}
