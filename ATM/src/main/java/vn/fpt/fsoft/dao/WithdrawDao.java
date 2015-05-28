package vn.fpt.fsoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.fpt.fsoft.entity.Account;

@Component
public class WithdrawDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean changeAcountBalance(String AccNo, float remainingAmount) {

		String sql = "update account a set a.balance = :bl where a.accountNo = :accNo";
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		session.createSQLQuery(sql).addEntity(Account.class).setFloat("bl", remainingAmount)
				.setString("accNo", AccNo).executeUpdate();
		session.getTransaction().commit();
		//session.close();

		return false;
	}

}
