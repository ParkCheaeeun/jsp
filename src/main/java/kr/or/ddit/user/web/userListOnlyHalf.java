package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.mybatis;

/**
 * Servlet implementation class userListOnlyHalf
 */
@WebServlet("/userListOnlyHalf")
public class userListOnlyHalf extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		List<User> list = userService.getUserHalfList();
		
		request.setAttribute("userList", list);
		request.getRequestDispatcher("/user/userListOnlyHalf.jsp").forward(request, response);
	}

	

}
