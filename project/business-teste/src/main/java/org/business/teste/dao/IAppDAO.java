package org.business.teste.dao;

import java.util.List;

import org.business.teste.App;

public interface IAppDAO extends IDefaultDAO<App> {
	
	void appPrint(String string);
	
	List<App> findWithPagination(int initPosition, int totalRows);

	int countAll();

}
