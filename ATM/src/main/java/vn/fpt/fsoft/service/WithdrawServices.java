/**
 * 
 */
package vn.fpt.fsoft.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.dao.StockDao;
import vn.fpt.fsoft.model.Money;

/**
 * @author QuanTA5
 *
 */
@Component
public class WithdrawServices {

	@Autowired
	private StockDao stDao;

	public List<Money> dispenseCash(int amount) {
		List<Money> output = new ArrayList<Money>();

		//List<Money> listMoneyData = 

		List<Money> stockList = stDao.getMoneyList(1);

//		vn.fpt.fsoft.model.Money moneyModel;
//		for (vn.fpt.fsoft.model.Money money : listMoneyData) {
//			//moneyModel = new vn.fpt.fsoft.model.Money(money.g, value)
//		}

		Collections.sort(stockList, Collections.reverseOrder(new MoneyComaprator()));
		int res = amount;
		Money moneyModel;
		for (Money m : stockList) {
			if (res != 0) {
				int tmpRest = (res % m.getValue());
				//sheet : so to
				int sheets = (res - tmpRest) / m.getValue();
				if (m.getQuantity() >= sheets) {
					res = tmpRest;
					moneyModel = new Money();
					moneyModel.setQuantity(sheets);
					moneyModel.setValue(m.getValue());
					output.add(moneyModel);
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