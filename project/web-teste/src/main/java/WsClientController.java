import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.MediaType;

import br.ws.AppXML;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@ManagedBean(name = "wsClientController")
@RequestScoped
public class WsClientController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public void callWs() {
		try {
			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);
			WebResource webResource = client.resource("http://localhost:8080/project-ws/rest/app/post");
			webResource.type(MediaType.APPLICATION_JSON).post(AppXML.class, new AppXML(this.description));
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Called WS sucess!"));
		} catch(Exception ex) {
			ex.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Called WS falied!"));
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
