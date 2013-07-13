package org.business.teste.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.business.teste.App;
import org.business.utils.dao.DefaultDAO;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

@Stateless(name = "AppDAO")
@Local(IAppDAO.class)
public class AppDAO extends DefaultDAO<App> implements IAppDAO {

	@Override
	public void appPrint(String string) {
		System.out.println(">>>>>>>> Print Method");
		System.out.println("Text : " + string);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<App> findWithPagination(int initPosition, int totalRows) {
		return (List<App>) createSession().createCriteria(App.class)	
			.setFirstResult(initPosition)
			.setMaxResults(totalRows)
			.addOrder(Order.asc("id")).list();
	}

	@Override
	public int countAll() {
		return ((Number) createSession().createCriteria(App.class)
				.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}

}
