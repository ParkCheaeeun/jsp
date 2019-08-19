package kr.or.ddit.prod.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.mybatis;

public class ProdDaoImpl implements IProdDao {

	@Override
	public List<ProdVo> getProd(String prod_lgu) {
		SqlSession session = mybatis.getSession();
		List<ProdVo> list = session.selectList("prod.getProd", prod_lgu);
		return list;
	}

}
