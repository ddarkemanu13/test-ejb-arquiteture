import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.business.teste.App;
import org.primefaces.model.LazyDataModel;

import dataModel.AppLazyList;

@ManagedBean(name = "lazyLoadDataTableController")
@SessionScoped
public class LazyLoadDataTableController implements Serializable {

	private static final long serialVersionUID = 1L;

	private LazyDataModel<App> apps;

	public LazyDataModel<App> getApps() {
		if (this.apps == null) {
			this.apps = new AppLazyList();
		}
		return this.apps;
	}

	public void setApps(LazyDataModel<App> apps) {
		this.apps = apps;
	}
}
