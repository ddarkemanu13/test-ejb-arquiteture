package org.business.teste.service.app;

import java.util.List;

import org.business.teste.app.App;

public interface IAppService {
	
	 public static final String SERVICE_JNDI = "java:global/portal-app/business-teste/AppService";
	
	void appPrint(String string);

	List<App> findWithPagination(int initPosition, int totalRows);

	int countAll();
	
	List<App> findAll();
	
	void save(App app);
	
}
