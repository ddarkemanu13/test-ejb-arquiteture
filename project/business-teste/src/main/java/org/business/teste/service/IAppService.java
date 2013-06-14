package org.business.teste.service;

import java.util.List;

import org.business.teste.App;

public interface IAppService {
	
	void appPrint(String string);

	List<App> findWithPagination(int initPosition, int totalRows);

	int countAll();
	
	List<App> findAll();
	
}
