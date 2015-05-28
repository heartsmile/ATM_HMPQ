package vn.fpt.fsoft.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.entity.Stock;
import vn.fpt.fsoft.entity.Money;

@Component
public class StockDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<vn.fpt.fsoft.model.Money> getMoneyList(int atmID) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		List<vn.fpt.fsoft.model.Money> listRS = new ArrayList<vn.fpt.fsoft.model.Money>();
		vn.fpt.fsoft.model.Money moneyModel;
		@SuppressWarnings("unchecked")
		List<Object[]> results = session.createSQLQuery(
						"SELECT {s.*}, {m.*} FROM stock s JOIN money m ON s.moneyID = m.moneyID"
						+ " WHERE s.atmid = " + atmID)
				.addEntity("s", Stock.class).addEntity("m", Money.class).list();
		for (Object[] record : results) {
			Stock stock = (Stock) record[0];
			 Money money = (Money) record[1];
			 moneyModel = new vn.fpt.fsoft.model.Money();
			 moneyModel.setQuantity(stock.getQuantity());
			 moneyModel.setValue(money.getMoneyValue().intValue());
			 listRS.add(moneyModel);
			 
		}
		
		session.close();

		return listRS;
	}
}
