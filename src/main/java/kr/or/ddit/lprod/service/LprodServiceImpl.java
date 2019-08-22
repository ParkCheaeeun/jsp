package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.repository.LprodDaoImpl;
import kr.or.ddit.util.mybatis;

public class LprodServiceImpl implements ILprodService {
	
	private static LprodServiceImpl service;
	private LprodDaoImpl dao;
	public SqlSession session;
	
	public LprodServiceImpl(){
		dao = LprodDaoImpl.getInstance();
		session = mybatis.getSession();
	}
	
	public static LprodServiceImpl getInstance(){
		if(service == null) service = new LprodServiceImpl();
		return service;
	}
	
	@Override
	public List<LprodVo> selectAll() {
		List<LprodVo> list = dao.selectAll(session);
		return list;
	}

	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		List<LprodVo> list = dao.getLprodPagingList(page, session);
		int cnt = dao.getLprodTotalCnt(session);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lprodList", list);
		map.put("totalCnt", (int) Math.ceil((double)cnt/page.getPagesize()));
		
		
		return map;
	}

}
