package vn.fpt.fsoft.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer.AmbiguousBindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.entity.Account;
import vn.fpt.fsoft.entity.Card;
import vn.fpt.fsoft.entity.Stock;
import vn.fpt.fsoft.entity.Money;

@Component
public class StockDao {

	@Autowired
	private SessionFactory sessionFactory;

	//@PersistenceContext
	//private EntityManager em;

	public List<vn.fpt.fsoft.model.Money> getMoneyList(int atmID) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

//		@SuppressWarnings("unchecked")
//		List<Money> list = session.createCriteria(Money.class)
//				.createCriteria("stocks").add(Restrictions.eq("atmid", atmID))
//				.list();

		/*SQLQuery query = session
				.createSQLQuery(
						"SELECT quantity, moneyValue FROM stock JOIN money USING (moneyID) WHERE atmid = 1")
				.addEntity(vn.fpt.fsoft.model.Money.class);*/

		//List<vn.fpt.fsoft.model.Money> listMoney = query.list();

		// //////////////////////////
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
			 //System.out.println(money.getMoneyValue());
			 //System.out.println(stock.getQuantity());
			 moneyModel = new vn.fpt.fsoft.model.Money();
			 moneyModel.setQuantity(stock.getQuantity());
			 moneyModel.setValue(money.getMoneyValue().intValue());
			 listRS.add(moneyModel);
			 
		}
		// //////////////////////////

		session.close();

		return listRS;
	}
}
