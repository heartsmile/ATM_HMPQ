/**
 * 
 */
package vn.fpt.fsoft.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.dao.StockDao;
import vn.fpt.fsoft.dao.WithdrawDao;
import vn.fpt.fsoft.model.Money;

/**
 * @author QuanTA5
 *
 */
@Component
public class WithdrawServices {

	@Autowired
	private StockDao stDao;
	
	@Autowired
	private WithdrawDao withdrawDao;
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Money> dispenseCash(int amount) {

		List<Money> output = new ArrayList<Money>();
		List<Money> stockList = stDao.getMoneyList(1);

		Collections.sort(stockList,
				Collections.reverseOrder(new MoneyComaprator()));
		int res = amount;
		Money moneyModel;
		for (Money m : stockList) {
			if (res != 0) {
				int tmpRest = (res % m.getValue());

				// sheet : number of money sheet
				int sheets = (res - tmpRest) / m.getValue();
				if (m.getQuantity() >= sheets) {
					res = tmpRest;
					moneyModel = new Money();
					moneyModel.setQuantity(sheets);
					moneyModel.setValue(m.getValue());
					output.add(moneyModel);
				} else {
					if (m.getQuantity() > 0) {
						sheets = m.getQuantity();
						res = res - m.getValue() * sheets;
						moneyModel = new Money();
						moneyModel.setQuantity(sheets);
						moneyModel.setValue(m.getValue());
						output.add(moneyModel);
					}
				}
			} else {
				break;
			}
		}
		
		//count to check if ATM has enough money
		int tempAmount = 0;
		for(Money m : output){
			tempAmount += m.getValue() * m.getQuantity();
		}
		
		if(tempAmount == amount){ //If ATM has enough money

			//change remaining money(cash) in ATM
			
			return output;
		}

		return new ArrayList<Money>();

	}
	
	public boolean changeAcountBalance(String AccNo, float remainingAmount){
		
		return withdrawDao.changeAcountBalance(AccNo, remainingAmount);
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