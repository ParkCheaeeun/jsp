package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.mybatis;

public class LprodDaoImpl implements ILprodDao {
	
	private static LprodDaoImpl dao;
	
	public static LprodDaoImpl getInstance() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	
	@Override
	public List<LprodVo> selectAll(SqlSession session) {
		return session.selectList("lprod.selectAll");
	}

	@Override
	public List<LprodVo> getLprodPagingList(Page page, SqlSession session) {
		return session.selectList("lprod.getLprodPagingList", page);
	}

	@Override
	public int getLprodTotalCnt(SqlSession session) {
		return session.selectOne("lprod.getLprodTotalCnt");
	}

	

}
