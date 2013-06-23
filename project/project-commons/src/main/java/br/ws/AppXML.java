package br.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AppXML {
	
	private String description;
	
	public AppXML() {
	}
	
	public AppXML(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
