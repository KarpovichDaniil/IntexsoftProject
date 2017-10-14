package by.intexsoft.adsboard.model;

import javax.persistence.Column;
import static javax.persistence.FetchType.EAGER;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AbstractEntity {

	private static final long serialVersionUID = -5740112979627892785L;
	
	/**
     * Default constructor
     */
    public User() {
    }
    
    /**
     * Constructor for the purposes of authentication
     *
     * @param user to get details of
     */
    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
        this.roles = user.roles;
    }

	@Column(name = "username")
	public String username;
	
	@Column(name = "password")
	@JsonIgnore
	public String password;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "enabled")
	public Boolean enabled;

	@ManyToMany(fetch = EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
	public List<Role> roles;
	
	@JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
