/**
 * 
 */
package vn.fpt.fsoft.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import vn.fpt.fsoft.model.Money;

/**
 * @author John Tran
 *
 */
public class WithdrawServicesTest {
	
	@Autowired
	private WithdrawServices withdrawServices;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#dispenseCash(int)}.
	 */
	@Test
	public void testDispenseCashTC01() {
		List<Money> listMoney = withdrawServices.dispenseCash(5000000);
		assertTrue(listMoney.size() > 0);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#dispenseCash(int)}.
	 */
	@Test
	public void testDispenseCashTC02() {
		List<Money> listMoney = withdrawServices.dispenseCash(123456789);
		assertTrue(listMoney.size() == 0);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#dispenseCash(int)}.
	 */
	@Test
	public void testDispenseCashTC03() {
		List<Money> listMoney = withdrawServices.dispenseCash(-99999);
		assertTrue(listMoney.size() == 0);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#dispenseCash(int)}.
	 */
	@Test
	public void testDispenseCashTC04() {
		List<Money> listMoney = withdrawServices.dispenseCash(11000000);
		assertTrue(listMoney.size() > 0);
	}

}
