package org.business.teste.service;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.business.teste.App;
import org.business.teste.dao.IAppDAO;

@Stateless(name = "AppService")
@Remote(IAppService.class)
public class AppService implements IAppService {
	
	@EJB
	private IAppDAO appDAO;

	public void appPrint(String string) {
		this.appDAO.appPrint(string);
	}

	public List<App> findWithPagination(int initPosition, int totalRows,
			String field, String orderType,
			Map<String, String> filters) {
		return this.appDAO.findWithPagination(initPosition, totalRows, field, orderType, filters);
	}

	public int countAll(Map<String, String> filters) {
		return this.countAll(filters);
	}

}
