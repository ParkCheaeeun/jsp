package kr.or.ddit.lprod.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.lprod.model.LprodVo;

public class LprodDaoTest {

	@Test
	public void getLprodTest() {
		/***Given***/
		ILprodDao dao = new LprodDaoImpl();
		
		/***When***/
		List<LprodVo> list = dao.selectAll();
		
		/***Then***/
		assertEquals(14, list.size());
		
	}

}
