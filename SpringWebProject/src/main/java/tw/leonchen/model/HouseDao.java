package tw.leonchen.model;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public House findById(int houseid) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		House resultBean = session.get(House.class, houseid);		
		return resultBean;
	}
	
	public List<House> findAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from House";
		Query<House> query = session.createQuery(hql, House.class);
		return query.list();		
	}

}
