package pt.americolib.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {
	
	//ATTRIBUTE
	@Autowired
	private SessionFactory sessionFactory;
	
	/* RETRIEVE: fetch data from table */
	/** RETRIEVE: get a total count of ID values*/
	public int getCircleCount() {
		//QUERY
		String hql = "SELECT COUNT(*) FROM CIRCLE";
		//OPEN 
		Query query = getSessionFactory().openSession().createQuery(hql);
		//OPEN
		return ((Long) query.uniqueResult()).intValue();
	}

	//GETTERS AND SETTERS
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
