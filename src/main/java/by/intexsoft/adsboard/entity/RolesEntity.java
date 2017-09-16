package main.java.by.intexsoft.adsboard.entity;

import java.util.List;
import static javax.persistence.FetchType.EAGER;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RolesEntity extends AbstractEntity{

	private static final long serialVersionUID = -2131224364992410235L;
	
	@Column(name = "name")
	public String name;

	@Column(name = "description")
	public String description;
	
	@ManyToMany(fetch = EAGER, mappedBy = "roles")
    public List<UsersEntity> users;
}
