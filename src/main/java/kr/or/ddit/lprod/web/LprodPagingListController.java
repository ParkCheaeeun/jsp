package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.service.LprodServiceImpl;


@WebServlet("/LprodPagingList")
public class LprodPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LprodPagingListController.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pagesize");
		logger.debug("pageno: {}" + pageStr + "  pagesize: {}" + pageSizeStr);
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 5 : Integer.parseInt(pageSizeStr);
		
		Page p = new Page(page, pageSize);
		request.setAttribute("pageVo", p);
		
		LprodServiceImpl service = LprodServiceImpl.getInstance();
		
		Map<String, Object> map = service.getLprodPagingList(p);
		
		request.setAttribute("totalCnt", map.get("totalCnt"));
		request.setAttribute("lprodList",  map.get("lprodList"));
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
	}


}
