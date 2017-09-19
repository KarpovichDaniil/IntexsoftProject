package main.java.by.intexsoft.adsboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class Cities extends AbstractEntity{

	private static final long serialVersionUID = -7512471965538551694L;
	
	@Column(name="name")
	public String name;

}
