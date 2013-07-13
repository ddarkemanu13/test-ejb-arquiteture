package org.business.teste.dao.app;

import java.util.List;

import org.business.teste.app.App;
import org.business.teste.utils.dao.IDefaultDAO;

public interface IAppDAO extends IDefaultDAO<App> {
	
	void appPrint(String string);
	
	List<App> findWithPagination(int initPosition, int totalRows);

	int countAll();

}
