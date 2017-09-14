package by.intexsoft.progcomm.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "programmer")
public class ProgrammerEntity extends AbstractEntity {

	private static final long serialVersionUID = -5421936681937235163L;

	@Column(name = "last_name")
	public String last_name;

	@Column(name = "first_name")
	public String first_name;

	@Column(name = "gender")
	public String gender;

	@Temporal(TemporalType.DATE)
	public Date date;

	@ManyToOne
	@JoinColumn(name = "company_id")
	public CompanyEntity company_id;

	@ManyToOne
	@JoinColumn(name = "post_id")
	public PostEntity post_id;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "programmer_prog_lang", joinColumns = @JoinColumn(name = "programmer_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "prog_lang_id", referencedColumnName = "id"))
	public Set<ProgLangEntity> prog_lang;
}
