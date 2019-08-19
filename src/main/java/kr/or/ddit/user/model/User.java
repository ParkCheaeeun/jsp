package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	private String userNm;
	private String userId;
	private String pass;
	private String alias;
	private Date reg_dt_fmt;
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	public User() {
		
	}
	
	public String getReg_dt() {
		logger.debug("getReg_dt_fmt method call");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdf.format(reg_dt_fmt);
		return date;
	}

	public void setReg_dt(Date reg_dt) {
		
		this.reg_dt_fmt = reg_dt;
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
