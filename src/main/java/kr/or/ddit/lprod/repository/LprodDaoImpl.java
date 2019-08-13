package kr.or.ddit.lprod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.mybatis;

public class LprodDaoImpl implements ILprodDao {
	
	@Override
	public List<LprodVo> selectAll() {
		SqlSession session = mybatis.getSession();
		List<LprodVo> list = session.selectList("lprod.selectAll");
		return list;
	}

}
