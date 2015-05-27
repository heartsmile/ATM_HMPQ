/**
 * 
 */
package vn.fpt.fsoft.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.fpt.fsoft.dao.StockDao;
import vn.fpt.fsoft.model.Money;

/**
 * @author QuanTA5
 *
 */
public class WithdrawServices {
	public List<Money> dispenseCash(int amount) {
		List<Money> output = new ArrayList<Money>();
		List<Money> stockList = StockDao.getMoneyList(123);
		Collections.sort(stockList, new MoneyComaprator());
		int res = amount;
		for (Money m : stockList) {
			if (res != 0) {
				int tmpRest = (res % m.getValue());
				int sheets = (res - tmpRest) / m.getValue();
				if (m.getQuantity() >= sheets) {
					res = tmpRest;
					output.add(new Money(sheets, m.getValue()));
				}
			} else {
				break;
			}
		}

		return output;

	}

}

class MoneyComaprator implements Comparator<Money> {

	@Override
	public int compare(Money m1, Money m2) {
		if (m1.getValue() > m2.getValue()) {
			return 1;
		} else {
			if (m1.getValue() < m2.getValue()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}