package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	private String userId;		//사용자 아이디
	private String pass;		//사용자 비밀번호
	private String userNm;		//사용자 이름
	private String alias;		//별명
	private Date reg_dt;		//등록일
	private String addr1;		//주소1
	private String addr2;		//주소2
	private String zipcode;		//우편번호
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	public User() {
		
	}
	
	public User(String userId, String userNm, String alias, Date reg_dt, String addr1, String addr2,
			String zipcode, String pass) {
		this.userId = userId;
		this.userNm = userNm;
		this.alias = alias;
		this.reg_dt = reg_dt;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.pass = pass;
	}
	
	public String getReg_dt() {
		logger.debug("getReg_dt_fmt method call");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(reg_dt);
		return date;
	}

	public void setReg_dt(Date reg_dt) {
		
		this.reg_dt = reg_dt;
	}


	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public User(String userNm) {
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
	
	public boolean checkLoginValidate(String userId, String pass) {
		if(userId.equals(this.userId) && pass.equals(this.pass)) {
			return true;
		}else {
			return false;
		}
	}
}
