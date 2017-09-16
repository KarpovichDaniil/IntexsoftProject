package main.java.by.intexsoft.adsboard.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "goods")
public class GoodsEntity extends AbstractEntity {

	private static final long serialVersionUID = -5421936681937235163L;

	@Column(name = "title")
	public String title;

	@Column(name = "description")
	public String description;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	public CitiesEntity city_id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public UsersEntity user_id;

	@Column(name = "price")
	public BigDecimal price;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	public Date created_date;
	
	@ManyToMany(fetch = EAGER)
	@JoinTable(
			name = "goods_categories",
			joinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
	)
	public List<CategoriesEntity> categories;
}
