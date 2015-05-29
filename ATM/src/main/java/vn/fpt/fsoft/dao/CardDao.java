package vn.fpt.fsoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.entity.Account;
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
	public boolean validateCard(String cardNo) {
		boolean check = false;
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		List<Card> list = session.createCriteria(Card.class)
				.add(Restrictions.eq("cardNo", cardNo)).add(Restrictions.eq("status", "normal")).list();

		if (list.size() > 0) {
			check = true;
		}

		session.close();

		return check;
	}

	public void block(String cardNo) {
		String sql = "update Card c set c.status = 'block' where c.cardNo = :cardno";
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		session.createQuery(sql).setString("cardno", cardNo).executeUpdate();
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public String getAccountNo(String cardNo) {
		String accountNo = "";
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		List<Account> list = session.createCriteria(Account.class)
				.createCriteria("cards").add(Restrictions.eq("cardNo", cardNo))
				.list();
		session.close();

		for (Account account : list) {
			accountNo = account.getAccountNo();
		}

		return accountNo;
	}
	
	@SuppressWarnings("unchecked")
	public int getAttempt(String cardNo ){
		int attempt = 0;
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		List<Card> list = session.createCriteria(Card.class).add(Restrictions.eq("cardNo", cardNo)).list();
		session.getTransaction().commit();
		
		for (Card card : list) {
			attempt = card.getAttempt();
		}
		
		return attempt;
	}
	
	public void setAttempt(String cardNo, int attempt ){
		String sql = "update Card c set c.attempt = :attempt where c.cardNo = :cardno";
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		session.createQuery(sql).setInteger("attempt", attempt).setString("cardno", cardNo).executeUpdate();
		session.getTransaction().commit();
	}
}
