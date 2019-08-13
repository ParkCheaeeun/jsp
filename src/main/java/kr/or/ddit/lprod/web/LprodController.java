package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDaoImpl;

@WebServlet("/LprodList")
public class LprodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILprodDao dao = new LprodDaoImpl();
		List<LprodVo> list = dao.selectAll();
		
		request.setAttribute("lprodList", list);
		request.getRequestDispatcher("/lprod/lprodList.jsp").forward(request, response);
		
	}

	
}
