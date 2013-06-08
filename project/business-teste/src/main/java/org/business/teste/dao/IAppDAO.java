package org.business.teste.dao;

import java.util.List;
import java.util.Map;

import org.business.teste.App;

public interface IAppDAO extends IDefaultDAO<App> {
	
	void appPrint(String string);
	
	List<App> findWithPagination(int initPosition, int totalRows,
			String field, String orderType,
			Map<String, String> filters);

	int countAll(Map<String, String> filtros);

}
