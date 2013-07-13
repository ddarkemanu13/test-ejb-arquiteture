import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.business.teste.service.app.IAppService;


@ManagedBean(name = "warApp")
@RequestScoped
public class WarApp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	IAppService appService;
	
	public void init() {
		String texto = "TESTEE CHAMADA SERVICE WAR APP";
		
		this.appService.appPrint(texto);
	}


}
