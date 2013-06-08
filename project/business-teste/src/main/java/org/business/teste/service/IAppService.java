package org.business.teste.service;

import java.util.List;
import java.util.Map;

import org.business.teste.App;

public interface IAppService {
	
	void appPrint(String string);

	List<App> findWithPagination(int initPosition, int totalRows,
			String field, String orderType,
			Map<String, String> filters);

	int countAll(Map<String, String> filters);
	
}
