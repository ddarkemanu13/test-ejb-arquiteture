import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;


@ManagedBean(name = "dialogValidationController")
@ViewScoped
public class DialogValidationController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String text;
	
	public void dialogValidation(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        String text = (String) event.getComponent().getAttributes().get("text");
    	if (text != null && !text.isEmpty()) {
    		context.addCallbackParam("confirm", true);
    		cleanInput(); 
    	} else {
    		context.addCallbackParam("confirm", false);  
    		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Text is empty!"));
    	}
    }
	
	public void cleanInput() {
		this.text = ""; 
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
