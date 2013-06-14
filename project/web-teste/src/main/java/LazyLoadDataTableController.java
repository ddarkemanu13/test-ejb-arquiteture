import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.business.teste.App;
import org.business.teste.service.IAppService;
import org.primefaces.model.LazyDataModel;

import dataModel.AppLazyList;

@ManagedBean(name = "lazyLoadDataTableController")
@SessionScoped
public class LazyLoadDataTableController implements Serializable {

	private static final long serialVersionUID = 1L;

	private LazyDataModel<App> apps;
	private int numberOfRegisters = 0;
	
	@EJB
	private IAppService appService;
	
	@PostConstruct
	public void init() {
		List<App> list = this.appService.findAll();
		if(list != null) numberOfRegisters = list.size();
	}

	public LazyDataModel<App> getApps() {
		if (this.apps == null) {
			this.apps = new AppLazyList(this.appService);
		}
		return this.apps;
	}

	public void setApps(LazyDataModel<App> apps) {
		this.apps = apps;
	}


	public int getNumberOfRegisters() {
		return numberOfRegisters;
	}
}
