package by.intexsoft.adsboard.model;

import java.util.List;
import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Roles extends AbstractEntity implements GrantedAuthority {

	private static final long serialVersionUID = -2131224364992410235L;
	
	@Column(name = "name")
	public String role;
	
    @Override
    public String getAuthority() {
        return this.role;
    }

	@Column(name = "description")
	public String description;
	
	@ManyToMany(fetch = LAZY, mappedBy = "roles")
	@JsonIgnore
    public List<Users> users;
}
