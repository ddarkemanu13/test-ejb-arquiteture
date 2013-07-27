import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "paramWithRequestScopeController" )
public class ParamWithRequestScopeController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{param.fixParam}") 
	private String fixParam;
	
	@ManagedProperty("#{param.dynamicParam}") 
	private String dynamicParam;
	
	public String setWithRedirect() {
		return "/pages/param-with-request/page-get-param?dynamicParam="+this.dynamicParam+"?faces-redirect=true"; 
	}
	
	public String getFixParam() {
		return fixParam;
	}
	
	public void setFixParam(String fixParam) {
		this.fixParam = fixParam;
	}

	public String getDynamicParam() {
		return dynamicParam;
	}

	public void setDynamicParam(String dynamicParam) {
		this.dynamicParam = dynamicParam;
	}
}
