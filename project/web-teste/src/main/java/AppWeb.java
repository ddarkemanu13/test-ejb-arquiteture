import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.business.teste.App;
import org.business.teste.service.IAppService;

@ManagedBean(name ="app")
@RequestScoped
public class AppWeb implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private App app;
	
	@EJB
	IAppService appService;
	
	public void init() {
		this.app = new App();
		this.app.setDescription("TESTT SERVICE ");
		
		this.appService.appPrint(this.app.getDescription());
	}

}
