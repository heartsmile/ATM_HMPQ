package vn.fpt.fsoft.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
}
