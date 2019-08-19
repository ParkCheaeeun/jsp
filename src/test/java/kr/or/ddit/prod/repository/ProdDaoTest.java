package kr.or.ddit.prod.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.prod.model.ProdVo;

public class ProdDaoTest {

	@Test
	public void prodDaoTest() {
		
		IProdDao dao = new ProdDaoImpl();
		List<ProdVo> list = dao.getProd("P202");
		
		assertEquals(42, list.size());
		
	}

}
