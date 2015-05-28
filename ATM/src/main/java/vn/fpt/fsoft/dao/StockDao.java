package vn.fpt.fsoft.dao;

import java.sql.Connection;
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
		List<Object[]> results = session
				.createSQLQuery(
						"SELECT {s.*}, {m.*} FROM stock s JOIN money m ON s.moneyID = m.moneyID"
								+ " WHERE s.atmid = " + atmID)
				.addEntity("s", Stock.class).addEntity("m", Money.class).list();
		for (Object[] record : results) {
			Stock stock = (Stock) record[0];
			Money money = (Money) record[1];
			// System.out.println(money.getMoneyValue());
			// System.out.println(stock.getQuantity());
			moneyModel = new vn.fpt.fsoft.model.Money();
			moneyModel.setQuantity(stock.getQuantity());
			moneyModel.setValue(money.getMoneyValue().intValue());
			listRS.add(moneyModel);

		}
		
		session.close();

		return listRS;
	}

	public List<Money> getMoneyList() {
		List<Money> output = new ArrayList<Money>();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Object[]> results = session
				.createSQLQuery("SELECT {m.*} FROM money M")
				.addEntity("m", Money.class).list();
		for (Object[] record : results) {
			Money money = (Money) record[0];
			output.add(money);
		}
		return output;
	}

	public void upDateCash(List<vn.fpt.fsoft.model.Money> comsumed, int atmID){
		/*Session session = sessionFactory.getCurrentSession();
		String sql = "update Stock s set s.quantity = s.quantity- :qual where s.moneyID = :moneyID and s.atmid ="+ atmID;
		List<Money> moneyList = getMoneyList();
		for(vn.fpt.fsoft.model.Money m  : comsumed){
			int moneyID=0;
			for(Money money : moneyList){
				if(money.getMoneyValue()==m.getValue()){
					moneyID = money.getMoneyID();
				}
			}
			session.beginTransaction();
			session.createQuery(sql).setInteger("qual",m.getQuantity()).setInteger("moneyID", moneyID).executeUpdate();
			session.getTransaction().commit();
		}*/
		
		
	}
}
