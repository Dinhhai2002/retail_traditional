package vn.aloapp.training.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="materials")
public class Material extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String code;

	private String name;

	@Column(name = "prefix_name")
	private String prefixName;

	@Column(name = "normalize_name")
	private String normalizeName;

	@Column(name = "user_id")
	private int userId;

	private String avatar;

	@Column(name = "avatar_thumb")
	private String avatarThumb;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "unit_id")
	private int unitId;

	@Column(name = "wastage_rate")
	private String wastageRate;

	@Column(name = "out_stock_alert_quantity")
	private String outStockAlertQuantity;

	@Column(name = "retail_price")
	private String retailPrice;

	@Column(name = "cost_price")
	private String costPrice;

	private int status;


}
