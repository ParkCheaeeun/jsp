package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeServlet
 */
@WebServlet("/scopeTest")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/scopeTestView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqParam = request.getParameter("request");
		String sessionParam = request.getParameter("session");
		String applicationParam = request.getParameter("applicationParam");
		
		request.setAttribute("reqAttr", reqParam+"_ATTR");
		
		//session
		HttpSession session = request.getSession();
		session.setAttribute("sessionAttr", sessionParam+"_ATTR");
		
		//application
		ServletContext application = request.getServletContext();
		application.setAttribute("applicationAttr", applicationParam+"_ATTR");
		
		request.getRequestDispatcher("/jsp/scopeResult.jsp").forward(request, response);
	}

}
