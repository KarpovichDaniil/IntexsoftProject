
package by.intexsoft.adsboard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "goods")
public class Goods extends AbstractEntity {

	private static final long serialVersionUID = -5421936681937235163L;

	@Column(name = "title")
	public String title;

	@Column(name = "description")
	public String description;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	public Cities city;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public Users user;
	
	@Column(name = "phone")
	public String phone;

	@Column(name = "price")
	public Double price;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	public Date created_date;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	public Categories category;
}
