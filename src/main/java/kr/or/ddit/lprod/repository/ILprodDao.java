package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVo;

public interface ILprodDao {
	public List<LprodVo> selectAll(SqlSession session);
	
	public List<LprodVo> getLprodPagingList(Page page, SqlSession session);
	
	public int getLprodTotalCnt(SqlSession session);
}
