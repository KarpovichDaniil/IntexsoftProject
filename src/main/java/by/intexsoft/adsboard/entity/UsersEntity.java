package main.java.by.intexsoft.adsboard.entity;

import javax.persistence.Column;
import static javax.persistence.FetchType.EAGER;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "users")
public class UsersEntity extends AbstractEntity {

	private static final long serialVersionUID = -5740112979627892785L;

	@Column(name = "username")
	public String username;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "enabled")
	public Boolean enabled;

	@ManyToMany(fetch = EAGER)
    //@JsonManagedReference
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
	public List<RolesEntity> roles;
}
