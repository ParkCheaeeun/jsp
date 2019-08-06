package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;

/**
 * Servlet implementation class userListController
 */
@WebServlet("/userList")
public class userListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  - doGet
		 *  userDao 사용자 리스트 조회
		 *  request 객체에 사용자 리스트 정보 저장
		 *  userList.jsp 통해서 화면 응답 생성하도록 위임
		 */
		
		UserDao userDao = new UserDao();
		List<UserVo> userList = userDao.getUserList();
		
		request.setAttribute("userList", userList);
		
		request.getRequestDispatcher("/user/userList.jsp").forward(request, response);
	}


}
