/**
 * 
 */
package vn.fpt.fsoft.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author QuanTA5
 *
 */
public class WithdrawDaoTest {

	@Autowired
	private WithdrawDao withdrawDao;
	
	private String accNo;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		accNo = "563658956854752";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link vn.fpt.fsoft.dao.WithdrawDao#changeAcountBalance(java.lang.String, float)}.
	 */
	@Test
	public void testChangeAcountBalanceTC01() {
		boolean result = withdrawDao.changeAcountBalance(accNo, 20000000);
		assertTrue(result);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.dao.WithdrawDao#changeAcountBalance(java.lang.String, float)}.
	 */
	@Test
	public void testChangeAcountBalanceTC02() {
		boolean result = withdrawDao.changeAcountBalance(accNo, 0);
		assertTrue(result);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.dao.WithdrawDao#changeAcountBalance(java.lang.String, float)}.
	 */
	@Test
	public void testChangeAcountBalanceTC03() {
		boolean result = withdrawDao.changeAcountBalance(accNo, -123);
		assertFalse(result);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.dao.WithdrawDao#changeAcountBalance(java.lang.String, float)}.
	 */
	@Test
	public void testChangeAcountBalanceTC04() {
		boolean result = withdrawDao.changeAcountBalance("2342342341", 999999999);
		assertFalse(result);
	}

}
