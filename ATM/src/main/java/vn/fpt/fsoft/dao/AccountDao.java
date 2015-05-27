package vn.fpt.fsoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.entity.Account;
import vn.fpt.fsoft.model.Card;

@Component
public class AccountDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private vn.fpt.fsoft.model.Account account;

	@SuppressWarnings("unchecked")
	public vn.fpt.fsoft.model.Account getAccount(Card card) {
		String accountNo = card.getAccountNo();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Account> list = sessionFactory.getCurrentSession().createCriteria(Account.class).add(Restrictions.eq("accountNo",accountNo )).list();
		session.close();
		
		for (Account ac : list) {
			account.setAccountID(ac.getAccountID());
			account.setBalance(ac.getBalance());
		}
		
		return account;
	}
}
