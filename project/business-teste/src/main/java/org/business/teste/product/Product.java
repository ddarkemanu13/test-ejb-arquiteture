package org.business.teste.product;

import java.io.Serializable;
import java.text.Normalizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String category;
	
	@Column(length = 150, nullable = false)
	private String description;
	
	public String getCategoryNormalize() {
		return Normalizer.normalize(this.category.toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	public String getDescriptionNormalize() {
		return Normalizer.normalize(this.description.replace(" ", "-").toLowerCase().replace("/", "-"), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
