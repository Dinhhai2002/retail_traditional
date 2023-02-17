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
@Table(name="warehouse_session_details")
public class WarehouseSessionDetail extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "warehouse_session_id")
	private long warehouseSessionId;
	
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
	
	private float quantity;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "warehouse_session_type")
	private int warehouseSessionType;
	
	@Column(name = "warehouse_session_status")
	private int warehouseSessionStatus;

}
