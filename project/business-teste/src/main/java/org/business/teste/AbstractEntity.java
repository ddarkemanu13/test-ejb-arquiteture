package org.business.teste;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Version
	protected Integer version;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creatioDate = new Date();
	
	public Long getId() {
		return id;
	}
	
	public Date getCreatioDate() {
		return creatioDate;
	}
}
