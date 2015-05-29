/**
 * 
 */
package vn.fpt.fsoft;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import vn.fpt.fsoft.model.Money;
import vn.fpt.fsoft.service.WithdrawServices;

/**
 * @author QuanTA5
 *
 */
public class WithdrawServicesTest {

	@Autowired
	private WithdrawServices withdrawService;
	
	private String accNo;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Money in stock > 0
		
		accNo = "563658956854752";
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
		List<Money> listMoney = withdrawService.dispenseCash(200000);
		assertTrue(listMoney.size() > 0);
		
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#dispenseCash(int)}.
	 */
	@Test
	public void testDispenseCashTC02() {
		List<Money> listMoney = withdrawService.dispenseCash(205000);
		assertTrue(listMoney.size() == 0);
		
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#dispenseCash(int)}.
	 */
	@Test
	public void testDispenseCashTC03() {
		List<Money> listMoney = withdrawService.dispenseCash(0);
		assertTrue(listMoney.size() == 0);
		
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#dispenseCash(int)}.
	 */
	@Test
	public void testDispenseCashTC04() {
		List<Money> listMoney = withdrawService.dispenseCash(-10);
		assertTrue(listMoney.size() == 0);
		
	}

	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#changeAcountBalance(java.lang.String, float)}.
	 */
	@Test
	public void testChangeAcountBalanceTC01() {

		boolean result = withdrawService.changeAcountBalance(accNo, 3000000);
		assertTrue(result);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#changeAcountBalance(java.lang.String, float)}.
	 */
	@Test
	public void testChangeAcountBalanceTC02() {

		boolean result = withdrawService.changeAcountBalance(accNo, 300000000);
		assertTrue(result);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#changeAcountBalance(java.lang.String, float)}.
	 */
	@Test
	public void testChangeAcountBalanceTC03() {

		boolean result = withdrawService.changeAcountBalance(accNo, -123456);
		assertFalse(result);
	}
	
	/**
	 * Test method for {@link vn.fpt.fsoft.service.WithdrawServices#changeAcountBalance(java.lang.String, float)}.
	 */
	@Test
	public void testChangeAcountBalanceTC04() {

		boolean result = withdrawService.changeAcountBalance(accNo, 0);
		assertTrue(result);
	}

}
