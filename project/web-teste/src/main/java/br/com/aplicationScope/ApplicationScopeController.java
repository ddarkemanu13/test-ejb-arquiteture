package br.com.aplicationScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.business.teste.app.App;

@ApplicationScoped
@ManagedBean(name = "applicationScopeController")
public class ApplicationScopeController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<App> apps;
	
	public ApplicationScopeController() {
		this.apps = new ArrayList<App>();
		for(int i=0;i <= 5; i++)
			this.apps.add(new App(Long.valueOf(i), "Description " + i ));
	}
	
	public List<App> getApps() {
		return apps;
	}
	
}
