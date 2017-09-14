package by.intexsoft.progcomm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class PostEntity extends AbstractEntity {

	private static final long serialVersionUID = -5740112979627892785L;

	@Column(name = "post_name")
	public String post_name;

}
