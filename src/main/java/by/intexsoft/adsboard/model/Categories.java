package by.intexsoft.adsboard.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categories extends AbstractEntity {

	private static final long serialVersionUID = -2647633542363434741L;

	@Column(name = "name")
	public String name;
}
