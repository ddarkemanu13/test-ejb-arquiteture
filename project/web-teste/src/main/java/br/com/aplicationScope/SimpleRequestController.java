package br.com.aplicationScope;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.business.teste.app.App;


/*
 *  Controller as Application scope is instantiated when called, not at application start.
 *  The injected bean is only available in @PostConstruct and beyond.
 *  @ManagedProperty requires a public set(only) method to work.
 */
@RequestScoped
@ManagedBean(name = "simpleRequestController" )
public class SimpleRequestController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int sizeAplicationList;
	
	@ManagedProperty(value = "#{applicationScopeController}")
	private ApplicationScopeController aplicationScopeController;
	 
	@PostConstruct
	public void init() {
		updateSize();
	}
	
	public String addApp() {
		this.aplicationScopeController.getApps().add(new App(Long.valueOf(this.sizeAplicationList), "Description " + this.sizeAplicationList));
		updateSize();
		return "/pages/applicationScopeInject?faces-redirect=true";
	}
	
	private void updateSize() {
		this.sizeAplicationList = this.aplicationScopeController.getApps().size();
	}
 	
	public int getSizeAplicationList() {
		return sizeAplicationList;
	}
	
	public void setAplicationScopeController(ApplicationScopeController aplicationScopeController) {
		this.aplicationScopeController = aplicationScopeController;
	}
}
