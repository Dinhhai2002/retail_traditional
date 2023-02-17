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
@Table(name="order_details")
public class OrderDetail extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "order_id")
	private long orderId;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;

	@Column(name = "material_unit_id")
	private int materialUnitId;

	@Column(name = "material_unit_name")
	private String materialUnitName;

	@Column(name = "material_id")
	private int materialId;

	@Column(name = "material_name")
	private String materialName;

	private double price;

	@Column(name = "cost_price")
	private double costPrice;

	private int quantity;

	private int type;

	@Column(name = "total_cost_price_amount")
	private double totalCostPriceAmount;

	@Column(name = "total_amount")
	private double totalAmount;

	private int status;


}
