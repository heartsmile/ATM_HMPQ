package vn.fpt.fsoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.entity.Card;

@Component
public class CardDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public boolean checkPIN(String cardNo, String PIN) {
		boolean check = false;
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		List<Card> list = session.createCriteria(Card.class)
				.add(Restrictions.eq("cardNo", cardNo))
				.add(Restrictions.eq("PIN", PIN)).list();

		if (list.size() > 0) {
			check = true;
		}
		
		session.close();

		return check;
	}
	
	@SuppressWarnings("unchecked")
	public boolean validateCard(String cardNo){
		boolean check = false;
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		List<Card> list = session.createCriteria(Card.class)
				.add(Restrictions.eq("cardNo", cardNo)).list();

		if (list.size() > 0) {
			check = true;
		}
		
		session.close();
		
		return check;
	}
	
	public void block(String cardNo){
		String sql = "update Card c set c.status = 'block' where c.cardNo = :cardno";
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		session.createQuery(sql).setString("cardno", cardNo).executeUpdate();
		session.getTransaction().commit();
		
	}
}
