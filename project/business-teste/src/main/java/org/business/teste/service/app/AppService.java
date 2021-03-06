package org.business.teste.service.app;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.business.teste.app.App;
import org.business.teste.dao.app.IAppDAO;

@Stateless(name = "AppService")
@Remote(IAppService.class)
public class AppService implements IAppService {
	
	@EJB
	private IAppDAO appDAO;

	public void appPrint(String string) {
		this.appDAO.appPrint(string);
	}

	public List<App> findWithPagination(int initPosition, int totalRows) {
		return this.appDAO.findWithPagination(initPosition, totalRows);
	}

	public int countAll() {
		return this.appDAO.countAll();
	}

	@Override
	public List<App> findAll() {
		return this.appDAO.findAll();
	}

	@Override
	public void save(App app) {
		this.appDAO.create(app);
	}

}
