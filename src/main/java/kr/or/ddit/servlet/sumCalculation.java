package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start = request.getParameter("num1");
		String end = request.getParameter("num2");
		
		int sum = sum(Integer.parseInt(start), Integer.parseInt(end));
		logger.debug("sum :" + sum);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult",sum);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
		
	}
	
	private int sum(int num1, int num2) {
		int res = 0;
		
		for(int i=num1; i<=num2; i++){
			res +=i;
		}
		return res;
	}

}

