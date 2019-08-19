package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.repository.IProdDao;
import kr.or.ddit.prod.repository.ProdDaoImpl;

@WebServlet("/prod")
public class prodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(prodController.class);
    private IProdDao dao;
    
    @Override
    public void init() throws ServletException {
    	dao = new ProdDaoImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prod_gu = request.getParameter("prod_gu");
		
		logger.debug("prod_lgu : {} " + prod_gu);
		
		List<ProdVo> list = dao.getProd(prod_gu);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/prod/prod.jsp").forward(request, response);
		
	}

}
