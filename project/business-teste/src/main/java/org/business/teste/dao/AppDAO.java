package org.business.teste.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.business.teste.App;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.AliasToBeanResultTransformer;

@Stateless(name = "AppDAO")
@Local(IAppDAO.class)
public class AppDAO extends DefaultDAO<App> implements IAppDAO {

	public void appPrint(String string) {
		System.out.println(">>>>>>>> Entro Metodo");
		System.out.println("Text : " + string);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<App> findWithPagination(int initPosition, int totalRows,
			String field, String orderType,
			Map<String, String> filters) {
		
		StringBuilder sql = new StringBuilder("SELECT * from ejbarquitetue.app");
		sql.append(" LIMIT :initPosition , :");
		
		SQLQuery query = createSession().createSQLQuery(sql.toString());
		for(String key : filters.keySet()) {
            query.setParameter(key, filters.get(key));
		}      
		return query.setResultTransformer(new AliasToBeanResultTransformer(App.class)).list();
	}

	@Override
	public int countAll(Map<String, String> filters) {
		StringBuilder sql = new StringBuilder("SELECT count(*) from ejbarquitetue.app");
		Query query = createSession().createSQLQuery(sql.toString());
		for(String key : filters.keySet()) {
            query.setParameter(key, filters.get(key));
		}      
		return (Integer) query.uniqueResult();
	}

}
