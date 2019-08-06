package kr.or.ddit.user.model;

public class UserVo {
	private String userNm;
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

	public UserVo(String userNm) {
		this.userNm = userNm;
	}

	public String getUserName() {
		return userNm;
	}

	public void setUserName(String userNm) {
		this.userNm = userNm;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userNm + ", userId=" + userId + ", pass=" + pass + "]";
	}

}
