package by.intexsoft.progcomm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prog_lang")
public class ProgLangEntity extends AbstractEntity{

	private static final long serialVersionUID = -7512471965538551694L;
	
	@Column(name="prog_lang")
	public String prog_lang;

}
