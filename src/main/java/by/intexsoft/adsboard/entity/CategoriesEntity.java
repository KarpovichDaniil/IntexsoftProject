package main.java.by.intexsoft.adsboard.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CategoriesEntity extends AbstractEntity{
	
	private static final long serialVersionUID = -2647633542363434741L;
	
	@Column(name="company_name")
	public String company_name;
	
	@ManyToOne
	@JoinColumn(name="main_country_id")
	public RolesEntity main_country_id;
}
