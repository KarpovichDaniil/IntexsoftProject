package main.java.by.intexsoft.adsboard.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "main_country")
public class RolesEntity extends AbstractEntity{

	private static final long serialVersionUID = -2131224364992410235L;
	
	
	
	@Column(name="main_country")
	public String main_country;

	@Column(name="branch_office_in_rb")
	public String branch_office_in_rb;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "main_country", fetch = FetchType.EAGER)
	public Set<CategoriesEntity> company;
}
