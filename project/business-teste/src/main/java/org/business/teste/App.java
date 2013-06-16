package org.business.teste;

import javax.persistence.Entity;

@Entity(name = "APP")
public class App extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	private String description;
	
	public App() {
	}
	
	public App(Long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.id +" - "+ this.description;
	}
}
