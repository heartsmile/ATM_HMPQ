/**
 * 
 */
package vn.fpt.fsoft.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import vn.fpt.fsoft.model.Money;

/**
 * @author QuanTA5
 *
 */
public class StockDaoTest {

	@Autowired
	private StockDao stockDao;
	
	private List<Money> listMoneyComsumed;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		listMoneyComsumed = stockDao.getMoneyList(1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link vn.fpt.fsoft.dao.StockDao#getMoneyList(int)}.
	 */
	@Test
	public void testGetMoneyListIntTC01() {
		
		List<Money> listMoney = stockDao.getMoneyList(1);
		assertTrue(listMoney.size() > 0);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.dao.StockDao#getMoneyList(int)}.
	 */
	@Test
	public void testGetMoneyListIntTC02() {
		
		List<Money> listMoney = stockDao.getMoneyList(2);
		assertTrue(listMoney.size() == 0);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.dao.StockDao#getMoneyList(int)}.
	 */
	@Test
	public void testGetMoneyListIntTC03() {
		
		List<Money> listMoney = stockDao.getMoneyList(-1);
		assertTrue(listMoney.size() == 0);
	}

	/**
	 * Test method for {@link vn.fpt.fsoft.dao.StockDao#getMoneyList()}.
	 */
	@Test
	public void testGetMoneyListTC01() {
		List<vn.fpt.fsoft.entity.Money> listMoney = stockDao.getMoneyList();
		assertTrue(listMoney.size() > 0);
	}

	/**
	 * Test method for {@link vn.fpt.fsoft.dao.StockDao#upDateCash(java.util.List, int)}.
	 */
	@Test
	public void testUpDateCash() {
		boolean result = stockDao.upDateCash(listMoneyComsumed, 1);
	}

}
